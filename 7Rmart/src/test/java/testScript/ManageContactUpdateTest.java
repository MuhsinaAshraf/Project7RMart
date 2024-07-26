package testScript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constance.Constants;
import constance.Messages;
import pages.LoginPage;
import pages.ManageContactUpdatePage;
import utilities.ExcelUtility;

public class ManageContactUpdateTest extends Base{
	@Test
	public void manageContactUpdate() throws IOException  {
		
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageContactUpdatePage managecontactuspage=new ManageContactUpdatePage(driver);
		managecontactuspage.manageContactField();
		//boolean islistpagedisplayed=managecontactuspage.isListPgeDisplayed();
		//assertTrue(islistpagedisplayed,"Page is not loaded");
		
		String phonevalue=ExcelUtility.getStringData(1, 0, Constants.MANAGE_CONTACTS_UPDATE);
		String emailvalue=ExcelUtility.getStringData(1, 1, Constants.MANAGE_CONTACTS_UPDATE);
		String addressvalue=ExcelUtility.getStringData(1, 2, Constants.MANAGE_CONTACTS_UPDATE);
		String deliveryvalue=ExcelUtility.getStringData(1, 3, Constants.MANAGE_CONTACTS_UPDATE);
		String deliverylimitvalue=ExcelUtility.getStringData(1, 4, Constants.MANAGE_CONTACTS_UPDATE);
		managecontactuspage.clickingActionField();
		
		managecontactuspage.enterPhoneField(phonevalue);
		
		managecontactuspage.enterEmailField(emailvalue);
		
		managecontactuspage.enterAddressField(addressvalue);
		
		managecontactuspage.enterDeliveryField(deliveryvalue);
		
		managecontactuspage.entersDeliveryLimitField(deliverylimitvalue);
		managecontactuspage.clickingUpdate();
		boolean is_header_actionfield_available=managecontactuspage.isListPgeDisplayed();
		Assert.assertTrue(is_header_actionfield_available,Messages.HEADER_CONTACTUS_IS_NOT_LOADED);
		boolean isalertmessagedisplayaftersaving=managecontactuspage.alertMessageDisplayAfterSaving();
        Assert.assertTrue(isalertmessagedisplayaftersaving,Messages.ALERT_PAGE_IS_NOT_LOADED);
		
	}
	

}
