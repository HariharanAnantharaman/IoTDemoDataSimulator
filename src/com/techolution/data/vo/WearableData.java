package com.techolution.data.vo;

import java.io.Serializable;

import com.google.gson.Gson;

public class WearableData implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int temperature;
	private int heartbate;
	private String deviceId;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	//private String oreVolume;
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
	public WearableData(String deviceId,int temperature, int heartbate) {
		this.deviceId=deviceId;
		this.temperature = temperature;
		this.heartbate = heartbate;
	}
	@Override
	public String toString() {
		Gson gson = new Gson();
	    return gson.toJson(this);
	}
	
	
	
}
