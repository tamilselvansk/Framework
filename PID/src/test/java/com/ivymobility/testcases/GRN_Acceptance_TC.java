package com.ivymobility.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ivymobility.pages.GRN_AcceptPage;
import com.ivymobility.utility.Base;
import com.ivymobility.utility.TestUtil;

public class GRN_Acceptance_TC extends Base {

	@BeforeClass
	public void dataSetup() throws Exception {
		initialize();
		openBrowser();
		branchLogin();

	}

	@Test(dataProvider = "getTestData")
	public void GRN_Acceptance_TC(String POnumber, String Day) throws Exception {
		GRN_AcceptPage GA = PageFactory.initElements(driver, GRN_AcceptPage.class);
		GA.GRNAcceptance(POnumber, Day);

	}

	@DataProvider(name = "getTestData")
	public Object[][] getTestData() {
		return TestUtil.getdata(dataxls, this.getClass().getSimpleName());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
