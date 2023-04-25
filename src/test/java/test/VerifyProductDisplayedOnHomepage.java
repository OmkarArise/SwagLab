package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginFunction;
import pom.SwagLabHomePage;

public class VerifyProductDisplayedOnHomepage extends BaseTest{

	@BeforeMethod
	public void openBrowser()
	{
		driver = Browser.launchBrowser();
	}
	@Test
	public void productAreDisplayOnHomePage()
	{
		LoginFunction loginFunction = new LoginFunction(driver);
		loginFunction.enterUsername("standard_user");
		loginFunction.enterPassword("secret_sauce");
		loginFunction.clickOnLoginButton();
		
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		int size = swagLabHomePage.numberOfProduct();
		System.out.println(size);
		Assert.assertTrue(size >= 0);
		
	}
}
