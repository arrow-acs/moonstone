package com.arrow.selene.device.xbee.zcl.domain.se.metering.commands;

import com.arrow.selene.device.xbee.zcl.NoPayloadCommand;

public class RemoveMirror extends NoPayloadCommand {
	@Override
	protected int getId() {
		return SimpleMeteringClusterCommands.REMOVE_MIRROR_COMMAND_ID;
	}
}
