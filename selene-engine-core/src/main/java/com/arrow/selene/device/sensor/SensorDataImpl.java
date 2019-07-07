package com.arrow.selene.device.sensor;

import java.util.ArrayList;
import java.util.List;

import com.arrow.acn.client.IotParameters;
import com.arrow.selene.data.Telemetry;
import com.arrow.selene.engine.DeviceDataAbstract;

public class SensorDataImpl<Data extends SensorData<?>> extends DeviceDataAbstract {
	private List<Data> sensorDataList = new ArrayList<>();

	public SensorDataImpl(List<Data> sensorDataList) {
		if (sensorDataList != null) {
			this.sensorDataList = sensorDataList;
		}
	}

	protected void addSensorData(Data sensorData) {
		if (sensorData != null) {
			sensorDataList.add(sensorData);
		}
	}

	public List<Data> getSensorDataList() {
		return sensorDataList;
	}

	@Override
	public IotParameters writeIoTParameters() {
		IotParameters parameters = new IotParameters();
		for (SensorData<?> sensorData : sensorDataList) {
			sensorData.writeIoTParameters(parameters);
		}
		return parameters;
	}

	@Override
	public List<Telemetry> writeTelemetries() {
		List<Telemetry> result = new ArrayList<>();
		for (SensorData<?> sensorData : sensorDataList) {
			sensorData.writeTelemetry(result, getTimestamp());
		}
		return result;
	}
}
