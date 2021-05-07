package com.crm.vtiger.Tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;


public class CreateContactWithOrg extends BaseClass{
	
	@Test
	public void createContactWithOrg() throws Throwable
	{
		
		String orgName = eutil.getExcelData("Sheet1", "TC_02", "OrganizationName");
		String lastName =eutil.getExcelData("Sheet1", "TC_02", "lastName");
		
		//Navigate to Contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Create Contact
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		wdu.switchToWindow(driver,"Account");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		wdu.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.close();
		
		
	}

}
