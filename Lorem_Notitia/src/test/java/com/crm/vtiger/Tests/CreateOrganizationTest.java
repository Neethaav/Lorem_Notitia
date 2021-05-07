package com.crm.vtiger.Tests;



import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;



public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public void createOrganization()
	{
		
		
		//navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//Create Organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("techMec");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		driver.findElement(By.linkText("Organizations")).click();
		//Close the Browser
		driver.close();
		
	}

}
