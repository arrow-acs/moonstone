package com.arrow.selene.device.xbee.zcl.domain.general.groups.attributes;

import com.arrow.selene.device.sensor.BooleanSensorData;
import com.arrow.selene.device.xbee.zcl.data.Attribute;

public class NameSupport implements Attribute<BooleanSensorData> {
	public static boolean isGroupNameSupported(byte... value) {
		return (value[0] & 0b1_0000000) != 0;
	}

	@Override
	public int getId() {
		return GroupsClusterAttributes.NAME_SUPPORT_ATTRIBUTE_ID;
	}

	@Override
	public BooleanSensorData toData(String name, byte... value) {
		return new BooleanSensorData(name, isGroupNameSupported(value));
	}
}
