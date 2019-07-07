package com.arrow.selene.device.xbee.zcl.domain.general.power.attributes;

import com.arrow.selene.device.sensor.DoubleSensorData;
import com.arrow.selene.device.xbee.zcl.data.Attribute;
import com.arrow.selene.engine.EngineConstants;
import com.digi.xbee.api.utils.ByteUtils;

public class BatteryPercentageRemaining implements Attribute<DoubleSensorData> {
	private static final double TO_PERCENT_SCALE = 100 / 0xc8;

	public static double calculate(int value) {
		return value * TO_PERCENT_SCALE;
	}

	public static double calculate(byte... value) {
		return calculate(Short.toUnsignedInt(ByteUtils.byteArrayToShort(ByteUtils.swapByteArray(value))));
	}

	@Override
	public int getId() {
		return PowerConfigClusterAttributes.BATTERY_PERCENTAGE_REMAINING_ATTRIBUTE_ID;
	}

	@Override
	public DoubleSensorData toData(String name, byte... value) {
		return new DoubleSensorData(name, calculate(value), EngineConstants.FORMAT_DECIMAL_2);
	}
}
