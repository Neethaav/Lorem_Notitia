package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class ServicePopPage extends WebDriverUtility {
	WebDriver driver;
	public ServicePopPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement service_searchtxt;
	
	@FindBy(name="search")
	private WebElement ssearch_btn;
	
	@FindBy(id="popup_product_14")
	private WebElement first_service;
	
	@FindBy(xpath="//td[text()='Services']")
	private WebElement serviceTitle;
	
	public WebElement getServiceTitle() {
		return serviceTitle;
	}

	public WebElement getFirst_service() {
		return first_service;
	}
	
	public WebElement getService_searchtxt() {
		return service_searchtxt;
	}

	public WebElement getSsearch_btn() {
		return ssearch_btn;
	}

	public String getFirstSelectService()
	{
		return first_service.getText();
	}
	
	public String getServicePopUpTitle()
	{
		return serviceTitle.getText();
	}
}
