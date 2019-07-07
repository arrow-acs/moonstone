package com.arrow.selene.device.xbee.zcl.domain.general.pollcontrol.commands;

import com.arrow.selene.device.xbee.zcl.NoPayloadCommand;

public class FastPollStop extends NoPayloadCommand {
	@Override
	protected int getId() {
		return PollControlClusterCommands.FAST_POLL_STOP_COMMAND_ID;
	}
}
