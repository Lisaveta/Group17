package com.example.fw;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class HelperWithWebDriverBase{
	
	protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptNextAlert = true;
	private WebDriverWait wait;

	public HelperWithWebDriverBase(ApplicationManager applicationManager) {
 		
	}

	protected void click(By locator) {
		findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if (text != null)
		new Select(findElement(locator))
	    .selectByVisibleText(text);
	}

	public boolean isElementPresent(By by) {
	    try {
	      findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	protected void type(By locator, String text) {
		if (text != null) {
			findElement(locator).clear();
			findElement(locator).sendKeys(text);
		}
	}
	protected void type(String locator, String name) {
		driver.findElement(By.name(locator)).clear();
		driver.findElement(By.name(locator)).sendKeys(name);
	}	
	protected WebElement findElement(By linkText) {
		try {
		return driver.findElement(linkText);
		}catch ();
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
	
}