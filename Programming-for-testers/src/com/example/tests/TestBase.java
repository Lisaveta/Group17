package com.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	
	@BeforeTest
	public void setUp() throws Exception {
	app = new ApplicationManager();
	}

	
	@AfterTest
	public void tearDown() throws Exception {
	app.stop();	
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupsGenerator(){
	List<Object[]> list = new ArrayList<Object[]>();
	for (int i = 0; i < 5; i++){
		GroupData group = new GroupData()
		.withName(generateRandomString())
		.withHeader(generateRandomString())
		.withFooter(generateRandomString());
		
		list.add(new Object[]{group});
	}
		return list.iterator();
	}
	
	@DataProvider
		public Iterator<Object[]>randomValidContactGenerator(){
			List<Object[]> list = new ArrayList<Object[]>();
			for (int i = 0; i < 5; i++){
			ContactData contact = new ContactData();
			contact.name = generateRandomString();
			contact.lastname = generateRandomString();
			contact.address = generateRandomString();
			contact.address2 = generateRandomString();
			contact.phone1 = generateRandomString();
			contact.phone3 = generateRandomString();
			contact.wphone1 = generateRandomString();
			contact.phone2 = generateRandomString();
			contact.mail1 = generateRandomEmail();
			contact.mail2 = generateRandomEmail();
			contact.byear = generateRandomString();	
			list.add(new Object[]{contact});
		}
				
		return list.iterator();
	}

		public String generateRandomString(){
			Random rnd = new Random();
//			if (rnd.nextInt(3) == 0) {
//				return "";
//			}else{
				return "test" + rnd.nextInt();
			}
		
		public String generateRandomEmail(){
			Random rnd = new Random();
//			if (rnd.nextInt(3) == 0) {
//				return "";
//			}else{
				return rnd.nextInt() +"@mail.ru";
			}


}

