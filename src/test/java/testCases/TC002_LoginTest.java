package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	
	@Test(groups= {"sanity","regression"})
	public void testLoginFunctionality() throws InterruptedException
	{
		logger.info("****Login test Started ***********");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLink();
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(prop.getProperty("userName"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLogin();
		Thread.sleep(5000);
		MyAccountPage ap=new MyAccountPage(driver);
		boolean targetPage = ap.displayLoginMyAccount();
		
		Assert.assertEquals(targetPage, true ,"Login Test failed");
		
		logger.info("****Login test Ended***********");
		
		ap.clickOnLogout();
	
	}

}
