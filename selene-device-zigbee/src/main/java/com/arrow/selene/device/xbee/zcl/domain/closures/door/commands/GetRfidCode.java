package com.arrow.selene.device.xbee.zcl.domain.closures.door.commands;

import org.apache.commons.lang3.Validate;

import com.arrow.selene.device.xbee.zcl.ClusterSpecificCommand;
import com.digi.xbee.api.utils.ByteUtils;

public class GetRfidCode extends ClusterSpecificCommand<GetRfidCode> {
	private int userId;

	public int getUserId() {
		return userId;
	}

	public GetRfidCode withUserId(int userId) {
		this.userId = userId;
		return this;
	}

	@Override
	protected int getId() {
		return DoorLockClusterCommands.GET_RFID_COMMAND_ID;
	}

	@Override
	public byte[] toPayload() {
		return ByteUtils.swapByteArray(ByteUtils.shortToByteArray((short) userId));
	}

	@Override
	protected GetRfidCode fromPayload(byte[] payload) {
		Validate.notNull(payload, "payload is null");
		Validate.isTrue(payload.length == 2, "payload length is incorrect");
		userId = ByteUtils.byteArrayToInt(ByteUtils.swapByteArray(payload));
		return this;
	}
}
