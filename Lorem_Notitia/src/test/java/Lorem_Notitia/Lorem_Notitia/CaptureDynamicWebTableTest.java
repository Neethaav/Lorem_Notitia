package Lorem_Notitia.Lorem_Notitia;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class CaptureDynamicWebTableTest extends BaseClass{
	/*
	@Test
	public void captureOrgName()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// To get into URL
		driver.get("http://localhost:8888");
		
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		// Capture all the Organization Name
		 List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
//		for(WebElement wl : list)
//		{
//			System.out.println(wl.getText());
//		}
	
		 int count = list.size();
		 for(int i=1; i<count; i++)
		 {
			 System.out.println(list.get(i).getText());
		 }	
	}

	@Test
	public void captureOrgNameValidate()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// To get into URL
		driver.get("http://localhost:8888");
		
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		// Capture all the Organization Name
		String expData = "AND";
		Boolean flag = false;
		 List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
	
		 for(WebElement wb:list)
		 {
			 String actData = wb.getText();
			 if(expData.equals(actData))
			 {
				 wb.click();
				 flag=true;
				 break;
			 }
		 }
		 if(flag ==true)
		 {
			 System.out.println("Organization is present");
		 }
		 else
		 {
			 System.out.println("Organization name is not present");
		 }
	}

	
	
	
	@Test
	public void captureOrgNameDel()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// To get into URL
		driver.get("http://localhost:8888");
		
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		// Capture all the Organization Name
		String expData = "AND";
		Boolean flag = false;
		
	
		 List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		 
		 for(WebElement wb:list)
		 {
			 String actData = wb.getText();
			 if(expData.equals(actData))
			 {
				 wb.click();
				 flag=true;
				 driver.findElement(By.xpath("(//input[@value='Delete'])[2]")).click();
				 driver.switchTo().alert().accept();  
				 break;
			 }
		 }
		 if(flag ==true)
		 {
			 System.out.println("Organization is deleted");
		 }
		 else
		 {
			 System.out.println("Organization name is not deleted");
		 }
	}
*/
	
	@Test
	public void captureOrgNameDel()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// To get into URL
		driver.get("http://localhost:8888");
		
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		// Capture all the Organization Name
		String expData = "AND";
		Boolean flag = false;
		int actRowCount =0;
		
	
		 List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		 
		 for(WebElement wb:list)
		 {
			 String actData = wb.getText();
			 if(expData.equals(actData))
			 {
				 wb.click();
				 flag=true;
				 driver.findElement(By.xpath("(//input[@value='Delete'])[2]")).click();
				 driver.switchTo().alert().accept();  
				 break;
			 }
		 }
		 if(flag ==true)
		 {
			 System.out.println("Organization is deleted");
		 }
		 else
		 {
			 System.out.println("Organization name is not deleted");
		 }
	}
	
}


