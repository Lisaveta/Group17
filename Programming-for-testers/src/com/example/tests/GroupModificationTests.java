package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import java.util.Random;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

	@Test(dataProvider = "randomValidGroupsGenerator")
	public void modifySomeGroup(GroupData group) {
    //save old state 
    // будет возвращать список имеющихся групп (список объектов типа groupData)
    
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
 
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size() - 1);
   
    // actions
    app.getGroupHelper().modifyGroup(index, group);
 
	// save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();  

    // compare states
    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
}
