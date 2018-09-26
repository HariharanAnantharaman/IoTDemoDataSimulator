package com.techolution.demo.create_device_identity_demo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import com.microsoft.azure.iot.service.exceptions.IotHubException;
import com.microsoft.azure.iot.service.sdk.Device;
import com.microsoft.azure.iot.service.sdk.RegistryManager;
import com.microsoft.azure.iothub.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodCallback;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodData;


/**
 * Hello world!
 *
 */
public class RegisterSingleDevice 
{
	//GET FROM IOTHUB
	private static final String connectionString = "HostName=techo-iothub.azure-devices.net;SharedAccessKeyName=iothubowner;SharedAccessKey=MJuN/GiKBUTie/K0ZWSqWGxZCxrjz2anDv3cZMpeQg4=";
	private static final String HUBNAME = "techo-iothub.azure-devices.net";
	private static final String deviceId = "rrsdemo2";
	public static void main( String[] args ) throws IOException, URISyntaxException, Exception
    {
        
		RegistryManager registryManager = RegistryManager.createFromConnectionString(connectionString);

		Device device = Device.createFromId(deviceId, null, null);
		try {
		  device = registryManager.addDevice(device);
		} catch (IotHubException iote) {
		  try {
		    device = registryManager.getDevice(deviceId);
		  } catch (IotHubException iotf) {
		    iotf.printStackTrace();
		  }
		}
		System.out.println("Device id: " + device.getDeviceId());
		System.out.println("Device key: " + device.getPrimaryKey());
		
		//HostName=techo-iothub.azure-devices.net;DeviceId=demodevice1;SharedAccessKey=auB0tuaKUSIxq+O4lSobJuWZeSTOzV7oC1OYwD2HKLM=
		String deviceconn="HostName="+HUBNAME+";DeviceId="+deviceId+";SharedAccessKey="+device.getPrimaryKey();
		com.microsoft.azure.sdk.iot.device.IotHubEventCallback callback=(IotHubStatusCode responseStatus, Object callbackContext) -> {
		 System.out.println("Received status code:"+responseStatus.name());	
		};
		DeviceMethodCallback dmcallBack =(String methodName,Object methodData,Object context )->{
		
		
			switch (methodName)
            {
                case "command" :
                {
                   System.out.println("In command method");
                    break;
                }
                case "test1" :{
                	
                	System.out.println("In test1");
                	break;
                }
                default:
                {
                	System.out.println("In default");
                	break;
                }
            }
			
			
			return new DeviceMethodData(1, "Executed method:"+methodName);
		
		};
		System.out.println("Before creating deviceclient");
		DeviceClient client = new DeviceClient(deviceconn, IotHubClientProtocol.MQTT);
		
		client.open();
		
		client.subscribeToDeviceMethod( dmcallBack, null,callback,null);
		
		System.out.println("After opening connection");
		
		System.out.println("Press any key to exit...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        client.close();
        System.out.println("Shutting down...");

    }
}
