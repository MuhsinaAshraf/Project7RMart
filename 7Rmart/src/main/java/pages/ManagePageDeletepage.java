package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;

public class ManagePageDeletepage {
	WebDriver driver;
	WebElementUtility webelementsutility=new WebElementUtility();
	public ManagePageDeletepage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[1]/div/a")private WebElement moreinfo;
	@FindBy(xpath="//h1[text()='List Pages']")private WebElement listpagefield;
	@FindBy(xpath="/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr[1]/td[5]/a[2]")private WebElement deletefield;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
	public void moreinfo() {
		moreinfo.click();
	}
	public void listPage() {
		listpagefield.click();
	}

	public void deleteField() {
		deletefield.click();
		driver.switchTo().alert().accept();
	}
	public boolean isAlertMessageDisplayed()
	{
		boolean is_header_list_pages_available=webelementsutility.isElementDisplayed(alert);
		return is_header_list_pages_available;
	}
	
}
