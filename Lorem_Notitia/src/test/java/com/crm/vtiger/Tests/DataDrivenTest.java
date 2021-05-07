package com.crm.vtiger.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	@DataProvider
	public Object[][] getData()
	{
		Object[][] arr = new Object[2][2];
		arr[0][0]="Test Yantra";
		arr[0][1]="Tecnology";
		arr[1][0]="Amazon";
		arr[1][1]="E-Commerce";
		return arr;
	}
	
	@Test(dataProvider = "getData")
	public void test(String a,String b) {
		System.out.println(a+"\t"+b);
	}
}
