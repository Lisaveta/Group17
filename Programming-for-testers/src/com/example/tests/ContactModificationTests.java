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

	@Test(dataProvider = "randomValidContactGenerator")
	public void contactModificationTests(ContactData contact) throws Exception{
    app.getNavigationHelper().openMainPage();
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();

	Random rnd = new Random();
	int index = rnd.nextInt(oldList.size()-1);

    
    app.getContactHelper().initContactModification(index);
	
	contact.name = "новое имя";
	contact.lastname = "новая фамилия";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnMainPage();

    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    // compare states

    oldList.remove(index);
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	
	}
}
