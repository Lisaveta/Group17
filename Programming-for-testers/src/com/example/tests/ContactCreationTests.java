package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class ContactCreationTests extends TestBase {
	
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	// actions
    app.getContactHelper().initContactCreation();
	ContactData contact = new  ContactData();
	contact.name  = "name";
	contact.lastname = "last name";
	contact.address = "address";
	contact.address2 = "address2";
	contact.phone1 = "123456";
	contact.phone3 = "654321";
	contact.wphone1 = "555";
	contact.phone2 = "44466655";
	contact.mail1 = "email1";
	contact.mail2 = "email2";
	contact.bday = "1";
	contact.bmonth = "January";
	contact.byear = "1980";	
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnMainPage();

    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    // compare states
    assertEquals(newList.size(), oldList.size() + 1);
  
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
  //@Test
  public void testEmptyContactCreation() throws Exception {
	ContactData contact = new  ContactData();
	contact.name  = "";
	contact.lastname = "";
	contact.address = "";
	contact.address2 = "";
	contact.phone1 = "";
	contact.phone3 = "";
	contact.wphone1 = "";
	contact.phone2 = "";
	contact.mail1 = "";
	contact.mail2 = "";
	contact.bday = "-";
	contact.bmonth = "-";
	contact.byear = "";	
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnMainPage();
  }
}