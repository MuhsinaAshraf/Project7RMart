package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;

public class AdminUserStatusPage {
	WebDriver driver;
	WebElementUtility webelementsutility=new WebElementUtility();
	public AdminUserStatusPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement adminuserpage;
	@FindBy(xpath="//h1[text()='Admin Users']")private WebElement adminheaderpage ;
	
	@FindBy(xpath="/html/body/div/div[1]/section/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[3]/a/span")private WebElement userstatus;
	@FindBy(xpath="/html/body/div/div[1]/section/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[5]/a[1]")private WebElement statusicon;
	//@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert ;
	
	
	public void clickOnAdminUserPage()
	{
		adminuserpage.click();
	}
	public boolean isAdminHeaderPageLoaded()
	{
		boolean isadminheaderavailable=webelementsutility.isElementDisplayed(adminheaderpage);
		return isadminheaderavailable;
	}
	public void CurrentUserStatus()
	{
		String statusText=userstatus.getText();
		System.out.println("user current status:"+statusText);
		
	}
	public boolean isStatusIconVisible()
	{
		boolean isstatusiconavailable=webelementsutility.isElementDisplayed(statusicon);
		return isstatusiconavailable;
	}

	public void clickOnStatusIcon()
	{
		statusicon.click();
	}
	
	//public boolean isAlertMessageDisplayed()
	//{
	  //  return alert.isDisplayed();
	//}
	

}
