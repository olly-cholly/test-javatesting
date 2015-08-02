package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class UserGroupCreating extends TestBase {
	
	@Test(dataProvider = "randonValidGroupGenerator")
	public void userGroupCreationWithValidData(GroupData group) throws Exception {
    
    //save old state
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions    
    app.getGroupHelper().createGroup(group);
        
    //save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
        
    //compare state  
    assertThat(newList, equalTo(oldList.withAdded(group)));
      
  }
  
}