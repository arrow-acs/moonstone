package com.arrow.selene.device.xbee.zcl.domain.closures.window.commands;

import com.arrow.selene.device.xbee.zcl.NoPayloadCommand;

public class Stop extends NoPayloadCommand {
	@Override
	protected int getId() {
		return WindowCoveringClusterCommands.WINDOW_COVERING_STOP_COMMAND_ID;
	}
}
