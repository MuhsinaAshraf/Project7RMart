package testScript;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constance.Constants;
import constance.Messages;
import pages.AddAdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;


public class AddAdminUserTest extends Base{
	@Test
	 public void verifyTheUserIsAbleToAddUserInAdminUser()  throws IOException {
		// String usernamevalue="admin";
		 //String passwordvalue="admin";
		 String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
	     String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		 LoginPage loginpage=new LoginPage(driver);
		 loginpage.enterUserNameOnUserNameField(usernamevalue);
		 loginpage.enterPasswordOnPasswordField(passwordvalue);
		 loginpage.clickOnSignInButton();
		 
		 
		  
		  AddAdminUserPage adminuserspage= new AddAdminUserPage(driver);
		  adminuserspage.clickingAdminUsers();
		  adminuserspage.clickingNewField();
		  String firstname=RandomDataUtility.getFirstName();
			String lastname=RandomDataUtility.getLastName();
			String username1=firstname;
			String password1=firstname+"."+lastname;
			
			String usertype=ExcelUtility.getStringData(1, 2,Constants.ADD_ADMIN_USER);
			
		  adminuserspage.enterAdminUserInformations(username1, password1, usertype);
		  adminuserspage.clickingSave();
		  adminuserspage.alertMessageDisplayAfterSaving();
		  boolean isMessageDisplayedAfterCreatingadminuserspage=adminuserspage.alertMessageDisplayAfterSaving();
		  Assert.assertTrue(isMessageDisplayedAfterCreatingadminuserspage,Messages.HEADER_ADMIN_USER_NOT_LOADED);
	  }

}
