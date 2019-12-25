package com.ivymobility.utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Functions extends Base {

	public static void commonSendKeys(WebElement element, String data) {

		if (element == null) {
			APP_LOGS.error("Element not found for sending data to text field");
			Assert.fail("Element value is null");
		}

		else {
			try {
				if (element.isDisplayed()) {
					element.sendKeys(data);

					APP_LOGS.info(" data send sucessfully on WebElement:::" + element);
				} else {
					APP_LOGS.error("Unable to do   data send to the WebElement::::" + element);
					Assert.fail("The Element is not available in the WebPage:::::" + element);
				}
			} catch (Exception e) {
				APP_LOGS.error("Error-", e);
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				Assert.fail(exceptionAsString);
			}
		}

	}

	public static void commonClick(WebElement element) {

		try {
			if (element == null) {
				APP_LOGS.error("Element not found for Common click");
				Assert.fail("Element value is null");
			}

			else {
				if (element.isDisplayed()) {
					element.click();

					APP_LOGS.info(" click done on WebElement:::" + element);
				} else {
					APP_LOGS.error("Unable to do  click on the WebElement::::" + element);
					Assert.fail("The Element is not available in the WebPage:::::" + element);
				}
			}
		} catch (Exception e) {
			APP_LOGS.error("Error-", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			Assert.fail(exceptionAsString);
		}
	}

	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isDisplayed()) {
				APP_LOGS.info("Clicking on element with using java script click::::" + element);

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				APP_LOGS.info("Unable to click on element::::" + element);
			}
		} catch (Exception e) {
			APP_LOGS.error("Error-", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			Assert.fail(exceptionAsString);
		}
	}

	public static void safeJavaScriptSendkeys(WebElement element, String data) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				APP_LOGS.info("Clicking on element with using java script click::::" + element);

				((JavascriptExecutor) driver).executeScript("arguments[0].value='" + data + "'", element);
			} else {
				APP_LOGS.info("Unable to click on element::::" + element);
			}
		} catch (Exception e) {
			APP_LOGS.error("Error-", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			Assert.fail(exceptionAsString);
		}
	}

	public static void elementToBeClickable(int timeout, WebElement element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void visibilityOfAllElement(int timeout, WebElement element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void visibilityOfAllElements(int timeout, List<WebElement> element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void visibilityOf(int timeout, WebElement element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}

	public static void selectFromMultielements(List<WebElement> elements, String textvalue) {
		if (elements == null) {
			APP_LOGS.error("Element not found for selectFromMultielement");
			Assert.fail("Element value is null");
		} else {
			for (WebElement element : elements) {
				String value = element.getText();
				if (value.contains(textvalue)) {
					// elementToBeClickable(driver, 30, element);
					Functions.commonClick(element);
					break;
				}
			}
		}
	}

	public static void selectFromMultielement(WebElement element, String textvalue) {
		if (element == null) {
			APP_LOGS.error("Element not found for selectFromMultielement");
			Assert.fail("Element value is null");
		} else {
			Functions.commonClick(element);
		}
	}

	public static void mouseMovement(WebElement element) {
		if (element == null) {

			APP_LOGS.info("Unable to find the element");
			Assert.fail("Element is null");
		} else {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
			APP_LOGS.info("Element is move and clicked successfully");
		}

	}
	public static void scrollBy() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1500)");
		
		
	}
}