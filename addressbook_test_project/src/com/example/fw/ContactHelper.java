package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.fw.ContactHelper.MODIFICATION;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;


public class ContactHelper extends HelperBase{
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
		
	}
	private void rebuildCache() {	
		
		cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//td[2]"));
		for (WebElement checkbox : checkboxes) {
			String lastname = checkbox.getText();
			String firstname = checkbox.getText();
			//String title = checkbox.getAttribute("title");
			//contact.lastname = title.substring("Select (".length(), title.length() - ")".length());
			cachedContacts.add(new ContactData().withLastname(lastname).withFirstname(firstname));
		}
	}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
    	initContactCreation();
    	fillContactForm(contact, CREATION);
    	submitContactCreation();
    	returnToHomePage();
    	rebuildCache();
    	return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactModification(0);
		submitContactDeletion();
		returnToHomePage();
		rebuildCache();
		return this;
		
	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
		fillContactForm(contact, MODIFICATION);
		submitContact(index);
		returnToHomePage();
		rebuildCache();
		return this;
		
	}

	
	//-----------------------------------------------------------------

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"),contact.getFirstname());
	    type(By.name("lastname"),contact.getLastname());
	    type(By.name("address"),contact.getAddress1());
	    type(By.name("home"),contact.getHome());
	    type(By.name("mobile"),contact.getMobile());
	    type(By.name("work"),contact.getWork());
	    type(By.name("email"),contact.getEmail1());
	    type(By.name("email2"),contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"),contact.getByear());
	    // if (formType == CREATION) {
	    	//selectByText(By.name("new_group"), "group 1");
	    // } else {
	    //	if (driver.findElements(By.name("new_group")).size() != 0) {
	    //		throw new Error("Group selector exists in contact modification form");
	    //	}
	    //}
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"),contact.getPhone());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
		
	}

	public ContactHelper submitContact(int index) {
		click(By.xpath("(//input[@value='Update'])"));
		cachedContacts = null;
		return this;
		
	}

	public ContactHelper initContactModification(int index) {
	click(By.xpath("//tr[2]//img[@title = 'Edit']"));
	//[" + (index+1) + "]"
	return this;
	
	}
	
	public ContactHelper submitContactDeletion() {
		click(By.xpath("(//input[@value='Delete'])"));
		cachedContacts = null;
		return this;
	}
	
}
