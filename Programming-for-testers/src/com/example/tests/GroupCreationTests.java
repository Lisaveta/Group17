package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;


public class GroupCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException{
	return wrapGroupDataForProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	
	@Test(dataProvider = "groupsFromFile")
	public void testValidGroupCreationWishValidData(GroupData group) throws Exception {
    //save old state 
    // будет возвращать список имеющихся групп (список объектов типа groupData)
    
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().createGroup(group);
   
    // save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();  
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(group)));
  	}
 }
