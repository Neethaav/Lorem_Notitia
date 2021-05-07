package com.crm.vtiger.Tests;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;




public class TC_10_CreatePurOrderWithItemAndClickOnUpwardSymbol extends BaseClass {
		
		@Test
		public void createPurOrderWithItemDel() throws Throwable
		{
			
			//Click on More
			WebElement more1 = driver.findElement(By.xpath("//a[text()='More']"));
			wdu.mouseOver(driver, more1);
			
			//Navigate to Purchase
			driver.findElement(By.xpath("(//a[text()='Purchase Order'])[1]")).click();
			driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
			
			//
			driver.findElement(By.name("subject")).sendKeys("ThinkPad");
			driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
			
			//In the Vendor window
			wdu.switchToWindow(driver,"Vendor");
			driver.findElement(By.xpath("//table[@class='small']/tbody/tr[2]/td[1]/a")).click();
			
			//Enter the Address 
			wdu.waitUntilPageLoad(driver);
			
			wdu.switchToWindow(driver, "Purchase Order");
			driver.findElement(By.xpath("//table[@class='small']/tbody/tr[11]/td[2]/textarea")).sendKeys("A&B Block Amma Complex");
			driver.findElement(By.xpath("//table[@class='small']/tbody/tr[11]/td[4]/textarea")).sendKeys("A&B Block Amma Complex");
		
			//Add services from symbol
			driver.findElement(By.xpath("//input[@value='Add Service']")).click();
			
			driver.findElement(By.id("searchIcon2")).click();
			wdu.switchToWindow(driver,"Services");
			driver.findElement(By.xpath("//table[@class='small']/tbody/tr[3]/td[1]/input")).click();
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			wdu.switchToWindow(driver,"Services");
			
			driver.findElement(By.id("qty2")).sendKeys("1");
			
			//Click on Upward
			driver.findElement(By.xpath("//*[@id=\"row2_col1\"]/a")).click();
			
			//Delete the Add services
			driver.findElement(By.xpath("//table[@id='proTab']/tbody/tr[@id='row2']/td/img")).click();
			
			//Save the data
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
			
			//signout
			WebElement adm = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img"));
			wdu.mouseOver(driver, adm);
			driver.findElement(By.xpath("//*[@id=\"ondemand_sub\"]/table/tbody/tr[2]/td/a")).click();
		}

}
