package com.arrow.selene.device.xbee.zcl.domain.general.powerprofile.commands;

import com.arrow.selene.device.xbee.zcl.NoPayloadCommand;

public class GetOverallSchedulePrice extends NoPayloadCommand {
	@Override
	protected int getId() {
		return PowerProfileClusterCommands.GET_OVERALL_SCHEDULE_PRICE_COMMAND_ID;
	}
}
