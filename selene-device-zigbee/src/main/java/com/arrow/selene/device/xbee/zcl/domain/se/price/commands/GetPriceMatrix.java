package com.arrow.selene.device.xbee.zcl.domain.se.price.commands;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.apache.commons.lang3.Validate;

import com.arrow.selene.device.xbee.zcl.ClusterSpecificCommand;

public class GetPriceMatrix extends ClusterSpecificCommand<GetPriceMatrix> {
	private long issuerTariffId;

	public long getIssuerTariffId() {
		return issuerTariffId;
	}

	public GetPriceMatrix withIssuerTariffId(long issuerTariffId) {
		this.issuerTariffId = issuerTariffId;
		return this;
	}

	@Override
	protected int getId() {
		return PriceClusterCommands.GET_PRICE_MATRIX_COMMAND_ID;
	}

	@Override
	public byte[] toPayload() {
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putInt((int) issuerTariffId);
		return buffer.array();
	}

	@Override
	public GetPriceMatrix fromPayload(byte[] payload) {
		Validate.notNull(payload, "payload is null");
		Validate.isTrue(payload.length == 4, "payload length is incorrect");
		ByteBuffer buffer = ByteBuffer.wrap(payload);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		issuerTariffId = Integer.toUnsignedLong(buffer.getInt());
		return this;
	}
}
