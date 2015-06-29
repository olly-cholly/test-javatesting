package com.example.tests;

import org.testng.annotations.Test;

public class UserGroupCreating extends TestBase {
  @Test
  public void nonEmptyUserGroupCreation() throws Exception {
	openMainPage();
    openGroupPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name Test1";
    group.header = "group header Test1";
    group.footer = "group footer Test1";
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
