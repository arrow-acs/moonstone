/*******************************************************************************
 * Copyright (c) 2018 Arrow Electronics, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License 2.0
 * which accompanies this distribution, and is available at
 * http://apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Arrow Electronics, Inc.
 *******************************************************************************/
package com.arrow.acs.client.api;

abstract class AcsApiAbstract extends ApiAbstract {
	protected static final String WEB_SERVICE_ROOT_URL = "/api/v1/pegasus";

	AcsApiAbstract(ApiConfig apiConfig) {
		super();
		setApiConfig(apiConfig);
	}
}