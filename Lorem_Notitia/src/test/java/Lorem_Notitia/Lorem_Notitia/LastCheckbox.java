package Lorem_Notitia.Lorem_Notitia;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class LastCheckbox {
	@Test
	public void lastCheckBox()
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
		 List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
	
		 int count = list.size();
		 
			 list.get(count-1).click();
		 
	}

}
