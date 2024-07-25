package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WebElementUtility;

public class AddSubCategoryPage {
	WebDriver driver;
	WebElementUtility webelementsutility=new WebElementUtility();
	public AddSubCategoryPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[7]/div/a")private WebElement managesubcategorypage;
	
	//@FindBy(xpath="//h1[text()='List Sub Categories']")private WebElement headerlistsubcategory;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newbutton;
	
	@FindBy(xpath="//select[@class='form-control selectpicker']")private WebElement categoryfielddropdown;
	@FindBy(xpath="//input[@name='subcategory']")private WebElement subcategoryfield;
	@FindBy(xpath="//button[@name='create']")private WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alertbutton;
	public void clickOnManageSubcategoryPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",managesubcategorypage);
	}
	//public boolean headerListSubcategoryField()
	//{
	 //return headerlistsubcategory.isDisplayed();
	//}
	
	public void clickOnNewButton()
	{
		newbutton.click();
	}
	
	public void clickOnCategoryField(String subcategorytextvalue) 
	{
		Select select = new Select(categoryfielddropdown);
		select.selectByVisibleText("Vegetables");
		subcategoryfield.sendKeys(subcategorytextvalue);
	}
	public void clickingSave()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",savebutton);
		driver.navigate().back();
	}
	public boolean isAlertMessageDisplayed()
	{
		boolean isalertboxavailable=webelementsutility.isElementDisplayed(alertbutton);
		return isalertboxavailable;
		
	}
	
	

}