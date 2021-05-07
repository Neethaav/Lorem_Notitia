package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(name="Purchase Order")
	private WebElement purchaseOrderLink;
	
	@FindBy(name="Services")
	private WebElement serviceLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorIMG;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getServiceLink() {
		return serviceLink;
	}

	public WebElement getAdminstratorIMG() {
		return adminstratorIMG;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
//	/**
//	 * click on organization link
//	 */
//	public OrganizationPage clickOnOrganizationLink() {
//		organizationLink.click();
//		return new OrganizationPage(driver);
//	}
	/**
	 * click on product link
	 */
	public void clickOnProductLink() {
		productLink.click();
	}
	
	/**
	 * click on morelink
	 */
	public void More() {
		mouseOver(driver, moreLink);
		purchaseOrderLink.click();
	}
	
	/**
	 * click on More services
	 */
	public void More_Services() {
		mouseOver(driver, moreLink);
		serviceLink.click();
	}

	/**
	 * Signout from app
	 */
	public void signOut() {
		mouseOver(driver, adminstratorIMG);
		signOutLink.click();
	}

}


