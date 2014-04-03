package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.example.fw.ContactHelper;
import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	  
	//app.navigateTo().mainPage();
	
	// save old state
	ContactHelper contactHelper = app.getContactHelper();
	List<ContactData> oldList = contactHelper.getContacts();
	
	// actions
	app.getContactHelper().createContact(contact);
 
    //save new state
   List<ContactData> newList = contactHelper.getContacts();
    // compare states
  
    oldList.add(contact);
    Collections.sort(oldList);
    AssertJUnit.assertEquals(newList, oldList);
  	}
}
