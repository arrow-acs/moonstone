package com.arrow.selene.device.xbee.zcl.domain.lighting.color.attributes;

import com.arrow.selene.device.sensor.DoubleSensorData;
import com.arrow.selene.device.xbee.zcl.data.Attribute;
import com.arrow.selene.engine.EngineConstants;

public class CurrentSaturation implements Attribute<DoubleSensorData> {
	private static final double SCALE = 1.0 / 254.0;

	public static double calculate(byte... value) {
		return Byte.toUnsignedInt(value[0]) * SCALE;
	}

	@Override
	public int getId() {
		return LightingColorClusterAttributes.CURRENT_SATURATION_ATTRIBUTE_ID;
	}

	@Override
	public DoubleSensorData toData(String name, byte... value) {
		return new DoubleSensorData(name, calculate(value), EngineConstants.FORMAT_DECIMAL_2);
	}
}
