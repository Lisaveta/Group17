package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class ManyContactsRemovalTests extends TestBase{

	@Test
	public void deleteSomeContact() {
		for(int i=0;i<1;i++){
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactModification(0);
	app.getContactHelper().deleteContact();
    app.getNavigationHelper().returnMainPage();
		}
 	}
}
