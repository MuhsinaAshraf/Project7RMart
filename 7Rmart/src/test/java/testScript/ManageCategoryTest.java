package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;
 
import baseClass.Base;
import constance.Constants;
import constance.Messages;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test

	public void manageCategory() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		String categoryvalue=ExcelUtility.getStringData(1, 0,Constants.MANAGE_CATEGORY);
		
		 ManageCategoryPage managecategoryupdate=new  ManageCategoryPage(driver);
		 managecategoryupdate.clickOnMnageCtegoryField();
		 managecategoryupdate.clickOnUpdateIcon();
		 managecategoryupdate.enterCategoryField(categoryvalue);
		 managecategoryupdate.clickOnUpdateBtn();
		 
		 boolean is_header_list_categories_loaded=managecategoryupdate.isListCategoriesPageLoaded();
		 assertTrue(is_header_list_categories_loaded,Messages.HEADER_LIST_CATEGORIES_NOT_LOADED);
		 
		 
}
}
