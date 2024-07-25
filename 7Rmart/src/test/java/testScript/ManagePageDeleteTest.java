package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import constance.Constants;
import constance.Messages;
import pages.LoginPage;
import pages.ManagePageDeletepage;
import utilities.ExcelUtility;

public class ManagePageDeleteTest extends Base {
	@Test
	public void managePageDelete() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		
		ManagePageDeletepage managepagedelete=new ManagePageDeletepage(driver);
		managepagedelete.moreinfo();
		managepagedelete.listPage();
		managepagedelete.deleteField();
		
		boolean isalertmessagedisplayaftersaving=managepagedelete.isAlertMessageDisplayed();
        assertTrue(isalertmessagedisplayaftersaving,Messages.HEADER_LIST_PAGES_IS_NOT_LOADED);
	
	}
}


