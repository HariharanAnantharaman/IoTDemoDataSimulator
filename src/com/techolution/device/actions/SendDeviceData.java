package com.techolution.device.actions;

import java.io.IOException;
import java.net.URISyntaxException;

import com.microsoft.azure.iothub.DeviceClient;
import com.microsoft.azure.iothub.IotHubClientProtocol;
import com.microsoft.azure.iothub.Message;
import com.techolution.data.vo.WearableData;

public class SendDeviceData implements ISendMetricsData {
	
	 private static DeviceClient client=null; 
	public void sendData(DeviceData deviceData, IotHubClientProtocol protocol) throws URISyntaxException, IOException {
		
		// TODO Auto-generated method stub
		if(client==null){
			client=new DeviceClient(deviceData.getConnectionString(), protocol);	
		}
		client.open();
		
	
		int temperature=Util.randomWithRange(98, 105);
		int heartbeat=Util.randomWithRange(140, 160);
		
		WearableData data=new WearableData(deviceData.getDeviceId(),temperature,heartbeat);
		String messageValue=data.toString();
		Message msg = new Message(messageValue);
		
		msg.setProperty("contentEncoding", "utf-8");
		//msg.setProperty("contentType","application/json");
		//msg.
	
		if(temperature>100){
			msg.setProperty("alert", "true");
		}else{
			msg.setProperty("alert", "false");
		}
		System.out.println("Sending: " + messageValue);
		System.out.println("Properties: " + msg.getProperty("alert"));
		Object lockobj = new Object();
		EventCallBack callback = new EventCallBack();
		//client.s
        client.sendEventAsync(msg, callback, lockobj);
		//client.sendEventAsync(msg, null, null);
       synchronized (lockobj) {
            try {
				lockobj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Finished.");
				e.printStackTrace();
			}
          }
        client.close();


	}

}
