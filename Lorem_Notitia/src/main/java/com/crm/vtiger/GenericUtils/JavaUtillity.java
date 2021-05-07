package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtillity {
	
	public static String getRandomData()
	{
		Random random = new Random();
		int ran = random.nextInt(1000);
		return ""+ran;
	}
	
	public String getCurrentSystemDate()
	{
		Date date=new Date();
		String currentDate =date.toString();
		return currentDate;
	}

}
