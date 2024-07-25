package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;
import utilities.WebElementUtility;

public class ManageCategoryPage {
	WebDriver driver;
	PageUtility pageutility=new  PageUtility();
	WebElementUtility webelementsutility=new WebElementUtility();
	FileUploadUtility fileuploadutility=new FileUploadUtility();
	WaitUtility waitutility=new WaitUtility();
	public ManageCategoryPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[6]/div/a")private WebElement managecategory;
	@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement headerlistcategories;
	@FindBy(xpath="//i[@class='fas fa-edit']")private WebElement updateicon;
	//@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement headereditcategories;
	@FindBy(xpath="//input[@placeholder='Enter the Category']")private WebElement category ;
	@FindBy(xpath="//li[@id='134-selection']")private WebElement selectgroupitem ;
	@FindBy(xpath="//input[@type='file']")private WebElement choosefilebutton ;
	@FindBy(xpath="//div[@id='imagePreview']")private WebElement imagepreview ;
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[1]/label[2]")private WebElement topradiobuttonyes ;
	@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[1]/label[3]")private WebElement topradiobuttonno ;
	@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[2]/label[2]")private WebElement leftradiobuttonyes ;
	@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[2]/label[3]")private WebElement leftradiobuttonno ;
	
	@FindBy(xpath="//button[@type='submit']")private WebElement updatebutton ;
	//@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
	
	public void clickOnMnageCtegoryField()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",managecategory);
		
	}
	public boolean isListCategoriesPageLoaded()
	{
		boolean isheaderlistcategoriesavailable=webelementsutility.isElementDisplayed(headerlistcategories);
		return isheaderlistcategoriesavailable;
	
	}
	
	public void clickOnUpdateIcon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",updateicon);
		
	}
	public void enterCategoryField(String categoryvalue)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions=new Actions(driver);
		category.sendKeys(categoryvalue);
		System.out.println("category set");
		
		actions.contextClick(selectgroupitem);
		System.out.println("select groups item perform successfully");
		
		fileuploadutility.fileUploadUsingSendKeys(choosefilebutton, "TESTDATAFILEIMAGEMANAGEPAGESADDING");
		waitutility.waitForElement(driver, imagepreview);
		System.out.println("Image is Added");
		
		if(topradiobuttonyes.isSelected()) {
			System.out.println("top menu yes is already selected");
			js.executeScript("arguments[0].click();",topradiobuttonno);
		}
		else
		{
			js.executeScript("arguments[0].click();",topradiobuttonyes);
		}
		if(leftradiobuttonyes.isSelected()) 
		{
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();",leftradiobuttonno);
			
		}
		else
		{
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();",leftradiobuttonyes);
			
		}
		
	}
	public void clickOnUpdateBtn()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();",updatebutton);
		
		driver.navigate().back();
	}
	//public boolean isAlertMessageDisplayed()
	//{
	//return alert.isDisplayed();
	//}
	
}