package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;

public class ContactCreation extends TestBase {
	

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}	
	}
	
  @Test(dataProvider = "randonValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.getNavigationHelper().returnToMainPage();
 
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
      
    //actions
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToMainPage();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
        
    //compare state  
    oldList.add(contact);
    Collections.sort(newList);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
}
