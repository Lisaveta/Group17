package com.example.tests;
import static org.testng.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.internal.runners.statements.Fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.example.fw.AccountHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;
import com.opera.core.systems.scope.protos.WmProtos.OpenURLArg;


public class SignupTest extends TestBase{
	
	
	public User user = new User().setLogin("testUser1").setPassword("123456")
			.setEmail("testuser1@localhost");
	private JamesHelper james;
	private AccountHelper accHelper;
	
	
	@BeforeClass
	public void createMailUser(){
		james = app.getJamesHelper();
		accHelper = app.getAccountHelper();
		if (! james.doesUserExist(user.login)) {
			james.createUser(user.login, user.password);
		}
	}
	
	
	@Test
	public void newUserShouldSignup(){
		
		accHelper.signup(user);
		accHelper.login(user);
		assertThat(accHelper.loggedUser(), equalTo(user.login));
	}

//	@Test
//	public void existingUserShouldNotSignup(){
//			try {	
//		accHelper.signup(user);
//			}catch (Exception e) {
//				assertThat(e.getMessage(), containsString(""));
//				return;
//			}
//			fail("Exception expected");
//	}

	@AfterClass
	public void deleteMailUser(){
		if (james.doesUserExist(user.login)) {
			james.deleteUser(user.login);
		}
	}

}
