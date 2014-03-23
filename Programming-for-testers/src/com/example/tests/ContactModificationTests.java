package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void contactModificationTests() {
    app.getNavigationHelper().openMainPage();
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();

    
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
}
