package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="(//*[text()='My Account'])[1]")
	 WebElement myAccountLink;
	
	@FindBy(xpath="(//*[text()='Register'])[1]")
	 WebElement registertLink;
	
	@FindBy(xpath="(//*[text()='Login'])[1]")
	 WebElement linkLogin;
	
	public void clickMyAccount()
	{
		myAccountLink.click();
	}
	
	public void clickRegisterLink()
	{
		registertLink.click();
	}
	
	public void clickLoginLink()
	{
		linkLogin.click();
	}

}
