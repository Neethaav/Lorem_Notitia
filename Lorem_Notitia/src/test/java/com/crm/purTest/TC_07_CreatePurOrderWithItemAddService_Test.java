package com.crm.purTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.pomclass.CreatePurchaseOrd;
import com.crm.vtiger.pomclass.CreateServicesPage;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.ProductsPopPage;
import com.crm.vtiger.pomclass.PurchaseOrderpage;
import com.crm.vtiger.pomclass.ServicePopPage;
import com.crm.vtiger.pomclass.ServicesPage;
import com.crm.vtiger.pomclass.VendorPage;

public class TC_07_CreatePurOrderWithItemAddService_Test extends BaseClass {
	
	
	@Test
	public void createPurOrderWithItemAddser() throws Throwable {
		String servicesName= eutil.getExcelData("purchase", 3, 2)+"_"+js.getRandomData();
		String Subject= eutil.getExcelData("purchase", 3, 3);
		String vendorName= eutil.getExcelData("purchase", 3, 4);
		String BillingAddress= eutil.getExcelData("purchase", 3, 5);
		String ShippingAddress= eutil.getExcelData("purchase", 3, 6);
		String ItemName1= eutil.getExcelData("purchase", 3, 7);
		String Qty1=eutil.getExcelData("purchase", 3, 8);
//		String ItemName2= eutil.getExcelData("purchase", 3, 9);
		String Qty2=eutil.getExcelData("purchase", 3, 10);
		
		//Click on product on home page
		HomePage homepage = new HomePage(driver);
		homepage.More_Services();
		//Click on + symbol on Service page
		ServicesPage sp = new ServicesPage(driver);
		sp.getCreat_servicesImg().click();
		//Create new service
		CreateServicesPage csp=new CreateServicesPage(driver);
		csp.getServiceName().sendKeys(servicesName);
		csp.getSaveBtn().click();
		homepage.More();
		//MouseHover on More and click on PurchaseOrder
		PurchaseOrderpage pop = new PurchaseOrderpage(driver);
		pop.getCreatePurchaseOrderImg().click();
		//Click on new Purchase order
		CreatePurchaseOrd cpo = new CreatePurchaseOrd(driver);
		cpo.getSubjectTF().sendKeys(Subject);
		cpo.getVendorImg().click();
		wdu.switchToWindow(driver, "Vendor");
		//Enter all the fields in purchase Order
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
		String actualProductTitle = ppp.getProductPopUpTitle();
		Assert.assertTrue(actualProductTitle.equalsIgnoreCase("Products"));
		ppp.getProduct_searchtxt().sendKeys(ItemName1);
		ppp.getPsearch_btn().click();
		ppp.getFirst_product().click();
		
		wdu.switchToWindow(driver, "Purchase Order");
		cpo.getQty1().sendKeys(Qty1);
		cpo.getAddServiceBtn().click();
		cpo.getAddProduct2Img().click();
		wdu.switchToWindow(driver,"Services");
		
		ServicePopPage spp=new ServicePopPage(driver);
		spp.getService_searchtxt().sendKeys(servicesName);
		spp.getSsearch_btn().click();
		//Assert Service Name
		String actualSelectedservice = spp.getFirstSelectService();
		Assert.assertTrue(actualSelectedservice.equalsIgnoreCase(servicesName));
		spp.getFirst_service().click();
		
		wdu.switchToWindow(driver, "Purchase Order");
		cpo.getQty2().sendKeys(Qty2);
		cpo.getSaveBtn().click();
		
		
	}
}
