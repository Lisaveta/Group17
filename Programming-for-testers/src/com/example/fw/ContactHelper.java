package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		}
	
	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.name);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.phone1);
		type(By.name("mobile"), contact.phone3);
		type(By.name("work"), contact.wphone1);
		type(By.name("email"), contact.mail1);
		type(By.name("email2"), contact.mail2);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	    type(By.name("byear"), contact.byear);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	
	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void initContactModification(int index) {
	    selectContact(index);
	}

	private void selectContact(int index) {
		initModificationContact(index);
	}

	private void initModificationContact(int index) {
		click(By.xpath("//img[@alt='Edit'][" + index + "]"));
	}

	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
	}
	public void submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));		
	}


}
