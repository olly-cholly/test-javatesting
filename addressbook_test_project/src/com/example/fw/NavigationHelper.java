package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToMainPage() {
	    driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void openGroupPage() {
		click(By.linkText("groups"));
	}

}
