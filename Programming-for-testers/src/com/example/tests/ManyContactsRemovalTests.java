package com.example.tests;

import java.util.List;
import org.testng.annotations.Test;
public class ManyContactsRemovalTests extends TestBase{

	//@Test
	public void deleteSomeContact() {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactModification(1);
	app.getContactHelper().deleteContact();
    app.getNavigationHelper().returnMainPage();
	}
}
