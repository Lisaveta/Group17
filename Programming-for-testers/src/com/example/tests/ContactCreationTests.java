package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
  @Test
  public void testNonEmptyContactCreation() throws Exception {
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
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnMainPage();
  }
  
  @Test
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