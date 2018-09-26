package com.techolution.device.actions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.microsoft.azure.iothub.DeviceClient;
import com.microsoft.azure.iothub.IotHubClientProtocol;
import com.microsoft.azure.iothub.Message;
import com.techolution.data.vo.CescTrnData;

public class SendCescData implements ISendMetricsData {

	private static DeviceClient client=null; 
	@Override
	public void sendData(DeviceData deviceData, IotHubClientProtocol protocol) throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
		if(client==null){
			client=new DeviceClient(deviceData.getConnectionString(), protocol);	
		}
		System.out.println("connection string is:"+deviceData.getConnectionString());
		client.open();
		
	
		int temperature=Util.randomWithRange(95, 100);
		int moisture=Util.randomWithRange(140, 160);
		int oiltemperature=Util.randomWithRange(95, 100);
		
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
	    String date = DATE_FORMAT.format(Calendar.getInstance().getTime());
		
		CescTrnData data=new CescTrnData("testfarming",temperature,moisture,oiltemperature,"normal",date+"Z","normal","online");
		String messageValue=data.toString();
		String farmingMessage="{\"deviceId\":\"techo_smartfarming_soilmoisture_001\",\"moisture\":\"80\"}";
	//	Message msg = new Message(messageValue);
		Message msg = new Message(farmingMessage);
		
		msg.setProperty("usagetype","platformtest");
		msg.setProperty("datatype","raw");
	
		System.out.println("Sending: " + messageValue);
		Object lockobj = new Object();
		EventCallBack callback = new EventCallBack();
		System.out.println(msg.getProperty("usagetype"));
		
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
