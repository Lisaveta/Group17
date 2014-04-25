package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import com.example.utils.SortedListOf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException{
	return wrapGroupDataForProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	
	@Test(dataProvider = "groupsFromFile")
	public void modifySomeGroup(GroupData group) {
    
    // будет возвращать список имеющихся групп (список объектов типа groupData)
		//save old state 
   	SortedListOf<GroupData> oldListBD 
		= new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
   	
   	//подготовка тестовых данных
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size() - 1);
   
    // actions
    app.getGroupHelper().modifyGroup(index, group);
 
	// save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();  
 	
    // compare states
    assertThat(newList, equalTo(oldListBD.without(index).withAdded(group)));
	}
}
