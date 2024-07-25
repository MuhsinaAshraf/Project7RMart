package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class SearchAdminUserPage {
	WebDriver driver;
	PageUtility pageutility=new  PageUtility();
	 
	public SearchAdminUserPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[2]/div/a")private WebElement adminusers;
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement searchfield;
	@FindBy(xpath="//input[@id='un']")private WebElement usernamefield ;
	@FindBy(xpath="//select[@id='ut']")private WebElement usertypedropdown;
	@FindBy(xpath="//button[@name='Search']")private WebElement searchbutton;
	@FindBy(xpath="//button[@name='Search']")private WebElement tabledisplay;
	
	public void clickingAdminUsers()
	{
		adminusers.click();
	}
	public void clickingSearchField()
	{
		searchfield.click();
	}
	public void enteringUsername(String name)
	{
		usernamefield.sendKeys(name);
	}
	public void selectingUserTypeField(String nametype)
	{
		//usernamefield.sendKeys(nametype);
		//Select select=new Select(usertypedropdown);
		//select.selectByVisibleText("Staff");
		
		pageutility.selectByValue(usertypedropdown, nametype);

	}
	public void clickOnSearchButton() 
	{
		searchbutton.click();
	}
	public boolean tableDisplayed()
	{
	 return tabledisplay.isDisplayed();
	}

}
