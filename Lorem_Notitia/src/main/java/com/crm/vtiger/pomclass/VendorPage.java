package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class VendorPage extends WebDriverUtility {
	WebDriver driver;
	public VendorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement vendor_searchtxt;
	
	@FindBy(name="search")
	private WebElement vsearch_btn;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr[2]/td[1]/a")
	private WebElement first_vendor;

	public WebElement getFirst_vendor() {
		return first_vendor;
	}

	public WebElement getVendor_searchtxt() {
		return vendor_searchtxt;
	}
	
	public WebElement getVsearch_btn() {
		return vsearch_btn;
	}

	
}
