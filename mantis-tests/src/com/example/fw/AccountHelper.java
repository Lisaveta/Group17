package com.example.fw;

import java.util.regex.Pattern;
import javax.jms.MapMessage;

import net.sourceforge.htmlunit.corejs.javascript.ast.ElementGet;

import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;

public class AccountHelper extends WebDriverHelperBase{

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		
	}

	public void signup(User user) {
	openUrl("/signup_page.php");
	click(By.cssSelector("span.bracket-link"));
	type(By.name("username"), user.login);
	type(By.name("email"), user.email);
	click(By.cssSelector("input.button"));
	
	WebElement errorMessage = findElement(By.cssSelector("table.with50 tbody tr td p"));
	if (errorMessage != null){
		throw new RuntimeException(errorMessage.getText());
	}
	
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
	java.util.regex.Matcher matcher = regex.matcher(text);
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

	public String loggedUser() {
		WebElement element = findElement(By.cssSelector("td.login-info-left span"));
		return element.getText();
	}
}
