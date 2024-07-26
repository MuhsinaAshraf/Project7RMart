package testScript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constance.Constants;
import pages.LoginPage;
import pages.SearchAdminUserPage;
import utilities.ExcelUtility;

public class SearchAdminUserTest extends Base{
	@Test
	public void searchAdminUser() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		String name=ExcelUtility.getStringData(1, 0,Constants.SEARCH_ADMIN_USER);
		 SearchAdminUserPage searchadminuser=new SearchAdminUserPage(driver);
		 searchadminuser. clickingAdminUsers();
		 searchadminuser.clickingSearchField();
		// waitForElementText(driver, usernamefield , name);
		searchadminuser.enteringUsername(name);
		 String nametype=ExcelUtility.getStringData(1, 1,Constants.SEARCH_ADMIN_USER);
		searchadminuser.selectingUserTypeField(nametype);
		 searchadminuser.clickOnSearchButton();
		 
		 boolean istabledisplayedbyclickingsearch=searchadminuser.tableDisplayed();
		Assert.assertTrue(istabledisplayedbyclickingsearch," not displayed");
		 
}

}