package Lorem_Notitia.Lorem_Notitia;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MakeMyTrip  {
	@Test
	public void makeMytripPlace() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// Taking the current date
		Date datobj =new Date();
		System.out.println(datobj.toString());
		
		// Separating the Date
		String currentSysdate = datobj.toString();
		String[] arr=currentSysdate.split("");
		
		String day =arr[0];
		String month=arr[1];
		String date=arr[2];
		String year= arr[5];

		System.out.println(day+" "+month+" "+date+" "+year);

		String currentdate=day+" "+month+" "+date+" "+year;
		
		// To get into URL
		driver.get("https://www.makemytrip.com/flights/");

		//To click on the screen
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("HYD");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'HYD')]")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("PNQ");
		driver.findElement(By.xpath("//div[contains(text(),'PNQ')]")).click();

		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

//	    driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
//      Thread.sleep(1000);
//      driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		
		
//	    driver.findElement(By.xpath("//div[@aria-label='Tue Jul 27 2021']")).click();
		  //div[@class='DayPicker-Day DayPicker-Day--today']

		  //div[@aria-label='Tue Apr 27 2021']

	driver.findElement(By.xpath("//div[@aria-label='"+currentdate+"']")).click();

//		  int count = 0;
//		  while(count<11)
//		  {
//		  
//		   try 
//		   {
//		    driver.findElement(By.xpath("//div[@aria-label='Tue Jul 27 2021']")).click();
//		    break;
//		   }
//		   
//		   catch(Exception e) 
//		   {
//		    driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
//		    count++;
//		   }
//		   
//		  }




		
	
	}

}
