package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")private WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement Password ;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="//li[@class='breadcrumb-item active']")private WebElement dashboardvalue;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	
	public void enterUserNameOnUserNameField(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
	}
	public void enterPasswordOnPasswordField(String passwordvalue) 
	{
		Password.sendKeys(passwordvalue);
	}
	public void clickOnSignInButton()
	{
		signin.click();
	}
	public boolean isHomePageLoaded()
	{
		return dashboardvalue.isDisplayed();
		
	}
	public boolean isAlertBoxLoaded()
	{
		return alert.isDisplayed();	
	}
	


	

}
