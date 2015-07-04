package com.example.tests;

import org.testng.annotations.Test;

public class UserGroupCreating extends TestBase {
  @Test
  public void nonEmptyUserGroupCreation() throws Exception {
	app.getNavigationHelper().returnToMainPage();
    app.getNavigationHelper().openGroupPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name Test1";
    group.header = "group header Test1";
    group.footer = "group footer Test1";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
  
  @Test
  public void emptyUserGroupCreation() throws Exception {
	  app.getNavigationHelper().returnToMainPage();
	  app.getNavigationHelper().openGroupPage();
	  app.getGroupHelper().initGroupCreation();
	  app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
	  app.getGroupHelper().submitGroupCreation();
	  app.getGroupHelper().returnToGroupPage();
  }
}
