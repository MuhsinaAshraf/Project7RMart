package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WebElementUtility;

public class AddAdminUserPage {
	WebDriver driver;
	WebElementUtility webelementsutility=new WebElementUtility();
	PageUtility pageutility=new PageUtility();
	public AddAdminUserPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
		@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[2]/div/a")private WebElement adminusers;
		@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newfield;
		@FindBy(xpath="//input[@name='username']")private WebElement usernamefield;
		@FindBy(xpath="//input[@name='password']")private WebElement passwordfield;
		@FindBy(xpath="//select[@id='user_type']")private WebElement dropdownforusertype ;
		@FindBy(xpath="//select[@id='user_type']")private WebElement usertypefield;
		@FindBy(xpath="//button[@name='Create']")private WebElement save;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
		public void clickingAdminUsers()
		{
			adminusers.click();
		}
		public void clickingNewField()
		{
			newfield.click();
		}
		public void enterAdminUserInformations(String username1,String password1,String usertype)
		{
			
			usernamefield.sendKeys(username1);
			passwordfield.sendKeys(password1);
			pageutility.selectByValue(dropdownforusertype, usertype);
			
		}
		
		public void clickingSave()
		{
			save.click();
		}
		
		public boolean alertMessageDisplayAfterSaving()
		{
			boolean is_alert_box_available=webelementsutility.isElementDisplayed(alert);
			return is_alert_box_available;
		}
		 
	}
