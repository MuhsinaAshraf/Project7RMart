package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;

public class ManageNewsAddPage {
	WebDriver driver;
	WebElementUtility webelementsutility=new WebElementUtility();
	public ManageNewsAddPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//i[@class='nav-icon fas fa-edit']")WebElement managecontent;
	@FindBy(xpath="//p[text()='Manage News']")WebElement managenews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newfield;
	@FindBy(xpath="//textarea[@id='news']")WebElement enternews;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public void clickingManageContent()
	{
		managecontent.click();
	}
	public void clickingManageNews()
	{
		managenews.click();
	}
	public void clickingNewField()
	{
		newfield.click();
	}
	public void enteringNews(String newss) {
		enternews.sendKeys(newss);
		// TODO Auto-generated method stub
		
	}
	
	//public void enteringNews1(String news)
	//{
		//enternews.sendKeys( news);
	//}
	public void clickingSave()
	{
		save.click();
	}
	
	public boolean alertMessageDisplayAfterSaving()
	{
	boolean alertMessageDisplayAfterSaving=webelementsutility.isElementDisplayed(alert);	
	 return alertMessageDisplayAfterSaving;
	}

}
