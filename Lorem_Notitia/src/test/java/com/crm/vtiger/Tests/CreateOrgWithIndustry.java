package com.crm.vtiger.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtillity;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrgWithIndustry extends BaseClass{
	
	@Test
	public void createOrgWithInd() throws Throwable
	{
		WebDriverUtility wdu = new WebDriverUtility();
		JavaUtillity ju = new JavaUtillity();
		FileUtility futil= new FileUtility();
		String url = futil.getDataFromJson("url");
		String username = futil.getDataFromJson("username");
		String password = futil.getDataFromJson("password");
		ExcelUtility eutil = new ExcelUtility();
		String orgName = eutil.getExcelData("Sheet1", 5, 2);
		String indType =eutil.getExcelData("Sheet1", 5, 3);
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		//lunch Browser
		String browserName=futil.getPropertyKeyValue("browser");
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// To get into URL
		driver.get(url);
		
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();  
		
		//navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
				
		//Create Organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+ju.getRandomData());
		
		WebElement single = driver.findElement(By.name("industry"));
//		Select s1 = new Select(single);
//		s1.selectByIndex(6);
		wdu.SelectOption(single, indType);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	//	driver.findElement(By.linkText("Organizations")).click();
	//	driver.close();
		
	}

}
