package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;


public class ContactCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	  
	app.navigateTo().mainPage();
	
	// save old state
	  SortedListOf<ContactData> oldList = (SortedListOf<ContactData>) app.getContactHelper().getContacts();
	
	// actions
	app.getContactHelper().createContact(contact);
 
    //save new state
	SortedListOf<ContactData> newList = (SortedListOf<ContactData>) app.getContactHelper().getContacts();
  
   // compare states
	assertThat(newList, equalTo(oldList.withAdded(contact)));
  	}
}
