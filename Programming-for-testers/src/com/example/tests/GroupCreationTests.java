package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;


public class GroupCreationTests extends TestBase {

	
  @Test(dataProvider = "randomValidGroupsGenerator")
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
