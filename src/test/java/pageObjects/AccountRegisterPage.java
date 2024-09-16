package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage{
	
	public AccountRegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@name='firstname']")
	 WebElement txtFirstName;
	
	@FindBy(xpath="//*[@name='lastname']")
	 WebElement txtLastName;
	
	@FindBy(xpath="//*[@name='email']")
	 WebElement txtEmail;
	
	@FindBy(xpath="//*[@name='password']")
	 WebElement txtPassword;
	
	@FindBy(xpath="//*[@name='agree']")
	 WebElement btnPrivacyPolicy;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	 WebElement btnContinue;
	
	@FindBy(xpath="(//*[text()='Your Account Has Been Created!'])[3]")
	 WebElement msgConfirmationText;
	
	
	
	
	
	public void setFirstName(String fName)
	{
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName)
	{
		txtLastName.sendKeys(lName);
	}
	public void setEmail(String email)

	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickOnAgreePolicy() {
		btnPrivacyPolicy.click();
		
	}
	
	public void clickContinue() throws InterruptedException
	{
		btnContinue.click();
		Thread.sleep(2000);
	}
	
	public String getConfirmationMessage()
	{
		
		
	try {
		return msgConfirmationText.getText();
	}
	
	catch(Exception e){
		return(e.getMessage());
		
	}
	
	
		
	}
	
	
	
	

}
