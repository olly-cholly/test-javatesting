package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test		
	public void deleteSomeContact() {
		app.getNavigationHelper().returnToMainPage();
		app.getContactHelper().initContactModification(1);
		app.getContactHelper().deleteContact(1);
	    app.getContactHelper().returnToHomePage();
	}

}