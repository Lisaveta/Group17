package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;

public class ManyGroupRemovalTests extends TestBase{

	@Test
	
	public void deleteSomeGroup() {
		for(int i=0;i<10;i++){    
			app.getGroupHelper().getGroups();
			app.getGroupHelper().deleteGroup(0);
		}
	}
}
