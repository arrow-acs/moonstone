package com.arrow.selene.device.peripheral.devices;

import com.arrow.selene.device.peripheral.PeripheralStates;
import com.arrow.selene.engine.state.State;

public class LedStates extends PeripheralStates {
	private static final long serialVersionUID = -8136467084499998497L;

	private State led = new State();

	public State getLed() {
		return led;
	}

	public void setLed(State led) {
		this.led = led;
	}
}
