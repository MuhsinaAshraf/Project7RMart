package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;


public class ManagePageSearchDeletePage {
	WebDriver driver;
	WebElementUtility webelementsutility=new WebElementUtility();
	public ManagePageSearchDeletePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[1]/div/a")private WebElement managepages;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement searchbutton1 ;
	@FindBy(xpath="//input[@class='form-control']")private WebElement title;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")private WebElement searchbutton2;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")private WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
	
	public void clickingManagePage()
	{
		managepages.click();
	}
	public boolean isManagePageLoaded()
	{
		boolean ismanagepageavailable=webelementsutility.isElementDisplayed(searchbutton1);
		return ismanagepageavailable;
	}
	public void enterTitleValue(String titleValue)
	{
		searchbutton1.click();
		title.sendKeys(titleValue);
		searchbutton2.click();
	}
	public void deleteTitle()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",deletebutton);
		driver.switchTo().alert().accept();
	}
	
	public boolean isAlertMessageDisplayed()
	{
		boolean isalertdisplay=webelementsutility.isElementDisplayed(alert);
		return isalertdisplay;
	    
	}
	
	
	

}