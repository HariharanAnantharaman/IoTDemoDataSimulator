package com.techolution.device.actions;

import java.util.Calendar;

public class Util {
	
	private static String DASH="-";
	private static String HYPHEN=":";
	public static int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	public static String getTimeStamp(){
		
		Calendar time=Calendar.getInstance();
	//	long timeToSend=time.getTimeInMillis();
		StringBuilder timeInSec=new StringBuilder();
		timeInSec.append(time.get(Calendar.YEAR));
		timeInSec.append(DASH);
		
		timeInSec.append(time.get(Calendar.MONTH)+1);
		timeInSec.append(DASH);
		timeInSec.append(time.get(Calendar.DATE));
		timeInSec.append(HYPHEN);
		timeInSec.append(time.get(Calendar.HOUR_OF_DAY));
		timeInSec.append(HYPHEN);
		timeInSec.append(time.get(Calendar.MINUTE));
		timeInSec.append(HYPHEN);
		timeInSec.append(time.get(Calendar.SECOND));
		String timeInSecToSend=timeInSec.toString();
		return timeInSecToSend;
	}

}
