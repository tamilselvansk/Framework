package com.ivymobility.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ivymobility.utility.Base;

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
	@FindBy(id = "SearchName")
	WebElement SKUSearch;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']/li/a/span")
	WebElement SKUSelection;
	@FindBy(xpath = "//span[contains(text(),'Case : ')]/following::input[1][@class='grid-input text-right']")
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

	public void GRN_Creation_Page(String PO, String Warehouse, String SKU, String caseQty, String pieceQty)
			throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 30) ;
		wait.until(ExpectedConditions.elementToBeClickable(GRNManagement));
	    GRNManagement.click();
		APP_LOGS.info("GRNManagement clicked successfully");
		//Thread.sleep(1000);
		GRNCreate.click();
		APP_LOGS.info("GRNCreate clicked successfully");
		driver.switchTo().frame(frame);
		APP_LOGS.info("Switched frame successfully");
		PONumber.sendKeys(PO);
		APP_LOGS.info("PO number entered successfully");
		//Thread.sleep(1000);
		//WarehouseDropdown.click();

		//APP_LOGS.info("Warehouse Clicked successfully");

		//for (WebElement wh : WarehouseSelection) {
			//if (wh.getText().equals(Warehouse)) {
				//wh.click();
				//APP_LOGS.info(Warehouse + " selected successfully");
				//Thread.sleep(1000);
				//SKUSearch.click();
				//Thread.sleep(1000);
				SKUSearch.sendKeys(SKU);
				
				wait.until(ExpectedConditions.elementToBeClickable(SKUSelection));
				SKUSelection.click();
				//Thread.sleep(1000);
				
				wait.until(ExpectedConditions.elementToBeClickable(GRNCase));
				GRNCase.click();
				int Case_Qty = (int) Double.parseDouble(caseQty);
				
				GRNCase.sendKeys(String.valueOf(Case_Qty));
				GRNCase.sendKeys(Keys.TAB);
				GRNPiece.click();
				int piece_Qty = (int) Double.parseDouble(pieceQty);
				GRNPiece.sendKeys(String.valueOf(piece_Qty));
				GRNPiece.sendKeys(Keys.TAB);
				SubmitGRN.click();
				Assert.assertTrue(true);
			}

		}

