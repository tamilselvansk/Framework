package com.ivymobility.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ivymobility.utility.Base;
import com.ivymobility.utility.Functions;

public class GRN_Page extends Base{

	@FindBy(xpath = "//a[@title='GRN Management']")
	WebElement GRNManagement;
	@FindBy(xpath = "//a[@title='GRN Create']")
	WebElement GRNCreate;
	@FindBy(id = "iContent")
	WebElement frame;
	@FindBy(id = "GH_POH_No")
	WebElement PONumber;
	@FindBy(xpath = "//div[@id='grnHeader']/div/div/div[5]/div/a")
	WebElement WarehouseDropdown;
	@FindBy(xpath = "//div[@id='grnHeader']/div/div/div[5]/div/ul/li")
	List<WebElement> WarehouseSelection;
	@FindBy(xpath="//select[@id='GH_Ship_Address_Id']/following-sibling::div/a")
	WebElement deliveryaddress;
	@FindBy(xpath="//select[@id='GH_Ship_Address_Id']/following-sibling::div/ul/li")
	List<WebElement> deliveryaddresSelection;
	@FindBy(id = "SearchName")
	WebElement SKUSearch;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']/li/a/span")
	WebElement SKUSelection;
	@FindBy(xpath = "//span[text()='Case : ']/following-sibling::input")
	WebElement GRNCase;
	@FindBy(xpath = "//span[contains(text(),'Piece : ')]/following::input[1][@class='grid-input text-right']")
	WebElement GRNPiece;
	@FindBy(xpath = "//button[text()='Submit GRN']")
	WebElement SubmitGRN;
	@FindBy(xpath="//div[@id='card-alert']/div")
	WebElement Successmsg;
	
	

	public GRN_Page(WebDriver driver) {

		Base.driver = driver;
       
	}

	public void GRN_Creation_Page(String PO, String Warehouse,String Deliveryaddress, String SKU, String caseQty, String pieceQty)
			throws Exception {
		
		Functions.safeJavaScriptClick(GRNManagement);
		//WebDriverWait wait=new WebDriverWait(driver, 60) ;
		//wait.until(ExpectedConditions.elementToBeClickable(GRNManagement));
	    //GRNManagement.click();
		APP_LOGS.info("GRNManagement clicked successfully");
		//Thread.sleep(1000);
		Functions.safeJavaScriptClick(GRNCreate); 
		APP_LOGS.info("GRNCreate clicked successfully");
		driver.switchTo().frame(frame);
		APP_LOGS.info("Switched frame successfully");
		PONumber.sendKeys(PO);
		APP_LOGS.info("PO number entered successfully");
		//Thread.sleep(1000);
		Functions.commonClick(WarehouseDropdown);

		APP_LOGS.info("Warehouse Clicked successfully");

		Functions.visibilityOfAllElements(30, WarehouseSelection);
		Functions.selectFromMultielements(WarehouseSelection,Warehouse);
	      Functions.commonClick(deliveryaddress);
	      
	      Functions.selectFromMultielements(deliveryaddresSelection,Deliveryaddress);
				SKUSearch.sendKeys(SKU);
				
				Functions.commonClick(SKUSelection);
				//Thread.sleep(1000);
				
				GRNCase.click();
				int Case_Qty = (int) Double.parseDouble(caseQty);
				
				GRNCase.sendKeys(String.valueOf(Case_Qty));
				GRNCase.sendKeys(Keys.TAB);
				Functions.commonClick(GRNPiece);
				int piece_Qty = (int) Double.parseDouble(pieceQty);
				GRNPiece.sendKeys(String.valueOf(piece_Qty));
				GRNPiece.sendKeys(Keys.TAB);
				Functions.commonClick(SubmitGRN);
				Assert.assertTrue(true);

	}}

