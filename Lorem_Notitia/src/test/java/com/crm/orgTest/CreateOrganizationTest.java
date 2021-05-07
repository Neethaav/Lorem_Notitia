package com.crm.orgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class CreateOrganizationTest extends BaseClass{
	@Test(groups = "smokeTest")
	public void createOrganization() throws Throwable
	{
		String orgName=eutil.getExcelData("org", 1, 2);
		//navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//Create Organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+js.getRandomData());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	
		//verification
		wdu.waitForElementVisibility(driver, driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    
	    Assert.assertTrue(expData.contains(orgName));
	    
	    Reporter.log("the expected data is"+expData , true);	
		driver.findElement(By.linkText("Organizations")).click();
		
		
	}
		
		@Test(groups = "regressionTest" )
		public void createOrgWithInd()throws Throwable
		{
			String orgName = eutil.getExcelData("org", 4, 2);
			String indType =eutil.getExcelData("org", 4, 3);
			//navigate to Organization
			driver.findElement(By.linkText("Organizations")).click();
						
				//Create Organization
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(orgName+js.getRandomData());
				
				WebElement industry=driver.findElement(By.name("industry"));
				wdu.SelectOption(industry, indType);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				  //verification
				wdu.waitForElementVisibility(driver, driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
				String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			    //Assert.assertTrue(expData.contains(orgName));
			    
			    Assert.assertTrue(expData.contains(orgName));
			    
			    Reporter.log("the expected data is"+expData , true);	
			}
}

