package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void contactModificationTests() {
    app.getNavigationHelper().openMainPage();
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();

	Random rnd = new Random();
	int index = rnd.nextInt(oldList.size()-1);

    
    app.getContactHelper().initContactModification(1);
	ContactData contact = new ContactData();
	contact.name = "1111111";
	contact.lastname = "22222";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnMainPage();

    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    // compare states

    oldList.remove(0);
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	
	}
	@DataProvider
	public Iterator<Object[]>randomValidsContactGenerator(){
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
			contact.mail1 = generateRandomString();
			contact.mail2 = generateRandomString();
			contact.byear = generateRandomString();	
			list.add(new Object[]{contact});
		}
				
		return list.iterator();
	}

	public String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		}else{
			return "test" + rnd.nextInt();
		}
	 }
}
