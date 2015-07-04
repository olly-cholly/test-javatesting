package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
	@Test		
	public void deleteSomeGroup() {
		app.getNavigationHelper().returnToMainPage();
	    app.getNavigationHelper().openGroupPage();
		app.getGroupHelper().deleteGroup(1);
	    app.getGroupHelper().returnToGroupPage();
	}


}
