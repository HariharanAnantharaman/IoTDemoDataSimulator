package com.techolution.demo.create_device_identity_demo;

import java.io.IOException;
import java.net.URISyntaxException;

import com.microsoft.azure.iot.service.exceptions.IotHubException;
import com.microsoft.azure.iot.service.sdk.Device;
import com.microsoft.azure.iot.service.sdk.RegistryManager;

/**
 * Hello world!
 *
 */
public class RegisterBulkOfDevices 
{
	//GET FROM IOTHUB
	public static final String connectionString = "";
	//private static final String deviceId = "AndroidTestClient3";
	private static final String deviceIdPre = "Wearable0";
	public static void main( String[] args ) throws IOException, URISyntaxException, Exception
    {
        
		RegistryManager registryManager = RegistryManager.createFromConnectionString(connectionString);
		
		for (int i=1;i<=10;i++){
			String deviceId=deviceIdPre+i;
			Device device = Device.createFromId(deviceId, null, null);
			try {
			  device = registryManager.addDevice(device);
			} catch (IotHubException iote) {
				System.out.println("In exception after adding existing device");
			  try {
			    device = registryManager.getDevice(deviceId);
			  } catch (IotHubException iotf) {
			    iotf.printStackTrace();
			  }
			}
			System.out.println("Device id: " + device.getDeviceId());
			System.out.println("Device key: " + device.getPrimaryKey());	
		}

		
		
    }
}
