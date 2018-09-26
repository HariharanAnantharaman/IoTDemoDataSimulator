package com.techolution.device.actions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.azure.iothub.IotHubClientProtocol;
public class SendDataApplication {

	
	
	//private static IotHubClientProtocol protocol = IotHubClientProtocol.AMQPS;
	private static IotHubClientProtocol protocol = IotHubClientProtocol.MQTT;
	//private static IotHubClientProtocol protocol = IotHubClientProtocol.HTTPS;
	//private static IotHubClientProtocol protocol = IotHubClientProtocol.HTTPS;
	
	public static void main(String[] args) throws URISyntaxException,IOException {
		// TODO Auto-generated method stub
		int i=0;
		ISendMetricsData sendStage1Data=new SendRouteData();
		//ISendMetricsData sendStage1Data=new SendGenericData();
		while(i<10){
			List<DeviceData> devices=getDevices();
			try {
			for(DeviceData data:devices){
				
				sendStage1Data.sendData(data, protocol);
				Thread.sleep(2000);
			}
			
			
			
			
			
				//Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			i++;
			
		}
	}
	
	private static List<DeviceData> getDevices(){
		
		/*DeviceData deviceData1=new DeviceData("tcsdemo23061027.azure-devices.net", "2yOgAZr9sHs8i9e6X90oUqe5iBC62JXMYqpH6GpfKKU=", "device1","Line1Machine1");
		DeviceData deviceData2=new DeviceData("tcsdemo23061027.azure-devices.net", "MYUxGyCgJbLfnUCCsoyxQlhyCFZORKkJ4fxg0i/eTz4=", "device2","Line2Machine1");*/
		/*DeviceData deviceData1=new DeviceData("IoTHubDemo23.azure-devices.net", "8JUF8a3G7Ygkhx79iN5zsqkdydBEIifB9/o+qJmXfB0=", "device1","Line1Machine1");
		DeviceData deviceData2=new DeviceData("IoTHubDemo23.azure-devices.net", "zQ8oxMTpWOXLLC6t1zQgQP/Z2TDqHY+Lxc0rN3746o8=", "Device2","Line2Machine1");*/
		
		/*DeviceData deviceData1=new DeviceData("DevTestIoTHub.azure-devices.net", "xMLmgDyGOhoENwJaiiSXJ0CkhYX2if9niIWEUThU3TY=", "DevTestDevice1","Line1Machine1");
		DeviceData deviceData2=new DeviceData("DevTestIoTHub.azure-devices.net", "2yRII7VusaeH3794VIuzDdqzb83fba20x+LsMCDfYWE=", "DevTestDevice2","Line2Machine1");
			*/
		DeviceData deviceData1=new DeviceData("techo-iothub.azure-devices.net", "oI5PtzgjW0p5s0a9D2G3UNGHWmj3to2kQp48l/2Zhm0=", "cescpocdevice","Line1Machine1");
		//DeviceData deviceData1=new DeviceData("techo-iothub.azure-devices.net", "Jh8KJbwrH8wNpElZlQbwXCyXY7qo5HxEug/R/igYgRs=", "techo_smartfarming_soilmoisture_001","Line1Machine1");
		//DeviceData deviceData1=new DeviceData("hariblockchainiottest.azure-devices.net", "Kt8kyy+9TZRrhUVaWFOYTM/C9Om3U3qteJrFVoqkwok=", "testdevice","Line1Machine1");
		List<DeviceData> devicesList=new ArrayList<DeviceData>();
		devicesList.add(deviceData1);
		//devicesList.add(deviceData2);
		return devicesList;
	}
	
   
   
  
}
