package com.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
	app = new ApplicationManager();
	}

	
	@AfterMethod
	@AfterTest
	public void tearDown() throws Exception {
	app.stop();	
	}
	
	
	public static List<Object[]> wrapGroupDataForProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}


	@DataProvider
		public Iterator<Object[]>randomValidContactGenerator(){
			List<Object[]> list = new ArrayList<Object[]>();
			for (int i = 0; i < 5; i++){
			ContactData contact = new ContactData()
			.withName(generateRandomString())
			.withLastname(generateRandomString())
			.withAddress(generateRandomString())
			.withPhone1(generateRandomPhone())
			.withPhone3(generateRandomPhone())
			.withWphone1(generateRandomPhone())
			.withMail1(generateRandomEmail())
			.withMail2(generateRandomEmail())
			.withByear(generateRandomString())
			.withAddress2(generateRandomString())
			.withPhone2(generateRandomPhone());
			list.add(new Object[]{contact});
		}
				
		return list.iterator();
	}
// для групп больше не нужен. когда буду переделывать для контактов - удалить
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
		public String generateRandomPhone(){
			Random rnd = new Random();
//			if (rnd.nextInt(3) == 0) {
//				return "";
//			}else{
				return "+7" + rnd.nextInt();
			}


}

