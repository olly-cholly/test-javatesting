package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;


public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"),contact.firstname);
	    type(By.name("lastname"),contact.lastname);
	    type(By.name("address"),contact.address1);
	    type(By.name("home"),contact.home);
	    type(By.name("mobile"),contact.mobile);
	    type(By.name("work"),contact.work);
	    type(By.name("email"),contact.email1);
	    type(By.name("email2"),contact.email2);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	    type(By.name("byear"),contact.byear);
	    //selectByText(By.name("new_group"), contact.group);
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(contact.address2);
	    type(By.name("phone2"),contact.phone);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}
	
	public void returnToHomePage() {
		click(By.linkText("home page"));
		
	}

	public void initContactModification(int index) {
		click(By.xpath("//tr[2]//img[@title = 'Edit'][" + (index+1) + "]"));
			
	}

	public void deleteContact(int index) {
		click(By.xpath("(//input[@value='Delete'])"));
		
	}

	public void submitContact(int index) {
		click(By.xpath("(//input[@value='Update'])"));		
		
	}
	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//td[2]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			contact.lastname =checkbox.getText();
			//String title = checkbox.getAttribute("title");
			//contact.lastname = title.substring("Select (".length(), title.length() - ")".length());
			contacts.add(contact);
		}
		return contacts;
	}


}
