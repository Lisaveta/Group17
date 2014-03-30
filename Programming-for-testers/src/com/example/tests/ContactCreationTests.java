package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	  
	app.navigateTo().mainPage();
	
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	// actions
    app.getContactHelper().initContactCreation();
	contact.bday = "1";
	contact.bmonth = "January";
	contact.byear = "1980";	
    app.getContactHelper().fillContactForm(contact, CREATION);
    app.getContactHelper().submitContactCreation();
    app.navigateTo().returnMainPage();

    //save new state
   List<ContactData> newList = app.getContactHelper().getContacts();
    // compare states
  
    oldList.add(contact);
    Collections.sort(oldList);
    AssertJUnit.assertEquals(newList, oldList);
  		}
}
