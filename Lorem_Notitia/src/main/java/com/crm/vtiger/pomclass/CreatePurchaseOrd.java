package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreatePurchaseOrd extends WebDriverUtility {
	WebDriver driver;
	public CreatePurchaseOrd(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="subject")
	private WebElement subjectTF;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement vendorImg;
	
	@FindBy(name="vendor_name")
	private WebElement vendorTF;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr[11]/td[2]/textarea")
	private WebElement Billing_Address;
	
	@FindBy(xpath = "//table[@class='small']/tbody/tr[11]/td[4]/textarea")
	private WebElement Shipping_Address;
	
	@FindBy(id="searchIcon1")
	private WebElement AddProduct1Img;
	
	@FindBy(id="searchIcon2")
	private WebElement AddProduct2Img;
	
	@FindBy(xpath = "//input[@value='Add Product")
	private WebElement AddProductBtn;
	
	@FindBy(xpath = "//input[@value='Add Service']")
	private WebElement AddServiceBtn;
	
	@FindBy(id="qty1")
	private WebElement Qty1;

	@FindBy(id="qty2")
	private WebElement Qty2;
	
	@FindBy(xpath="//table[@id='proTab']/tbody/tr[@id='row2']/td/img")
	private WebElement Delete_Img;
	
	@FindBy(xpath = "//*[@id=\\\"row2_col1\\\"]/a")
	private WebElement UpwardSymbol;
	
	public WebElement getUpwardSymbol() {
		return UpwardSymbol;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public WebElement getVendorImg() {
		return vendorImg;
	}

	public WebElement getVendorTF() {
		return vendorTF;
	}

	public WebElement getBilling_Address() {
		return Billing_Address;
	}

	public WebElement getShipping_Address() {
		return Shipping_Address;
	}
	
	public WebElement getAddProductBtn() {
		return AddProductBtn;
	}

	public WebElement getAddServiceBtn() {
		return AddServiceBtn;
	}

	public WebElement getAddProduct1Img() {
		return AddProduct1Img;
	}

	public WebElement getAddProduct2Img() {
		return AddProduct2Img;
	}

	public WebElement getQty1() {
		return Qty1;
	}

	public WebElement getQty2() {
		return Qty2;
	}
	
	public WebElement getDelete_Img() {
		return Delete_Img;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	
	
}
