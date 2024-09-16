package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelUtility;

public class TC003_LoginDDT extends BaseClass {
	
	
	
	
	@Test(dataProvider="ExcelData" ,dataProviderClass = DataProviders.class)// getting data provider from different class
	public void verify_loginDDT(String email, String pwd ,String exp) throws InterruptedException
	{
		logger.info("***** stating TC_003_LoginDDT ******");
		System.out.println("***** stating TC_003_LoginDDT ******");
		

		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLink();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
			
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.displayLoginMyAccount();
		//macc.clickOnLogout();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{			
				macc.clickOnLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
				System.out.println("*******Even though credentails are valid , user successful login not happend**************");
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			Assert.assertFalse(false);
			System.out.println("*******Either password or user name is invalid**************");
		}
		
		Thread.sleep(3000);
		logger.info("***** Finished TC_003_LoginDDT ******");
		
	}
		
		
		
		
	}
