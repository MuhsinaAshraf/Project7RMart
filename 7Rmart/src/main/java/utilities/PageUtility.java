package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
	}

	public void actions(WebElement elementname,WebElement destination)
	{
		Actions actions=new Actions(driver);
		actions.contextClick(elementname);
		
	}
	

		
		
	}


