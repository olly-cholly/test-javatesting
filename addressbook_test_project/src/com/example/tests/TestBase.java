package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();		
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();	   
	  }
	
	@DataProvider
	public Iterator<Object[]> randonValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			contact.lastname = generateRandomString();
		    contact.firstname = generateRandomString();
		    contact.address1 = generateRandomString();
		    contact.home = generateRandomString();
		    contact.mobile = generateRandomString();
		    contact.work = generateRandomString();
		    contact.email1 = generateRandomString();
		    contact.email2 = generateRandomString();
		    contact.bday = "-";
		    contact.bmonth = "-";
		    contact.byear = generateRandomString();
		    contact.group = "";
		    contact.address2 = generateRandomString();
		    contact.phone = generateRandomString();
		    list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randonValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[] {group});
		}
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
  
}
