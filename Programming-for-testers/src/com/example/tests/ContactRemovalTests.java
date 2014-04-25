package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.Collections;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;

public class ContactRemovalTests extends TestBase{

	@Test
	public void deleteSomeContact() {
 		
		
		// save old state получаем из БД
		 SortedListOf<ContactData> oldListBD = 
				  new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());

		// подготовка тестовых данных
		//SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
   
		Random rnd = new Random();
		int index = rnd.nextInt(oldListBD.size()-1);
   
	
		// совершаем над ними экшн)))
		app.getContactHelper().initContactModification(index).deleteContact();
    
    
		//save new state
		 SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
   
	  //SortedListOf<ContactData> newList = 
		//	  new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());

    // compare states
    assertThat(newList, equalTo(oldListBD.without(index)));
 	}
}
