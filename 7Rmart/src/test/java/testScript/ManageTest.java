package testScript;


import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constance.Constants;
import constance.Messages;
import pages.LoginPage;
import pages.ManagePage;
import utilities.ExcelUtility;


public class ManageTest extends Base {
	@Test
	public void verifyTheUserIsAbleToEnterIntoManagePages() throws IOException, AWTException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0, Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		
		String titlevalue=ExcelUtility.getStringData(1, 0, Constants.MANAGE_PAGES_NEW_DATA);
		String descriptionvalue=ExcelUtility.getStringData(1, 1, Constants.MANAGE_PAGES_NEW_DATA);
		String pagenamevalue=ExcelUtility.getStringData(1, 2,  Constants.MANAGE_PAGES_NEW_DATA);

		ManagePage managepage=new ManagePage(driver);
		managepage.moreinfonav();
		
		managepage.clickOnNewButton();
		managepage.enterTitleField(titlevalue);
		managepage.enterDescription(descriptionvalue);
		managepage.enterPage(pagenamevalue);
		managepage.clickOnAddImage();
		managepage.clickingSave();
		
		
		//boolean islistpagedisplayed=managepage.isListPageDisplayed();
		//assertTrue(islistpagedisplayed,"Page is not loaded");
		
		boolean isalertmessagedisplayaftersaving=managepage.isAlertMessageDisplayed();
        Assert.assertTrue(isalertmessagedisplayaftersaving,Messages.ALERT_WINDOW_NOT_LOADED);
        
			
		
	}

}
