package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		}
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getName());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getPhone1());
		type(By.name("mobile"), contact.getPhone3());
		type(By.name("work"), contact.getWphone1());
		type(By.name("email"), contact.getMail1());
		type(By.name("email2"), contact.getMail2());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"), contact.getByear());
	    if (formType == CREATION) {
	    	// selectByText(By.name("new_group"), "group 1");
	    	} else {
	    		if (driver.findElements(By.name("new_group")).size() !=0) {
	    			throw new Error("Group selector exists in contact modification form");
	    		}
	    }
	    
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhone2());
	
		return this;
	}

	
	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper initContactModification(int index) {
	    selectContact(index);
	    return this;
	}

	private ContactHelper selectContact(int index) {
		initModificationContact(index);
		return this;
	}

	private ContactHelper initModificationContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index +1) + "]"));
		return this;
	}

	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
	}
	public ContactHelper submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));		
		return this;
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> tableRows = driver.findElements(By.xpath("//table//tr[@name='entry']"));
		for (WebElement row : tableRows) {
			WebElement firstName = row.findElement(By.xpath("./td[3]"));
			String name = firstName.getText();
			WebElement lastName = row.findElement(By.xpath("./td[2]"));
			String lastname = lastName.getText();
			contacts.add(new ContactData().withName(name).withLastname(lastname));
		
		}
		return contacts;		
	}
}


