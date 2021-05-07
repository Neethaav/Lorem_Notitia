package com.crm.vtiger.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	/**
	 * This method for 20 sec for page loading(implicit wait)
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method wait for the element to be visible (Explicit wait)
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method wait for the element to be clicked
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<5) {
			try {
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(2000);
				count++;
			}
		}
	}
	
	/**
	 * This method is used to handle dropdown using visible text
	 * @param element
	 * @param option
	 */
	public void SelectOption(WebElement element,String option)
	{
		Select select = new Select(element);
		select.selectByVisibleText(option);		
	}
	
	/**
	 * This method is used to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void SelectOption(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);		
	}
	
	/**
	 * This method will perform MouseOver action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform Right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This window is used for switching between windows
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
//	public void switchToWindow(WebDriver driver)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext()) {
			String winId=it.next();
	//		String winId2=it.next();
	//		WebDriver title = driver.switchTo().window(winId2);
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This is used to accept the Alert
	 * @param driver
	 */
	public  void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This is used to cancel the Alert
	 * @param driver
	 */
	public  void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to scroll 
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		int y= element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	/**
	 * This method is used for switch between frames using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used for switch between frames using element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used for switch between frames using idOrname
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver, String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * This method is used to take screenshot
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable 
	 */
	public void takeScreenShot(WebDriver driver, String screenshotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src, dest);
	}
	
	/**
	 * Enter Key
	 * @param key
	 * @throws Throwable
	 */
	public void pressEnterKey(KeyEvent key) throws Throwable
	{
		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
}
