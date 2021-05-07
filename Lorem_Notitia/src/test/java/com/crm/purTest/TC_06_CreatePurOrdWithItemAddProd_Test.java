package com.crm.purTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.pomclass.CreateProductPage;
import com.crm.vtiger.pomclass.CreatePurchaseOrd;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.ProductsPage;
import com.crm.vtiger.pomclass.ProductsPopPage;
import com.crm.vtiger.pomclass.PurchaseOrderpage;
import com.crm.vtiger.pomclass.VendorPage;

public class TC_06_CreatePurOrdWithItemAddProd_Test extends BaseClass {
	@Test
	public void createPurOrderWithItemAddProd() throws Throwable{
		String productName= eutil.getExcelData("purchase", 1, 2)+"_"+js.getRandomData();
		String Subject= eutil.getExcelData("purchase", 1, 3);
		String vendorName= eutil.getExcelData("purchase", 1, 4);
		String BillingAddress= eutil.getExcelData("purchase", 1, 5);
		String ShippingAddress= eutil.getExcelData("purchase", 1, 6);
		String ItemName1= eutil.getExcelData("purchase", 1, 7);
		String Qty1=eutil.getExcelData("purchase", 1, 8);
//		String ItemName2= eutil.getExcelData("purchase", 1, 9);
		String Qty2=eutil.getExcelData("purchase", 1, 10);
		
		//Click on product on home page
		HomePage homepage = new HomePage(driver);
		homepage.getProductLink().click();
		//Click on + symbol on Product page
		ProductsPage prdp=new ProductsPage(driver);
		prdp.getCreat_productImg().click();
		//Create new Product
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductName().sendKeys(productName);
		cpp.getSaveBtn().click();
		//MouseHover on More and click on PurchaseOrder
		homepage.More();
		//Click on new Purchase order
		PurchaseOrderpage pop = new PurchaseOrderpage(driver);
		pop.getCreatePurchaseOrderImg().click();
		//Enter all the fields in purchase Order
		CreatePurchaseOrd cpo = new CreatePurchaseOrd(driver);
		cpo.getSubjectTF().sendKeys(Subject);
		cpo.getVendorImg().click();
		wdu.switchToWindow(driver, "Vendor");
		//Enter the Vendor name
		VendorPage vp=new VendorPage(driver);
		vp.getVendor_searchtxt().sendKeys(vendorName);
		vp.getVsearch_btn().click();
		vp.getFirst_vendor().click();
		wdu.switchToWindow(driver, "Purchase Order");
		//Enter the Address
		cpo.getBilling_Address().sendKeys(BillingAddress);
		cpo.getShipping_Address().sendKeys(ShippingAddress);
		cpo.getAddProduct1Img().click();
		wdu.switchToWindow(driver,"Products");
		ProductsPopPage ppp=new ProductsPopPage(driver);
		String actualProductTitle = ppp.getProductPopUpTitle();
		Assert.assertTrue(actualProductTitle.equalsIgnoreCase("Products"));
		ppp.getProduct_searchtxt().sendKeys(ItemName1);
		ppp.getPsearch_btn().click();
		ppp.getFirst_product().click();
		
		wdu.switchToWindow(driver, "Purchase Order");
		cpo.getQty1().sendKeys(Qty1);
		cpo.getAddProductBtn().click();
		cpo.getAddProduct2Img().click();
		wdu.switchToWindow(driver,"Products");
		ppp.getProduct_searchtxt().sendKeys(productName);
		ppp.getPsearch_btn().click();
		String actualSelectedProduct = ppp.getFirstSelectProduct();
		//Assert Product Title
		Assert.assertTrue(actualSelectedProduct.equalsIgnoreCase(productName));
		ppp.getFirst_product().click();
		
		wdu.switchToWindow(driver, "Purchase Order");
		cpo.getQty2().sendKeys(Qty2);
		
		cpo.getSaveBtn().click();
		
	}
}
