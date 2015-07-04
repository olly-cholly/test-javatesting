package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreation extends TestBase {
  @Test
  public void nonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().returnToMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "name";
    contact.lastname = "lastname";
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
  }
  
  @Test
  public void emptyContactCreation() throws Exception {
    app.getNavigationHelper().returnToMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "", ""));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToMainPage();
  }
}
