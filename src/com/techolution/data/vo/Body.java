package com.techolution.data.vo;

import java.io.Serializable;

import com.google.gson.Gson;

public class Body implements Serializable {
	
	private int temperature;
	private int heartbate;
	private String deviceId;
	private String alert;
	public Body(String deviceId,int temperature, int heartbate) {
		super();
		this.temperature = temperature;
		this.heartbate = heartbate;
		this.deviceId = deviceId;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getHeartbate() {
		return heartbate;
	}
	public void setHeartbate(int heartbate) {
		this.heartbate = heartbate;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
	    return gson.toJson(this);
	}

}
