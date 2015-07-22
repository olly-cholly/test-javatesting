package com.example.tests;


import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randonValidContactGenerator")	
	public void modifySomeContact(ContactData contact) {
		app.getNavigationHelper().returnToMainPage();
		
	    //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	      
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getContactHelper().initContactModification(0);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContact(index);
	    app.getContactHelper().returnToHomePage();
	    
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	        
	    //compare state  
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(newList);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	    
	}

}
