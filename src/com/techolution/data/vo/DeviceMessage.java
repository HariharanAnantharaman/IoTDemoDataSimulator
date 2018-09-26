package com.techolution.data.vo;

import java.io.Serializable;

import com.google.gson.Gson;

public class DeviceMessage implements Serializable {

private Body appProperties;
	
	public Body getAppProperties() {
	return appProperties;
}

public void setAppProperties(Body appProperties) {
	this.appProperties = appProperties;
}

	/*public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
*/
	@Override
	public String toString() {
		Gson gson = new Gson();
	    return gson.toJson(this);
	}
	
	
}
