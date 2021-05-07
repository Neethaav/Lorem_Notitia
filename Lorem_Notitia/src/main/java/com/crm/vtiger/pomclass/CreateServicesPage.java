package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateServicesPage extends WebDriverUtility {
	WebDriver driver;
	public CreateServicesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(name="servicename")
	private WebElement serviceName;

	public WebElement getServiceName() {
		return serviceName;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}

