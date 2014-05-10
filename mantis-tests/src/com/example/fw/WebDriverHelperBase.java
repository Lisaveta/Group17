package com.example.fw;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public abstract class WebDriverHelperBase extends HelperBase {
	
	protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptNextAlert = true;
	private WebDriverWait wait;
	private StringBuffer verificationErrors = new StringBuffer();
	
	public WebDriverHelperBase(ApplicationManager manager) {
		super(manager);
		this.driver = manager.getDriver();
//		String browser = manager.getProperties("browser");
//		  if ("firefox".equals(browser)) {
//		  driver = new FirefoxDriver();
//		  }else if ("ie".equals(browser)){
//		  driver = new InternetExplorerDriver(); 
//		  }else if ("chrome".equals(browser)){
//		  driver = new ChromeDriver(); 
//		  }else{
//			  throw new Error("неподдерживаемый браузер:" + browser);
//		  }
//
//		this.driver = manager.getDriver();
//		this.manager = manager;
//		wait = new WebDriverWait(driver, 10);

	}

	protected void click(By locator) {
		findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if (text != null)
		new Select(findElement(locator))
	    .selectByVisibleText(text);
	}

	public boolean isElementPresent(By locator) {
	    try {
	      findElement(locator);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	protected void type(By locator, String text) {
		if (text != null) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
		}
	}
//	protected WebElement findElement(By locator) {
//		return driver.findElement(locator);
//	}

	protected WebElement findElement(By linkText) {
		try {
			return driver.findElement(linkText);
		} catch (Exception e) {
			return null;
		}
	}
	
	protected List<WebElement> findElements(By linkText) {
		return driver.findElements(linkText);
	}

	
	protected void openUrl(String string) {
		driver.get(manager.getProperty("baseUrl") + string);
	}
	
	protected void openAbsoluteUrl(String string) {
		driver.get(string);
	}
	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }	
	protected String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	    	acceptNextAlert = true;
	    }
	  }

}