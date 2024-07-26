package testScript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constance.Constants;
import constance.Messages;
import pages.LoginPage;
import pages.ManageNewsAddPage;
import utilities.ExcelUtility;

public class ManageNewsAddTest extends Base{
	@Test
	public void manageNews() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		 
		String newss=ExcelUtility.getStringData(1, 0,Constants.NEWS);
		ManageNewsAddPage manageaddnewspage= new ManageNewsAddPage(driver);
		manageaddnewspage.clickingManageContent();
		manageaddnewspage.clickingManageNews();
		manageaddnewspage.clickingNewField();
		 
		manageaddnewspage.enteringNews(newss);
		manageaddnewspage.clickingSave();
		manageaddnewspage.alertMessageDisplayAfterSaving();
		boolean is_alert_Displayed_After_Saving=manageaddnewspage. alertMessageDisplayAfterSaving();
		Assert.assertTrue(is_alert_Displayed_After_Saving,Messages.ALERT_MESSAGE_NOT_DISPLAYED);
		  
	  }

}
