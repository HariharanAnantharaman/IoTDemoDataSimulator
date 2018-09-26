package com.techolution.device.actions;

public class DeviceData {
	
	private String hostname;
	private String SharedAccessKey;
	private String deviceId;
	public String getDeviceAlias() {
		return deviceAlias;
	}

	private String deviceAlias; 
	
	public DeviceData(String hostname,String SharedAccessKey,String deviceId,String deviceAlias){
		this.hostname=hostname;
		this.SharedAccessKey=SharedAccessKey;
		this.deviceId=deviceId;
		this.deviceAlias=deviceAlias;
	}



	public String getHostname() {
		return hostname;
	}



	public void setHostname(String hostname) {
		this.hostname = hostname;
	}



	public String getSharedAccessKey() {
		return SharedAccessKey;
	}

	public void setSharedAccessKey(String sharedAccessKey) {
		SharedAccessKey = sharedAccessKey;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public String getConnectionString(){
		StringBuilder builder=new StringBuilder();
		builder.append("HostName=");
		builder.append(hostname);
		builder.append(";");
		builder.append("DeviceId=");
		builder.append(deviceId);
		builder.append(";SharedAccessKey=");
		builder.append(SharedAccessKey);
		return builder.toString();
	}

}
