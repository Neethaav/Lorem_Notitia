package com.crm.purTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.pomclass.CreatePurchaseOrd;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.ProductsPopPage;
import com.crm.vtiger.pomclass.PurchaseOrderpage;
import com.crm.vtiger.pomclass.ServicePopPage;
import com.crm.vtiger.pomclass.VendorPage;

public class TC_08_CreatePurOrderWithItemSer_Test extends BaseClass {
	@Test
	public void createPurOrderWithItemser() throws Throwable {
	
		String Subject= eutil.getExcelData("purchase", 5, 2);
		String vendorName= eutil.getExcelData("purchase", 5, 3);
		String BillingAddress= eutil.getExcelData("purchase", 5, 4);
		String ShippingAddress= eutil.getExcelData("purchase", 5, 5);
		String ItemName1= eutil.getExcelData("purchase", 5, 6);
		String Qty1=eutil.getExcelData("purchase", 5, 7);
		String ItemName2= eutil.getExcelData("purchase", 5, 8);
		String Qty2=eutil.getExcelData("purchase", 5, 9);
		
		//Click on product on home page
		HomePage homepage = new HomePage(driver);
		homepage.More();
		//Click on PurchaseOrder
		PurchaseOrderpage pop = new PurchaseOrderpage(driver);
		pop.getCreatePurchaseOrderImg().click();
		//Enter the fields in PurchaseOrder
		CreatePurchaseOrd cpo = new CreatePurchaseOrd(driver);
		cpo.getSubjectTF().sendKeys(Subject);
		cpo.getVendorImg().click();
		wdu.switchToWindow(driver, "Vendor");
		
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
		//Assert Service Title
		String actualServiceTitle = spp.getServicePopUpTitle();
		Assert.assertTrue(actualServiceTitle.equalsIgnoreCase("Services"));
		spp.getService_searchtxt().sendKeys(ItemName2);
		spp.getSsearch_btn().click();
		spp.getFirst_service().click();
		
		wdu.switchToWindow(driver, "Purchase Order");
		cpo.getQty2().sendKeys(Qty2);
		cpo.getSaveBtn().click();
			
	}
}
