package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mysql.jdbc.Driver;

public class ApplicationManager {
	//singleton - единстенный экземпл€р
	private static ApplicationManager singleton;
	private Properties props;
	private WebDriverHelperBase webDriverHelperBase;
	private HibernateHelper hibernateHelper;
	private AccountHelper accountHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;
	
	
	private static WebDriver driver;
	
	
	public static ApplicationManager getInstance(){
		if (singleton == null) {
			singleton = new ApplicationManager();
	}
		return singleton;
}	
	public void setProperties (Properties props) {
		this.props = props;
	}

	public String getProperties(String key){
		return props.getProperty(key);
	}

	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
	}
			return hibernateHelper;
	}

	public AccountHelper getAccountHelper() {
		if (accountHelper == null) {
			accountHelper = new AccountHelper(this);
	}
			return accountHelper;
	}

	public void stop() {
	    driver.quit();
	  }
	
	public MailHelper getMailHelper() {
		if (mailHelper == null) {
			mailHelper = new MailHelper(this);
	}
			return mailHelper;
	}
	public String getProperty(String key){
		return props.getProperty(key);
	}
	public JamesHelper getJamesHelper() {
		if (jamesHelper == null) {
			jamesHelper = new JamesHelper(this);
	}
		return jamesHelper;
	}
	public WebDriver getDriver() {
		if (driver == null){
			String browser = props.getProperty("browser");
			if ("firefox".equals(browser)) {
				driver = new FirefoxDriver();
		}else if ("ie".equals(browser)){
				driver = new InternetExplorerDriver();
		}else{
				throw new Error("Unsupported browser" + browser);
			}
			browser = props.getProperty("baseUrl");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(browser);
		}
		return driver;
	}
}

