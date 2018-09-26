package com.techolution.data.vo;

import java.io.Serializable;

import com.google.gson.Gson;

public class TelemetryData implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DeviceMessage devicemessage;
	
	
	public DeviceMessage getDevicemessage() {
		return devicemessage;
	}


	public void setDevicemessage(DeviceMessage devicemessage) {
		this.devicemessage = devicemessage;
	}


	@Override
	public String toString() {
		Gson gson = new Gson();
	    return gson.toJson(this);
	}
	
	
	
}
