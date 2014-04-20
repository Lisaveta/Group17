package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase{

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
	return wrapContactDataForProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromFile")
	public void contactModificationTests(ContactData contact) throws Exception{
   
	// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

	Random rnd = new Random();
	int index = rnd.nextInt(oldList.size()-1);

	app.getContactHelper().modifyContact(index, contact);
 
    //save new state
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
	//SortedListOf<ContactData> newList 
	//= new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
	
	// compare states
	assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}
}
