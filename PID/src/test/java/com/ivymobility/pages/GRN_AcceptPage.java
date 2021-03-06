package com.ivymobility.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ivymobility.utility.Base;
import com.ivymobility.utility.Functions;

public class GRN_AcceptPage extends Base {

	@FindBy(xpath = "//a[@title='GRN Management']")
	WebElement GRNManagement;
	@FindBy(xpath = "//a[@title='GRN Management']/parent::li//a[@title='GRN Acceptance']")
	WebElement GRNAcceptance;
	@FindBy(id = "iContent")
	WebElement frame;
	@FindBy(id = "GRN_FromDate")
	WebElement GRN_FromDate;
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")
	List<WebElement> GRNDate;
	@FindBy(id = "PO_No")
	WebElement PO_no;
	@FindBy(linkText = "Search")
	WebElement Search;
	@FindBy(xpath = "//div[@id='_grnGrid']//child::div//div[@class='row grid-data-row grid-data-row-odd']/div[2]")
	List<WebElement> GRNselection;
	@FindBy(xpath = "html/body/div[1]/div[1]/div[3]/div/button")
	WebElement ReceiveGRN;
	@FindBy(xpath = "html/body/div[1]/div[1]/div/div/div[3]/div/button[1]")
	WebElement AcceptGRN;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement Confirmation;

	public GRN_AcceptPage(WebDriver driver) {
		this.driver = driver;

	}

	public void GRNAcceptance(String POnumber, String Day) throws Exception {

		//Thread.sleep(1000);
		Functions.safeJavaScriptClick(GRNManagement);
		APP_LOGS.info("GRN Management Clicked successfully");
		Functions.safeJavaScriptClick(GRNAcceptance);
		APP_LOGS.info("GRNAcceptance Clicked successfully");
		driver.switchTo().frame(frame);
		APP_LOGS.info("Switched the frame successfully");
		GRN_FromDate.click();
		APP_LOGS.info("GRN From Date clicked successfully");
		for (WebElement Fromdate : GRNDate) {
			int webdate = Integer.parseInt(Fromdate.getText());
			int givendate = (int) Double.parseDouble(Day);

			if (webdate == givendate) {
				Fromdate.click();
				APP_LOGS.info("GRN From Date selected successfully");
				break;
			}
		}
		PO_no.sendKeys(POnumber);
		APP_LOGS.info("PONumber Entered successfully");
		Functions.safeJavaScriptClick(Search);
		APP_LOGS.info("Search Clicked successfully");
		Functions.selectFromMultielements(GRNselection, POnumber);
		APP_LOGS.info("GRN selected successfully");
		Functions.safeJavaScriptClick(ReceiveGRN);
		APP_LOGS.info("ReceiveGRN Clicked successfully");	
		Functions.visibilityOf(20, AcceptGRN);
		Functions.safeJavaScriptClick(AcceptGRN);
		APP_LOGS.info("AcceptGRN Clicked successfully");
		Functions.visibilityOf(30, Confirmation);
		Confirmation.click();
		Assert.assertTrue(true);
		APP_LOGS.info("Confirmation Clicked successfully");

	}

}
