package com.example.tests;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.fw.User;

public class SignupTest extends TestBase{
	
	
	public User user = new User().setLogin("testUser1").setPassword("123456")
			.setEmail("testuser1@localhost");

	
	@BeforeClass
	public void createMailUser(){
		if (! app.getJamesHelper().doesUserExist(user.login)) {
		app.getJamesHelper().createUser(user.login, user.password);
		}
	}
	
	
	@Test
	public void newUserShouldSignup(){
				
		app.getAccountHelper().signup(user);
		pause(3000);
		app.getAccountHelper().login(user);
		assertThat(app.getAccountHelper().lopggedUser());
		
	}
	@AfterClass
	public void deleteMailUser(){
		if (app.getJamesHelper().doesUserExist(user.login)) {
			app.getJamesHelper().deleteUser(user.login);
		}
	}

}
