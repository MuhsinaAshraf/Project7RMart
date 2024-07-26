package testScript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constance.Constants;
import constance.Messages;
import pages.AdminUserStatusPage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class AdminUserStatusTest extends Base{
	@Test

	public void adminUserStatus() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1, Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AdminUserStatusPage adminuserstatus=new AdminUserStatusPage(driver);
		adminuserstatus.clickOnAdminUserPage();
		//adminuserstatus.adminHeaderPage();
		adminuserstatus.CurrentUserStatus();
		adminuserstatus.clickOnStatusIcon();
		
		
		
		//boolean isalertmessagedisplayaftersaving=adminuserstatus.isAlertMessageDisplayed();
        //assertTrue(isalertmessagedisplayaftersaving,"page is not loaded ");
		
		boolean isadminuserpageavailable=adminuserstatus.isAdminHeaderPageLoaded();
        Assert.assertTrue(isadminuserpageavailable,Messages.HEADER_ADMIN_IS_NOT_LOADED);
        boolean isstatusiconloaded=adminuserstatus.isStatusIconVisible();
        Assert.assertTrue(isstatusiconloaded,Messages.STATUS_ICON_IS_NOT_LOADED);
	}
}