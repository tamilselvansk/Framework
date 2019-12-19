package com.ivymobility.pages;

import java.util.List;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
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
	@FindBy(id="SearchName")
	WebElement SearchName;
	@FindBy(xpath="//ul[@id='ui-id-9']/li/a")
	WebElement SKUSelection;
	
	public SalesOrder_Create_Page(WebDriver driver) {
		Base.driver = driver;

	}

	public void OrderCreate(String SalesPerson, String Retail, String Whouse, String sku)
			throws Exception {
	    
		Functions.safeJavaScriptClick(SalesOrderManagement);		
		APP_LOGS.info("Sales Order Management clicked successfully");
		elementToBeClickable(driver, 10, SalesOrderCreate);
	    Functions.commonClick(SalesOrderCreate);
		APP_LOGS.info("SalesOrderCreate clicked successfully");
		driver.switchTo().frame(frame);
		APP_LOGS.info("Frame switched successfully");
		//SalesPersion.sendKeys(Keys.SPACE);
		Functions.commonClick(SalesPersion);
		visibilityOf(driver, 30, SalesPersion);
		Functions.safeJavaScriptSendkeys(SalesPersion, SalesPerson);
        APP_LOGS.info("SalesPerson entered successfully");
       // visibilityOf(driver, 10, SalesPersion);
        SalesPersion.sendKeys(Keys.DELETE);
        //APP_LOGS.info("SalesPerson data deleted successfully");        
	    selectFromMultielement(driver,SalesPersonSelection,SalesPerson);
	    APP_LOGS.info("Sales person selected successfully");
	    visibilityOf(driver, 20, Retailer);
	    Functions.commonClick(Retailer);
	    visibilityOf(driver, 30, Retailer);
		Functions.safeJavaScriptSendkeys(Retailer,Retail);
		APP_LOGS.info("Retailer entered successfully");
//		elementToBeClickable(driver, 40, Retailer);
		Retailer.sendKeys(Keys.DELETE);
//		APP_LOGS.info("Retailer deleted successfully");
		selectFromMultielement(driver,RetailerSelection,Retail);
       APP_LOGS.info("Retailer selected successfully");		
//		Warehouse.click();
//		selectFromMultielement(driver,Warehouseselection, Whouse);		
//		Functions.safeJavaScriptSendkeys(SearchName, sku);
//		Functions.commonClick(SKUSelection);
	}

}
