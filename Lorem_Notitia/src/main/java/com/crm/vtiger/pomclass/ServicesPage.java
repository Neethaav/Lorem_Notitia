package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class ServicesPage extends WebDriverUtility {
	WebDriver driver;
	public ServicesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//img[@title='Create Service...']")
	private WebElement Creat_servicesImg;
	
	public WebElement getCreat_servicesImg() {
		return Creat_servicesImg;
	}
	
	

}
