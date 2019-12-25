package com.ivymobility.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ivymobility.utility.Base;
import com.ivymobility.utility.Functions;

public class SalesOrder_Create_Page extends Base {

	@FindBy(xpath = "//a[@title='Sales Order Management']")
	WebElement SalesOrderManagement;
	@FindBy(xpath = "//a[@title='Sales Order Management']/following-sibling::div//a[@title='Sales Order Create']")
	WebElement SalesOrderCreate;
	@FindBy(id = "iContent")
	WebElement frame;
	@FindBy(id = "SalesPerson")
	WebElement SalesPersion;
	@FindBy(xpath = "//ul[@id='ui-id-1']/li/a")
	List<WebElement> SalesPersonSelection;
	@FindBy(id = "Retailer")
	WebElement Retailer;
	@FindBy(xpath = "//ul[@id='ui-id-5']/li/a")
	List<WebElement> RetailerSelection;
	@FindBy(xpath = "//select[@id='OH_AW_Id']/following-sibling::div/a")
	WebElement Warehouse;
	@FindBy(xpath = "//select[@id='OH_AW_Id']/following-sibling::div//li")
	List<WebElement> Warehouseselection;
	@FindBy(id = "SearchName")
	WebElement SearchName;
	@FindBy(xpath = "//ul[@id='ui-id-3']/li/a")
	WebElement SKUSelection;
	@FindBy(xpath="//span[text()='Case : ']/following-sibling::input")
	WebElement ORD_Case;
	@FindBy(xpath="//span[text()='Piece : ']/following-sibling::input")
	WebElement Piece;
	@FindBy(xpath="//a[text()='Submit Order']")
	WebElement SubmitOrder;
	@FindBy(xpath="//button[text()='Yes Continue']")
	WebElement Confirmation;
	
	public SalesOrder_Create_Page(WebDriver driver) {
		Base.driver = driver;

	}

	public void OrderCreate(String SalesPerson, String Retail, String Whouse, String sku,String Case) throws Exception {

		Functions.safeJavaScriptClick(SalesOrderManagement);
		APP_LOGS.info("Sales Order Management clicked successfully");
		Functions.elementToBeClickable(10, SalesOrderCreate);
		Functions.commonClick(SalesOrderCreate);
		APP_LOGS.info("SalesOrderCreate clicked successfully");
		driver.switchTo().frame(frame);
		APP_LOGS.info("Frame switched successfully");
//		Sales Person
		Functions.visibilityOf(20, SalesPersion);
		Functions.commonClick(SalesPersion);
		Functions.visibilityOf(20, SalesPersion);
		Functions.safeJavaScriptSendkeys(SalesPersion, SalesPerson);
		APP_LOGS.info("SalesPerson entered successfully");
		SalesPersion.sendKeys(Keys.DELETE);
		Functions.visibilityOfAllElements(20, SalesPersonSelection);
		Functions.selectFromMultielements(SalesPersonSelection, SalesPerson);
		APP_LOGS.info("Sales person selected successfully");
		
//		Retailer Selection
		Functions.elementToBeClickable(30, Retailer);
		Functions.mouseMovement(Retailer);
		Functions.visibilityOf(30, Retailer);
		Functions.safeJavaScriptSendkeys(Retailer, Retail);
		APP_LOGS.info("Retailer entered successfully");
		
		Retailer.sendKeys(Keys.DELETE);
		Functions.visibilityOfAllElements(30, RetailerSelection);
		Functions.selectFromMultielements(RetailerSelection, Retail);
		APP_LOGS.info("Retailer selected successfully");

//      WareHouse Selection		
		Functions.elementToBeClickable(25, Warehouse);
		Functions.mouseMovement(Warehouse);
		Functions.visibilityOfAllElements(20, Warehouseselection);
		Functions.selectFromMultielements(Warehouseselection, Whouse);
		APP_LOGS.info("Warehoue selected successfully");
		
//		SKU Selection
		Functions.visibilityOf(30, SearchName);
		Functions.safeJavaScriptSendkeys(SearchName, sku);
		APP_LOGS.info("SKU entered successfully ");
		Functions.visibilityOf(30, SearchName);
		SearchName.sendKeys(Keys.DELETE);
		Functions.elementToBeClickable(25, SKUSelection);
		Functions.commonClick(SKUSelection);
		APP_LOGS.info("SKU Selected successfully");
		
//		Ordered Data
		Functions.elementToBeClickable(25, ORD_Case);
		Functions.commonClick(ORD_Case);
		int case_qty=(int) Double.parseDouble(Case);
		Functions.commonSendKeys(ORD_Case,String.valueOf(case_qty));
		ORD_Case.sendKeys(Keys.TAB);
		Piece.sendKeys(Keys.TAB);
		
		Functions.scrollBy();
		
		Functions.elementToBeClickable(40,SubmitOrder);
	    Functions.commonClick(SubmitOrder);
	    
		Functions.elementToBeClickable(30,Confirmation);
		Functions.commonClick(Confirmation);
		
	}

}
