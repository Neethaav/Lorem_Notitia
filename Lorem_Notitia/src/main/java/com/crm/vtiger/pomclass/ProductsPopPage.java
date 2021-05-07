package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class ProductsPopPage extends WebDriverUtility {
	WebDriver driver;
	public ProductsPopPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement product_searchtxt;
	
	@FindBy(name="search")
	private WebElement psearch_btn;
	
	@FindBy(id="popup_product_13")
	private WebElement first_product;
	
	@FindBy(xpath="//td[text()='Products']")
	private WebElement productTitle;
	
	
	public WebElement getProductTitle() {
		return productTitle;
	}

	public WebElement getFirst_product() {
		return first_product;
	}

	public WebElement getProduct_searchtxt() {
		return product_searchtxt;
	}

	public WebElement getPsearch_btn() {
		return psearch_btn;
	}

	public String getProductPopUpTitle()
	{
		return productTitle.getText();
	}
	public String getFirstSelectProduct()
	{
		return first_product.getText();
	}
}
