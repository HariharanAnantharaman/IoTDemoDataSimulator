package com.techolution.device.actions;

import com.microsoft.azure.iothub.IotHubEventCallback;
import com.microsoft.azure.iothub.IotHubStatusCode;

public class EventCallBack implements IotHubEventCallback {

	public void execute(IotHubStatusCode status, Object context) {
		// TODO Auto-generated method stub
		System.out.println("IoT Hub responded to message with status: " + status.name()+":Time:"+System.currentTimeMillis());

	    if (context != null) {
	      synchronized (context) {
	        context.notify();
	      }
	    }

	}

}
