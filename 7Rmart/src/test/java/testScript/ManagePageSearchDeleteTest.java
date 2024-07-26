package testScript;


import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constance.Constants;
import constance.Messages;
import pages.LoginPage;
import pages.ManagePageSearchDeletePage;
import utilities.ExcelUtility;

public class ManagePageSearchDeleteTest extends Base{
	@Test
	public void managePageSearchAndDelete() {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		String titleValue=ExcelUtility.getStringData(0, 1,Constants.MANAGE_PAGES_SEARCH_AND_DELETE);
	    ManagePageSearchDeletePage managepagesearchanddelete=new ManagePageSearchDeletePage(driver);
	    managepagesearchanddelete.clickingManagePage();
		managepagesearchanddelete.enterTitleValue(titleValue);
		managepagesearchanddelete.deleteTitle();
		//managepagesearchanddelete.searchManagePage();
		
		boolean ismanagepageloaded=managepagesearchanddelete.isManagePageLoaded();
		Assert.assertTrue( ismanagepageloaded,Messages.MANAGE_PAGE_IS_NOT_LOADED);
		
		boolean isalertmessagedisplayaftersaving=managepagesearchanddelete.isAlertMessageDisplayed();
        Assert.assertTrue(isalertmessagedisplayaftersaving,Messages.SEARCH_AND_DELETE_ALERT_PAGE_IS_NOT_LOADED);
	
}
	

}
