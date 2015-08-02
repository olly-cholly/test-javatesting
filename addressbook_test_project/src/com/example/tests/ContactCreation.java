package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;


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
    //app.navigateTo().mainPage();
 
    //save old state
    ContactHelper contactHelper = app.getContactHelper();
    SortedListOf<ContactData> oldList = contactHelper.getContacts();
      
    //actions
	app.getContactHelper().createContact(contact);
    
    
    //save new state
	SortedListOf<ContactData> newList = contactHelper.getContacts();
        
    //compare state  
	assertThat(oldList, equalTo(newList.without(contact)));
	assertThat(newList, equalTo(oldList.withAdded(contact)));
    
  }
  
}
