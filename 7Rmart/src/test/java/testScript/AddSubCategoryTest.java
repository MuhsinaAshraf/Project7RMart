package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import constance.Constants;
import constance.Messages;
import pages.AddSubCategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class AddSubCategoryTest extends Base{
	@Test
	
	public void verifyAbleToAddSubCategory() throws IOException
	{
	
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		//String categorydrodownvalue="Vegetables";
		String subcategorytextvalue=ExcelUtility.getStringData(1, 0,Constants.SUB_CATEGORY);
		
		AddSubCategoryPage addsubcategory=new AddSubCategoryPage(driver);
		addsubcategory.clickOnManageSubcategoryPage();
		addsubcategory.clickOnNewButton();
		addsubcategory.clickOnCategoryField(subcategorytextvalue);
		//addsubcategory.clickOnCategoryField(subcategoryvalue);
		addsubcategory.clickingSave();
		
		
		//boolean islistsubcategorypageavailable=addsubcategory.headerListSubcategoryField();
        //assertTrue(islistsubcategorypageavailable,"page is not loaded ");
		
		boolean isalertboxloaded=addsubcategory.isAlertMessageDisplayed();
		assertTrue(isalertboxloaded,Messages.ALERT_WINDOW_NOT_LOADED);
		
		
		
	}

	
		

		
		
}

