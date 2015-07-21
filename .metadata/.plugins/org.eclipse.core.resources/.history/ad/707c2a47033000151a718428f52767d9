package com.example.tests;


import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test		
	public void modifySomeContact() {
		app.getNavigationHelper().returnToMainPage();
		app.getContactHelper().initContactModification(1);
		ContactData contact = new ContactData();
		contact.firstname = "123";
		contact.lastname = "321";
		contact.bday = "13";
		contact.bmonth = "March";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContact(1);
	    app.getContactHelper().returnToHomePage();
	}

}
