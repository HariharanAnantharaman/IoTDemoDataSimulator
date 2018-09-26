package com.techolution.data.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.gson.Gson;

public class GenericData implements Serializable {
	
	public String deviceId;
	public String timeStamp;
	public String n;
	public String u;
	public double v;
	
	public GenericData(String deviceId, Calendar timeStamp, String n, String u, double v) {
		super();
		this.deviceId = deviceId;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
		this.timeStamp = DATE_FORMAT.format(timeStamp.getTime());
	//	this.timeStamp = timeStamp;
		this.n = n;
		this.u = u;
		this.v = v;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
	    return gson.toJson(this);
	}

}
