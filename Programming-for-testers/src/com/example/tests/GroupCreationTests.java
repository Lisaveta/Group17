package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test(dataProvider = "randomValidGroupsGenerator")
  public void testValidGroupCreationWishValidData(GroupData group) throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    
    //save old state 
    // будет возвращать список имеющихся групп (список объектов типа groupData)
    
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    
    app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();  
    
    // compare states
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  	}
 }
