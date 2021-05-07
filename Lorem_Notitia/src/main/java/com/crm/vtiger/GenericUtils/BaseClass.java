package com.crm.vtiger.GenericUtils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	public WebDriver driver;
	 public ExcelUtility eutil=new ExcelUtility();
	 public FileUtility futil=new FileUtility();
	 public WebDriverUtility wdu=new WebDriverUtility();
	 public JavaUtillity js = new JavaUtillity();
	 public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeTest" , "regressionTest"})
	public void ConfigDB()
	{
		//connect to DB
		System.out.println("CRM application");
	}
	
	@BeforeTest(groups = {"smokeTest" , "regressionTest"})
	public void configBT()
	{
	//	launch browser in parallel mode 
	}
	
//	@Parameters("browser")
	@BeforeClass(groups = {"smokeTest" , "regressionTest"})
//	public void ConfigBC(String browserName) throws Throwable
	public void ConfigBC() throws Throwable
	{
		//lunch Browser
				String browserName=futil.getPropertyKeyValue("browser");
				
				if(browserName.equalsIgnoreCase("firefox")) {
					driver=new FirefoxDriver();
				}else if(browserName.equalsIgnoreCase("chrome")) {
					driver=new ChromeDriver();
				}
				sdriver =driver;
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
	}
	
	@BeforeMethod(groups = {"smokeTest" , "regressionTest"})
	public void login() throws Throwable
	{
//		String browser = futil.getPropertyKeyValue("browser");
		String url = futil.getPropertyKeyValue("url");
		String username = futil.getPropertyKeyValue("username");
		String password = futil.getPropertyKeyValue("password");
		driver.get(url);
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	}

	@AfterMethod(groups = {"smokeTest" , "regressionTest"})
	public void tearDown() throws Throwable {
		
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdu.mouseOver(driver, administrator);
		wdu.waitAndClick(driver.findElement(By.xpath("//a[text()='Sign Out']")));
	}
	
	@AfterClass(groups = {"smokeTest" , "regressionTest"})
	public void ConfigAC()
	{
		driver.quit();
	}
	
	@AfterTest(groups = {"smokeTest" , "regressionTest"})
	 public void configAT() {
	  //close driver ref in parallel mode
	 }
	
	@AfterSuite(groups = {"smokeTest" , "regressionTest"})
	public void ConfigAS()
	{
		System.out.println("Close database");
	}
}
