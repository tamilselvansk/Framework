package com.ivymobility.utility;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {

	public static Logger APP_LOGS = null;
	public static Properties CONFIG;
	public static Reader dataxls = null;
	public static WebDriver driver = null;
	public static boolean isinitialized = false;
	public static boolean isBrowserOpened = false;
	public static WebDriverWait wait = null;

	public static void initialize() throws Exception

	{
		if (!isinitialized) {

			// -----------------Initialize logs------------------

			APP_LOGS = Logger.getLogger("devpinoyLogger");
			// PropertyConfigurator.configure("log4j.properties");
			// System.setProperty("org.apache.commons.logging.Log",
			// "org.apache.commons.logging.impl.Jdk14Logger");

			// -------------------Initialize config file---------------
			// CONFIG Properties
			APP_LOGS.debug("Loading Properties files"); // Initialize properties files and putting them into log files.
			CONFIG = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\tamilselvan.sk\\MvnProject\\PID\\CONFIG\\config.properties");
			CONFIG.load(fis);
			APP_LOGS.debug("Loaded Properties files successfully");
			APP_LOGS.debug("Loading All Excel files.....");
			dataxls = new Reader("C:\\Users\\tamilselvan.sk\\MvnProject\\PID\\XLS\\data.xls");
			APP_LOGS.debug("Loaded All Excel files successfully");
			isinitialized = true;

		}

	}

	public void openBrowser() throws InterruptedException {
		if (!isBrowserOpened) {
			
			String browsername=CONFIG.getProperty("browserType");
			if (CONFIG.getProperty("browserType").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\tamilselvan.sk\\MvnProject\\PID\\Driver\\geckodriver.exe");

				driver = new FirefoxDriver();

				driver.manage().window().maximize();
				// loginCM();
			}

			else if (CONFIG.getProperty("browserType").equalsIgnoreCase("Chrome")) {

				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\tamilselvan.sk\\MvnProject\\PID\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}

			driver.get(CONFIG.getProperty("url"));

			isBrowserOpened = true;

			String waitTime = CONFIG.getProperty("default_implicitlyWait");
			driver.manage().timeouts().implicitlyWait(Long.parseLong(waitTime), TimeUnit.SECONDS);
		}
	}

	public void elementToBeClickable(WebDriver driver, int timeout, WebElement element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void visibilityOfAllElements(WebDriver driver, int timeout, List<WebElement> element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void visibilityOf(WebDriver driver, int timeout, WebElement element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}

	public void selectFromMultielement(WebDriver driver, List<WebElement> elements, String textvalue) {
		if (elements == null) {
			APP_LOGS.error("Element not found for selectFromMultielement");
			Assert.fail("Element value is null");
		}
		else {
		for (WebElement element : elements) {
			String value = element.getText();
			if (value.contains(textvalue)) {
				//elementToBeClickable(driver, 30, element);
				Functions.commonClick(element);
				break;
			}
		}
	}
	}
	public void mouseMovement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public void branchLogin() {

		WebElement Username_element = driver.findElement(By.id("UserName"));
		if (Username_element != null) {
			Username_element.sendKeys(CONFIG.getProperty("branchUsername"));
			APP_LOGS.info("Entered  the Username Successfully");
		} else {
			APP_LOGS.info("Unable to Enter Data in username Input Field");
		}
		WebElement Password_element = driver.findElement(By.id("Password"));
		if (Password_element != null) {
			Password_element.sendKeys(CONFIG.getProperty("branchPassword"));
			APP_LOGS.info("Entered  the Username Successfully");
		} else {
			APP_LOGS.info("Unable to Enter Data in password Input Field");
		}
		WebElement Login_element = driver.findElement(By.id("Login"));
		if (Login_element != null) {
			Login_element.submit();
			APP_LOGS.info("Clicked Login button Successfully");
		} else {
			APP_LOGS.info("Unable to Click on Login Button");
		}

	}

}
