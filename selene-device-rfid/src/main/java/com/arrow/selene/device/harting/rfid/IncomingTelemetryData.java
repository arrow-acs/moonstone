package com.arrow.selene.device.harting.rfid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.arrow.acn.client.IotParameters;
import com.arrow.selene.data.Telemetry;
import com.arrow.selene.engine.DeviceDataAbstract;

public class IncomingTelemetryData extends DeviceDataAbstract {
	private Map<String, String> data;

	public IncomingTelemetryData(Map<String, String> data) {
		this.data = data;
	}

	@Override
	public IotParameters writeIoTParameters() {
		IotParameters result = new IotParameters();
		if (data != null) {
			for (Entry<String, String> entry : data.entrySet()) {
				result.put(entry.getKey(), entry.getValue());
			}
			result.setDirty(true);
		}
		return result;
	}

	@Override
	public List<Telemetry> writeTelemetries() {
		List<Telemetry> result = new ArrayList<>();
		if (data != null) {
			for (Entry<String, String> entry : data.entrySet()) {
				result.add(writeRawTelemetry(entry.getKey(), entry.getValue()));
			}
		}
		return result;
	}
}
