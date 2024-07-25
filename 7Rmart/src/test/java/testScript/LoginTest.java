package testScript;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import constance.Constants;
import constance.Messages;
import dataProvider.DataProviders;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(groups={"smoke","regression"})//if we use multiple group use curly braces
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0, Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1, Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean ishomepageavailable=loginpage.isHomePageLoaded();
		assertTrue(ishomepageavailable,"page is not loaded when user gives valid credentials ");

		
	}
	
	//using dataprovider-we can give multiple values for one test case to execute different case
	@Test(groups="regression",dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)
	public void verifyUserLoginWithInvalidCredentials(String username,String password) 
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		
		
		boolean actualresultlogin=loginpage.isHomePageLoaded();
		assertFalse(actualresultlogin,Messages.LOGIN_WITH_INVALID_CREDENTIALS);
	}

}