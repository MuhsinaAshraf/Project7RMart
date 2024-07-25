package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
	// Method to check if a WebElement is displayed and assert
    public boolean isElementDisplayed(WebElement element) {
    	
    	boolean isdisplayed=element.isDisplayed();
		return isdisplayed;
     
    }

    // Method to check if a WebElement is selected and assert
    public boolean isElementSelected(WebElement element) {
    	boolean isselected=element.isSelected();
    	return isselected;
       
    }

    // Method to check if a WebElement is enabled and assert
    public boolean isElementEnabled(WebElement element) {
    	boolean isenabled=element.isEnabled();
      return isenabled;
    }
}