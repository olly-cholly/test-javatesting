package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class UserGroupCreating extends TestBase {
  @Test
  public void nonEmptyUserGroupCreation() throws Exception {
	app.getNavigationHelper().returnToMainPage();
    app.getNavigationHelper().openGroupPage();
    
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions    
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "AAA";
    group.header = "group header Test1";
    group.footer = "group footer Test1";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
        
    //compare state    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }
  
  @Test
  public void emptyUserGroupCreation() throws Exception {
	  app.getNavigationHelper().returnToMainPage();
	  app.getNavigationHelper().openGroupPage();
	  
	//save old state
	List<GroupData> oldList = app.getGroupHelper().getGroups();
	  
	//actions	 
	GroupData group = new GroupData("", "", "");
	app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupCreation();
	app.getGroupHelper().returnToGroupPage();
	
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
        
    //compare state    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);	
	
  }
}
