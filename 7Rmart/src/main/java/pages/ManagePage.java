package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constance.Constants;
import utilities.FileUploadUtility;
import utilities.WaitUtility;
import utilities.WebElementUtility;

public class ManagePage {
	WebDriver driver;
	WebElementUtility webelementsutility=new WebElementUtility();
	WaitUtility waitutility=new WaitUtility();
	FileUploadUtility fileuploadutility=new FileUploadUtility();
	public ManagePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[1]/div/a")private WebElement moreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbtn;
	//@FindBy(xpath="//h1[text()='Add Pages']")private WebElement addpages;
	@FindBy(xpath="//input[@placeholder='Enter the Title']")private WebElement title;
	@FindBy(xpath="//div[@class='note-editable card-block']")private WebElement description;
	@FindBy(xpath="//input[@placeholder='Enter Page Name']")private WebElement page;
	@FindBy(xpath="//input[@name='main_img']")private WebElement imgbutton;
	@FindBy(xpath="//div[@id='imagePreview']")private WebElement imagepreview ;
	@FindBy(xpath="//button[@class='btn btn-danger']")private WebElement savebutton;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div/div/h5/i")private WebElement alert;

	public void moreinfonav()
	{
		moreinfo.click();
	}
	//public boolean isListPageDisplayed()
	//{
		//return newbtn.isDisplayed();
	//}
	public void clickOnNewButton()
	{
		newbtn.click();
	}
	//public boolean isAddPageWindowLoaded()
	//{
		//return addpages.isDisplayed();
	//}
	public void enterTitleField(String titlevalue)
	{
		title.sendKeys(titlevalue);
	}
	public void enterDescription(String descriptionvalue)
	{
		description.sendKeys(descriptionvalue);
	}
	public void enterPage(String pagenamevalue)
	{
		page.sendKeys(pagenamevalue);
	}
	public void clickOnAddImage() throws AWTException
	{
		fileuploadutility.fileUploadUsingSendKeys(imgbutton, Constants.TESTDATAFILEIMAGEMANAGEPAGEADD);	
		waitutility.waitForElement(driver, imagepreview);
		System.out.println("Image is Added");
	}
	public void clickingSave()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",savebutton);
		driver.navigate().back();

	}
	public boolean isAlertMessageDisplayed()
	{
		boolean is_alert_box_available=webelementsutility.isElementDisplayed(alert);
		return is_alert_box_available;

	}
	

}
