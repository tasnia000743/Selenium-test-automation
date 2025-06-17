package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****** Starting TC_002_LoginTest *****");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
	
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		if(targetPage==true) {
		logger.info("Test passed!");
		Assert.assertTrue(true); }
		else {
			logger.error("Test failed");
			Assert.assertTrue(false);
		}}
		catch(Exception e)
		{   logger.error("Test failed!");
			Assert.fail();
		}
		
		logger.info("****** Finished TC_002_LoginTest *****");
		
	}
	
}
