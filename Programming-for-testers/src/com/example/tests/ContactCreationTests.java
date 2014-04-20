package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;

public class ContactCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
	return wrapContactDataForProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromFile")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	  
	app.navigateTo().mainPage();
	
	// save old state
	// SortedListOf<ContactData> oldList = (SortedListOf<ContactData>) app.getContactHelper().getContacts();
	  SortedListOf<ContactData> oldList = 
			  new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
	
	// actions
	app.getContactHelper().createContact(contact);
 
    //save new state
	//SortedListOf<ContactData> newList = (SortedListOf<ContactData>) app.getContactHelper().getContacts();
	SortedListOf<ContactData> newList = 
			  new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
	
  
   // compare states
	assertThat(newList, equalTo(oldList.withAdded(contact)));
  	}
}
