package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test		
	public void deleteSomeContact() {
		app.getNavigationHelper().returnToMainPage();
		
	    //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	      
	    //actions
		app.getContactHelper().initContactModification(0);
		app.getContactHelper().deleteContact(index);
	    app.getContactHelper().returnToHomePage();
	    
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	        
	    //compare state  
	    oldList.remove(0);
	    Collections.sort(newList);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	    
	    
	}

}
