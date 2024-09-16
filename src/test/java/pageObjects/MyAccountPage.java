package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="(//*[text()='My Account'])[4]")
	WebElement displayMessage;
	
	@FindBy(xpath="(//*[text()='Logout'])[2]")
	WebElement btnLogout;
	
	public boolean displayLoginMyAccount()
	{
		if(displayMessage.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	
	public void clickOnLogout()
	{
		String javascript = "arguments[0].click()";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(javascript, btnLogout);
		//btnLogout.click();
	}

}
