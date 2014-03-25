package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		click(By.xpath("//img[@alt='Edit'][" + (index +1) + "]"));
	}

	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
	}
	public void submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));		
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> tableRows = driver.findElements(By.xpath("//table//tr[@name='entry']"));
		for (WebElement row : tableRows) {ContactData contact = new ContactData();
			WebElement firstName = row.findElement(By.xpath("./td[3]"));
			contact.name = firstName.getText();
			WebElement lastName = row.findElement(By.xpath("./td[2]"));
			contact.lastname = lastName.getText();
			contacts.add(contact);
		
		}
		return contacts;		
	}
	
	
	
	// поменять метод getContacts, который читает данные из приложения? что бы он firstname и lastname брал из "правильных" столбцов, а не как написано в заголовке
	// метод getContact создала не правильный...
//	public List<ContactData> getContacts() {
//		List<ContactData> contacts = new ArrayList<ContactData>();
//		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
//		for (WebElement checkbox : checkboxes) {
//			ContactData contact = new ContactData();
//			String title = checkbox.getAttribute("title");
//			contact.lastname = title.substring("Select (".length(), title.length() - ")".length());
//			contact.name = title.substring("Select (".length(), title.length() - ")".length());

	//		contact.address = title.substring("Select (".length(), title.length() - ")".length());
	//		contact.phone1 = title.substring("Select (".length(), title.length() - ")".length());
//			contacts.add(contact);
//		}
//		return contacts;
//	}
}


