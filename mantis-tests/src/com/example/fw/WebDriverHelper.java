package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

public class WebDriverHelper extends HelperBase{

	private static WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private final ApplicationManager manager;
	
//	public boolean acceptNextAlert = true;
//	private WebDriverWait wait;
	
	public WebDriverHelper(ApplicationManager manager) {
		this.manager = manager;
		  String browser = manager.getProperties("browser");
		  if ("firefox".equals(browser)) {
		  driver = new FirefoxDriver();
		  }else if ("ie".equals(browser)){
		  driver = new InternetExplorerDriver(); 
		  }else if ("chrome".equals(browser)){
		  driver = new ChromeDriver(); 
		  }else{
			  throw new Error("неподдерживаемый браузер:" + browser);
		  }
		
		public void stop() {
		    driver.quit();
		  }	
			
		public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
			}
		return (HibernateHelper) hibernateHelper;
			
	}
	}

	
	
	
	
	
	
	
	
	
	
	//___________________________
	

	public String closeAlertAndGetItsText() {
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
	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }
	protected void type(By locator, String text) {
		if (text != null) {
			findElement(locator).clear();
			findElement(locator).sendKeys(text);
		}
	}

}
