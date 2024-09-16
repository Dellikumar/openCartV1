package testCases;



import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegisterPage;
import pageObjects.BasePage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"smoke","regression"})
	public void verifyRegistrationTest() throws InterruptedException
	{
		
		logger.info("*******Starting Account registration Test **************");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("**click on My account link**");
		hp.clickRegisterLink();
		logger.info("**click on register link**");
		AccountRegisterPage arp =new AccountRegisterPage(driver);
		arp.setFirstName(getRandomString().toUpperCase());
		logger.info("**Enter first name**");
		arp.setLastName(getRandomEmailid().toUpperCase());
		logger.info("**Enter Last name**");
		arp.setEmail(getRandomEmailid());
		logger.info("**Enter Email id**");
		arp.setPassword(getRandomString());
		logger.info("**Enter Password**");
		//Scroll down till last of webpage
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		arp.clickOnAgreePolicy();
		logger.info("**click on slide bar**");
		Thread.sleep(5000);
		arp.clickContinue();
		logger.info("**click on submit**");
		
		String xyz = arp.getConfirmationMessage();
		System.out.println(xyz);
		System.out.println("***********confirmation message check validation******");
		
		if(xyz.equalsIgnoreCase("Your Account Has Been Created!"))
		{
			logger.info("**Account successflly created**");
		    System.out.println("Account already created!!!!!!");
			//Assert.assertTrue(true);
			
		}
		else
		{
			logger.error("****Account creation is failed");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(arp.getConfirmationMessage(), "Your Account Has Been Created!");
		
		
		logger.info("*******Ending Account registration Test **************");
		
		
		
	}
	
	
	
	
	
}
