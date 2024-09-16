package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath="(//*[text()='Login'])[3]")
	WebElement btnLogin;
	
	


	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		
		String javascript = "arguments[0].click()";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(javascript, btnLogin);
		//btnLogin.click();
	}

	
	
	
}