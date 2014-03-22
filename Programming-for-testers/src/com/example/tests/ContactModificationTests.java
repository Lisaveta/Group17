package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void contactModificationTests() {
    app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactModification(1);
	ContactData contact = new ContactData();
	contact.name = "1111111";
	contact.lastname = "22222";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnMainPage();
  	}
}
