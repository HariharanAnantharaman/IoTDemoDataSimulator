package com.techolution.device.actions;

import java.io.IOException;
import java.net.URISyntaxException;

import com.microsoft.azure.iothub.IotHubClientProtocol;


public interface ISendMetricsData {
	
	public void sendData(DeviceData deviceData,IotHubClientProtocol protocol)throws URISyntaxException,IOException;

}
