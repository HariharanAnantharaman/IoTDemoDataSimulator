package com.techolution.data.vo;

import java.io.Serializable;

import com.google.gson.Gson;

public class CescTrnData implements Serializable {
private String deviceId;
private int temperature;
private int moisture;
private int oilTemp;
private String vibration;
private String timeStamp;
public CescTrnData(String dldData, int temperature, int moisture, int oilTemp, String vibration, String timeStamp,
		String type, String power) {
	super();
	this.deviceId = dldData;
	this.temperature = temperature;
	this.moisture = moisture;
	this.oilTemp = oilTemp;
	this.vibration = vibration;
	this.timeStamp = timeStamp;
	this.type = type;
	this.power = power;
}
public String getDeviceId() {
	return deviceId;
}
public void setDeviceId(String deviceId) {
	this.deviceId = deviceId;
}

public int getTemperature() {
	return temperature;
}
public void setTemperature(int temperature) {
	this.temperature = temperature;
}
public int getMoisture() {
	return moisture;
}
public void setMoisture(int moisture) {
	this.moisture = moisture;
}
public int getOilTemp() {
	return oilTemp;
}
public void setOilTemp(int oilTemp) {
	this.oilTemp = oilTemp;
}
public String getVibration() {
	return vibration;
}
public void setVibration(String vibration) {
	this.vibration = vibration;
}
public String getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(String timeStamp) {
	this.timeStamp = timeStamp;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPower() {
	return power;
}
public void setPower(String power) {
	this.power = power;
}
private String type;
private String power;

@Override
public String toString() {
	Gson gson = new Gson();
    return gson.toJson(this);
}

}
