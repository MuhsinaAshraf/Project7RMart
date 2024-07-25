 package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;

public class ManageContactUpdatePage {
	WebDriver driver;
	WebElementUtility webelementsutility=new WebElementUtility();
	public ManageContactUpdatePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[10]/div/a")private WebElement managecontact;
	@FindBy(xpath="//a[@role='button']")private WebElement actionfield;
	@FindBy(xpath="//input[@id='phone']")private WebElement phonefield;
	@FindBy(xpath="//input[@id='email']")private WebElement emailfield;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")private WebElement addressfield;
	@FindBy(xpath="//textarea[@placeholder='Enter Delivery Time']")private WebElement deliveryfield;
	@FindBy(xpath="//input[@id='del_limit']")private WebElement deliverylimitfield;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")private WebElement updatefield;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	public void manageContactField()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",managecontact);
	}
	public boolean isListPgeDisplayed()
	{
		boolean is_header_actionfield_available=webelementsutility.isElementDisplayed(actionfield);
		return is_header_actionfield_available;
		
		
	}
	public void clickingActionField()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",actionfield);
	}
	public void enterPhoneField(String phonevalue)
	{
		phonefield.sendKeys(phonevalue);
	}
	public void enterEmailField(String emailvalue)
	{
		emailfield.sendKeys(emailvalue);
	}
	public void enterAddressField(String addressvalue)
	{
		addressfield.sendKeys(addressvalue);
	}
	public void enterDeliveryField(String deliveryvalue)
	{
		deliveryfield.sendKeys(deliveryvalue);
	}
	public void entersDeliveryLimitField(String deliverylimitvalue)
	{
		deliverylimitfield.sendKeys(deliverylimitvalue);
	}
	public void clickingUpdate()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",updatefield);
	}
	
	public boolean alertMessageDisplayAfterSaving()
	{
		boolean isalertdisplay=webelementsutility.isElementDisplayed(alert);
		return isalertdisplay;
	 
	}
	

}