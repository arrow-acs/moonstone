package com.arrow.selene.device.libelium;

import com.arrow.selene.device.self.SelfModule;
import com.arrow.selene.engine.DeviceInfo;

public class MeshliumInfo extends DeviceInfo {
	private static final long serialVersionUID = 1261590608178021283L;

	public final static String DEFAULT_DEVICE_TYPE = "meshlium";

	public MeshliumInfo() {
		setType(DEFAULT_DEVICE_TYPE);
	}

	@Override
	public String getName() {
		return SelfModule.getInstance().getGateway().getName() + " Connector";
	}

	@Override
	public String getUid() {
		return SelfModule.getInstance().getGateway().getUid() + "-connector";
	}
}
