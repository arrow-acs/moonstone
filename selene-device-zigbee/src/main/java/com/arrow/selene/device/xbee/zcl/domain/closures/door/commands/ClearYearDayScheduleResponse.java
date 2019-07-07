package com.arrow.selene.device.xbee.zcl.domain.closures.door.commands;

import org.apache.commons.lang3.Validate;

import com.arrow.selene.device.xbee.zcl.ClusterSpecificCommand;

public class ClearYearDayScheduleResponse extends ClusterSpecificCommand<ClearYearDayScheduleResponse> {
	private byte[] status = new byte[1];

	public byte[] getStatus() {
		return status;
	}

	public ClearYearDayScheduleResponse withStatus(byte status) {
		this.status[0] = status;
		return this;
	}

	@Override
	protected int getId() {
		return DoorLockClusterCommands.CLEAR_YEARDAY_SCHEDULE_RESPONSE_COMMAND_ID;
	}

	@Override
	public byte[] toPayload() {
		return status;
	}

	@Override
	protected ClearYearDayScheduleResponse fromPayload(byte[] payload) {
		Validate.notNull(payload, "payload is null");
		Validate.isTrue(payload.length == 1, "payload length is incorrect");
		status = payload;
		return this;
	}
}
