package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class PurchaseOrderpage extends WebDriverUtility {
	WebDriver driver;
	public PurchaseOrderpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Purchase Order...']")
	private WebElement createPurchaseOrderImg ;
	
	public WebElement getCreatePurchaseOrderImg() {
		return createPurchaseOrderImg;
	}
	 

}
