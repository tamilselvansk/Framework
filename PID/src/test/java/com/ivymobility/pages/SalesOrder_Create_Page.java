package com.ivymobility.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ivymobility.utility.Base;

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
	WebElement SalesPersonSelection;
	@FindBy(id = "Retailer")
	WebElement Retailer;
	@FindBy(xpath = "//ul[@id='ui-id-11']/li/a")
	WebElement RetailerSelection;
	@FindBy(xpath = "//select[@id='OH_AW_Id']/following-sibling::div/a")
	WebElement Warehouse;
	@FindBy(xpath = "//select[@id='OH_AW_Id']/following-sibling::div//li")
	WebElement Warehouseselection;
	@FindBy(xpath = "//select[@id='OH_Shipping_Address_Id']/following-sibling::div/a")
	WebElement DeliveryAddress;
	@FindBy(xpath = "//select[@id='OH_Shipping_Address_Id']/following-sibling::div//li")
	WebElement DeliveryAddressSelection;
	@FindBy(xpath = "//select[@id='OH_Inv_Address_Id']/following-sibling::div/a")
	WebElement InvoiceAddress;
	@FindBy(xpath = "//select[@id='OH_Inv_Address_Id']/following-sibling::div//li")
	WebElement InvoiceAddressSelection;

	public SalesOrder_Create_Page(WebDriver driver) {
		Base.driver = driver;

	}

	public void OrderCreate(String SalesPerson, String Retail, String Whouse, String InvtoryAddress, String InvAddress)
			throws Exception {
		waitCondition(50, SalesOrderManagement);

		SalesOrderManagement.click();
		
		SalesOrderCreate.click();
		
		driver.switchTo().frame(frame);
		
		SalesPersion.click();
		
		SalesPersion.sendKeys(SalesPerson);
		
		SalesPersonSelection.click();
		waitCondition(50, Retailer);
		Retailer.click();
		Retailer.sendKeys(Retail);
		RetailerSelection.click();
		Warehouse.click();
		Warehouseselection.click();
		DeliveryAddress.click();
		DeliveryAddressSelection.click();
		InvoiceAddress.click();
		InvoiceAddressSelection.click();
	}

}
