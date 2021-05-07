package com.crm.purTest;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.pomclass.CreatePurchaseOrd;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.ProductsPopPage;
import com.crm.vtiger.pomclass.PurchaseOrderpage;
import com.crm.vtiger.pomclass.ServicePopPage;
import com.crm.vtiger.pomclass.VendorPage;

public class TC_10_CreatePurOrderWithItemAndClickOnUpwardSymbol_Test extends BaseClass {
	@Test
	public void createPurOrderWithItemAndClickOnUpward() throws Throwable {
	
		String Subject= eutil.getExcelData("purchase", 5, 2);
		String vendorName= eutil.getExcelData("purchase", 5, 3);
		String BillingAddress= eutil.getExcelData("purchase", 5, 4);
		String ShippingAddress= eutil.getExcelData("purchase", 5, 5);
		String ItemName1= eutil.getExcelData("purchase", 5, 6);
		String Qty1=eutil.getExcelData("purchase", 5, 7);
		String ItemName2= eutil.getExcelData("purchase", 5, 8);
		String Qty2=eutil.getExcelData("purchase", 5, 9);
		//Click on purchaseOrder on home page
		HomePage homepage = new HomePage(driver);
		homepage.More();
		//Click on + symbol on Purchase Order
		PurchaseOrderpage pop = new PurchaseOrderpage(driver);
		pop.getCreatePurchaseOrderImg().click();
		//Enter all the fields in Purchase Order
		CreatePurchaseOrd cpo = new CreatePurchaseOrd(driver);
		cpo.getSubjectTF().sendKeys(Subject);
		cpo.getVendorImg().click();
		wdu.switchToWindow(driver, "Vendor");
		//Take the data from vendor
		VendorPage vp=new VendorPage(driver);
		vp.getVendor_searchtxt().sendKeys(vendorName);
		vp.getVsearch_btn().click();
		vp.getFirst_vendor().click();
		wdu.switchToWindow(driver, "Purchase Order");
		cpo.getBilling_Address().sendKeys(BillingAddress);
		cpo.getShipping_Address().sendKeys(ShippingAddress);
		cpo.getAddProduct1Img().click();
		wdu.switchToWindow(driver,"Products");
		ProductsPopPage ppp=new ProductsPopPage(driver);
		ppp.getProduct_searchtxt().sendKeys(ItemName1);
		ppp.getPsearch_btn().click();
		ppp.getFirst_product().click();
		wdu.switchToWindow(driver, "Purchase Order");
		cpo.getQty1().sendKeys(Qty1);
		cpo.getAddServiceBtn().click();
		cpo.getAddProduct2Img().click();
		wdu.switchToWindow(driver,"Services");
		ServicePopPage spp=new ServicePopPage(driver);
		spp.getService_searchtxt().sendKeys(ItemName2);
		spp.getSsearch_btn().click();
		spp.getFirst_service().click();
		wdu.switchToWindow(driver, "Purchase Order");
		cpo.getQty2().sendKeys(Qty2);
		//Click on upward symbol
		cpo.getUpwardSymbol().click();
	
		cpo.getSaveBtn().click();		
	}

}
