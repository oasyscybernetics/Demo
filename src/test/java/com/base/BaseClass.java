package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void getDriver(String browserType) {

		switch (browserType) {

		case "ChromeBrowser":
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-orgins=*");
			driver = new ChromeDriver(co);
			WebDriverManager.chromedriver().setup();
			driver.manage().window().maximize();
			break;

		case "FirefoxBrowser":
			FirefoxOptions fo = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(fo);
			driver.manage().window().maximize();
			break;

		case "EdgeBrowser":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		default:
			break;
		}
	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileInputStream(
				"C:\\Users\\aishwarya\\eclipse-workspace\\Magento_Luma\\Config\\config.properties"));
		String value = (String) property.get(key);
		return value;
	}

	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
	}

	public void getURL(String url) {
		driver.get(url);
	}

	public void sendingKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void submit(WebElement element) {
		element.submit();
	}

	public WebElement findByID(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public WebElement findByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public void elementClick(WebElement element) {
		element.click();
	}

	public void clearContent(WebElement element) {
		element.clear();
	}

	public void threadSleep(int seconds) throws InterruptedException {
		Thread.sleep(seconds);
	}

	public String gettingText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void selectId(WebElement element, int val) {
		Select s = new Select(element);
		s.selectByIndex(val);
	}

	public void selectText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void actionDD(WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).perform();
	}

	public void actionDC(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void actionMove(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click();
	}

	public void actionRightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
	}

	public void robo(int event1, int evenet2) throws AWTException {
		Robot rob = new Robot();
		rob.keyPress(event1);
		rob.keyRelease(evenet2);
	}

//	public void fileUpload(String xpathString, String fileLocation) {
//		findByXpath(xpathString).sendKeys(fileLocation)
//	}

	public void disableTextbox(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement textbox = driver.findElement(By.xpath(value));
		js.executeScript("arguments[0].disabled = true", textbox);
	}

}
