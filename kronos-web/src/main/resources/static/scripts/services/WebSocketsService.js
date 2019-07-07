/* global services, SockJS, Stomp */

(function () {
	'use strict';

	services.factory("WebSocketsService", WebSocketsService);

	/**
	 * SERVICE DESCRIPTION:
	 *
	 * Service purpose: Connect to WS/STOMP by using provided credentials
	 *
	 **/

	WebSocketsService.$inject = ["$q", "$timeout", "$cookies"];

	function WebSocketsService($q, $timeout, $cookies) {

		var STATE = {
			STARTED: 0,
			CONNECTED: 1,
			DISCONNECTED: 2,
			FINISHED: 3
		};

		function WSConnection(url, options) {
			var self = this;

			// state
			this.url = url;
			this.options = angular.extend({
				onConnect: undefined,
				onDisconnect: undefined,
				reconnect: true,
				reconnectTimeout: 10000 // 10 seconds
			}, options);
			this.state = STATE.STARTED;
			this.timer = null;

			function connect() {
				self.timer = null;

				if (self.state == STATE.FINISHED) return;

				// add _csrf parameter to let sockjs ajax-based transports pass CSRF filter
				self.sockjs = new SockJS(self.url + '?_csrf=' + $cookies.get('XSRF-TOKEN-KRONOS-WEB'), null, {
				    transports: ['websocket', 'xhr-streaming', 'eventsource', 'xhr-polling', 'xdr-streaming', 'xdr-polling']
				    // not working: iframe-eventsource, htmlfile, iframe-htmlfile, iframe-xhr-polling, jsonp-polling
				    // xdr-streaming and xdr-polling are kept just in case for IE 8, but they are not tested
				});
				self.stomp = Stomp.over(function() {
					return self.sockjs;
				});
				self.stomp.debug = false; // turn off console messages
				self.stomp.connect({}, onStompConnect, onStompDisconnect);
			}

			function onStompConnect() {
				if (self.state != STATE.FINISHED && self.state != STATE.CONNECTED) {
					self.state = STATE.CONNECTED;
					typeof self.options.onConnect == 'function' && self.options.onConnect();
				}
			}

			function onStompDisconnect() {
				if (self.state != STATE.FINISHED) {
					if (self.state != STATE.DISCONNECTED) {
						self.state = STATE.DISCONNECTED;
						typeof self.options.onDisconnect == 'function' && self.options.onDisconnect();
					}

					// reconnect
					if (self.options.reconnect) {
						self.timer = $timeout(connect, self.options.reconnectTimeout);
					}
				}
			}

			connect();
		}

		WSConnection.prototype.disconnect = function() {
			this.state = STATE.FINISHED;
			if (this.timer) {
				$timeout.cancel(this.timer);
				this.timer = null;
			}
			try {
				this.stomp.disconnect();
			} catch(e) {} // ignore
			try {
				this.sockjs.close();
			} catch(e) {} // ignore
		};

		WSConnection.prototype.isConnected = function() {
			return this.state == STATE.CONNECTED;
		};

		WSConnection.prototype.subscribe = function(destination, callback, headers) {
			headers = headers || {};
			return this.stomp.subscribe(
				destination,
				function(data) {
					callback(JSON.parse(data.body));
				},
				headers
			);
		};

		WSConnection.prototype.unsubscribe = function(subscription) {
			subscription.unsubscribe();
		};

		WSConnection.prototype.send = function(destination, body, headers) {
			headers = headers || {};
			// Note regarding incorrect date stringify:
			// see "known issue" here: https://docs.angularjs.org/api/ng/function/angular.toJson
			this.stomp.send(destination, headers, JSON.stringify(body));
		};

		return {
			connect: function(url, options) {
				return new WSConnection(url, options);
			}
		};
	}

})();
