package com.arrow.selene.device.xbee.zcl.domain.general.basic.commands;

import com.arrow.selene.device.xbee.zcl.NoPayloadCommand;

public class ResetToFactoryDefaults extends NoPayloadCommand {
	@Override
	protected int getId() {
		return BasicClusterCommands.RESET_TO_FACTORY_DEFAULTS_COMMAND_ID;
	}
}
