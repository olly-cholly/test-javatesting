package com.example.tests;

import org.testng.annotations.Test;

public class AlsoUserGroupCreating extends TestBase {
 
  @Test
  public void nonEmptyUserGroupCreation() throws Exception {
	openMainPage();
    openGroupPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 4";
    group.header = "group header 4";
    group.footer = "group footer 4";
	fillGroupForm(group);
    submitGroupCreation();
    returnMainPage();
  }
  
  @Test
  public void emptyUserGroupCreation() throws Exception {
	  openMainPage();
	  openGroupPage();
	  initGroupCreation();
	  fillGroupForm(new GroupData("", "", ""));
	  submitGroupCreation();
	  returnMainPage();
  }
}
