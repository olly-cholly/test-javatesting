package com.example.tests;

import static org.testng.Assert.assertEquals;



import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreation extends TestBase {
  @Test
  public void nonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().returnToMainPage();
 
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
      
    //actions
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.lastname = "firstname";
    contact.firstname = "lastname";
    contact.address1 = "address1";
    contact.home = "home";
    contact.mobile = "mobile";
    contact.work = "work";
    contact.email1 = "email1";
    contact.email2 = "email2";
    contact.bday = "1";
    contact.bmonth = "January";
    contact.byear = "1985";
    contact.group = "group name Test1";
    contact.address2 = "address2";
    contact.phone = "phone";    
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
  
  @Test
  public void emptyContactCreation() throws Exception {
    app.getNavigationHelper().returnToMainPage();
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
      
    //actions
    ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "", "");
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
