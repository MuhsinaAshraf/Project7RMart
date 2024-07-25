package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.LoginPage;
import pages.SearchAdminUserPage;
import utilities.ExcelUtility;

public class SearchAdminUserTest extends Base{
	@Test
	public void searchAdminUser() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		String name=ExcelUtility.getStringData(1, 0, "SearchAdminUser");
		 SearchAdminUserPage searchadminuser=new SearchAdminUserPage(driver);
		 searchadminuser. clickingAdminUsers();
		 searchadminuser.clickingSearchField();
		// waitForElementText(driver, usernamefield , name);
		searchadminuser.enteringUsername(name);
		 String nametype=ExcelUtility.getStringData(1, 1, "SearchAdminUser");
		searchadminuser.selectingUserTypeField(nametype);
		 searchadminuser.clickOnSearchButton();
		 
		 boolean istabledisplayedbyclickingsearch=searchadminuser.tableDisplayed();
		 assertTrue(istabledisplayedbyclickingsearch," not displayed");
		 
}

}