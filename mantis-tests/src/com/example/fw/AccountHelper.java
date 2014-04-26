package com.example.fw;

import java.util.regex.Pattern;
import javax.jms.MapMessage;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends HelperWithWebDriverBase{

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		
	}

	public void signup(User user) {
	openUrl("/");
	click(By.cssSelector("span.bracket-link"));
	type(By.name("username"), user.login);
	type(By.name("email"), user.email);
	click(By.cssSelector("input.button"));
	
	//ставим задержку перед получением письма
	pause(3000);
	
	String msg = manager.getMailHelper().getNewMail(user.login, user.password);
	String confirmationLink = getConfirmationLink(msg);
	openAbsoluteUrl(confirmationLink);
	
	type(By.name("password"), user.password);
	type(By.name("password_confirm"), user.password);
	click(By.cssSelector("input.button"));

}
	// \\S - символ отличный от пробела

	
	public String getConfirmationLink(String text) {
	Pattern regex = Pattern.compile("http:\\S*");
	Matcher matcher = regex.matcher(text);
	if (matcher.find()) {
		return matcher.group();
	}else{
		return "";
		}
	}
	public String lopggedUser() {
		WebElement element = findElement(By.cssSelector("td.login-info-left span"));
		return element.getText();
	}

	public void login(User user) {
		openUrl("/");
		type(By.name("username"), user.login);
		type(By.name("password"), user.password);
		click(By.cssSelector("input.button"));
	
	}
}
