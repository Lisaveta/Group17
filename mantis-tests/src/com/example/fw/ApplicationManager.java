package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.mysql.jdbc.Driver;

public class ApplicationManager {
	//singleton - единстенный экземпл€р
	private static ApplicationManager singleton;
	private Properties props;
	private WebDriverHelper webDriverHelper;
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

	public WebDriverHelper getWebDriverHelper() {
		if (webDriverHelper == null) {
			webDriverHelper = new WebDriverHelper(this);
	}
			return webDriverHelper;
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
	public String getProperty(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public JamesHelper getJamesHelper() {
		if (jamesHelper == null) {
			jamesHelper = new JamesHelper(this);
	}
		return jamesHelper;
	}
}

