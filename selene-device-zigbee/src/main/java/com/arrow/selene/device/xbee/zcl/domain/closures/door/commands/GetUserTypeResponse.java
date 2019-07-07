package com.arrow.selene.device.xbee.zcl.domain.closures.door.commands;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.apache.commons.lang3.Validate;

import com.arrow.selene.device.xbee.zcl.ClusterSpecificCommand;
import com.arrow.selene.device.xbee.zcl.domain.closures.door.data.UserType;

public class GetUserTypeResponse extends ClusterSpecificCommand<GetUserTypeResponse> {
	private int userId;
	private UserType userType;

	public int getUserId() {
		return userId;
	}

	public GetUserTypeResponse withUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public UserType getUserType() {
		return userType;
	}

	public GetUserTypeResponse withUserType(UserType userType) {
		this.userType = userType;
		return this;
	}

	@Override
	protected int getId() {
		return DoorLockClusterCommands.GET_USER_TYPE_RESPONSE_COMMAND_ID;
	}

	@Override
	public byte[] toPayload() {
		ByteBuffer buffer = ByteBuffer.allocate(3);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort((short) userId);
		buffer.put((byte) userType.ordinal());
		return buffer.array();
	}

	@Override
	protected GetUserTypeResponse fromPayload(byte[] payload) {
		Validate.notNull(payload, "payload is null");
		Validate.isTrue(payload.length == 3, "payload length is incorrect");
		ByteBuffer buffer = ByteBuffer.wrap(payload);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		userId = Short.toUnsignedInt(buffer.getShort());
		userType = UserType.values()[Byte.toUnsignedInt(buffer.get())];
		return this;
	}
}
