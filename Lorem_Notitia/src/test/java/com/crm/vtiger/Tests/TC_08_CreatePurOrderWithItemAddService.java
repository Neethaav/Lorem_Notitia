package com.crm.vtiger.Tests;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;



public class TC_08_CreatePurOrderWithItemAddService extends BaseClass {
	
	
	
	@Test
	public void createPurOrderWithItemAddser() throws Throwable
	{
		
	
		//Click on More
		WebElement more1 = driver.findElement(By.xpath("//a[text()='More']"));
		wdu.mouseOver(driver, more1);
		
		//Navigate to Purchase
		driver.findElement(By.xpath("(//a[text()='Purchase Order'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
		
		//
		driver.findElement(By.name("subject")).sendKeys("Hp");
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		//In the Vendor window
		wdu.switchToWindow(driver,"Vendor");
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[2]/td[1]/a")).click();
		
		//Enter the Address 
		wdu.waitUntilPageLoad(driver);
		
		wdu.switchToWindow(driver, "Purchase Order");
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[11]/td[2]/textarea")).sendKeys("A&B Block Amma Complex");
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[11]/td[4]/textarea")).sendKeys("A&B Block Amma Complex");
		
		driver.findElement(By.id("searchIcon1")).click();
		
		//Add Product from table
		wdu.switchToWindow(driver,"Products");
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[4]/td[1]/input")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		wdu.switchToWindow(driver, "Purchase Order");
		driver.findElement(By.xpath("//input[@class='detailedViewTextBoxOn']")).sendKeys("1");
		
		//Add services from symbol
		driver.findElement(By.xpath("//input[@value='Add Service']")).click();
		
		driver.findElement(By.id("searchIcon2")).click();
		wdu.switchToWindow(driver,"Services");
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[3]/td[1]/input")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		wdu.switchToWindow(driver,"Services");
		
		driver.findElement(By.id("qty2")).sendKeys("1");
		
		//Save the data
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		//signout
		WebElement adm = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img"));
		wdu.mouseOver(driver, adm);
		driver.findElement(By.xpath("//*[@id=\"ondemand_sub\"]/table/tbody/tr[2]/td/a")).click();
	
	}
}
