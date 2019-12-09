package com.ivymobility.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ivymobility.pages.GRN_Page;
import com.ivymobility.pages.SalesOrder_Create_Page;
import com.ivymobility.utility.Base;
import com.ivymobility.utility.TestUtil;

public class SalesOrder_Create extends Base {
	
	@BeforeClass
	public void dataSetup() throws Exception{
		initialize();
		openBrowser();	
		branchLogin();
		
	}
	@Test(dataProvider="getTestData")
	public void SalesOrder(String SalesPerson, String Retail, String Whouse, String InvtoryAddress,
			String InvAddress) throws Exception
	{
		SalesOrder_Create_Page OC = PageFactory.initElements(driver,SalesOrder_Create_Page.class);
		OC.OrderCreate(SalesPerson, Retail, Whouse, InvtoryAddress, InvAddress);
		
		
	}
	@DataProvider(name="getTestData")
	public Object[][] getTestData()
	{
		return TestUtil.getdata(dataxls,this.getClass().getSimpleName());
			
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
                      
}
