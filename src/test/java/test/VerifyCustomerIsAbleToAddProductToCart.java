package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginFunction;
import pom.SwagLabHomePage;
import pom.SwagLabMyCart;

public class VerifyCustomerIsAbleToAddProductToCart extends BaseTest {


	@BeforeMethod
	public void openBrowser()
	{
		driver = Browser.launchBrowser();
	}
	
	@Test
	public void verifyProductIsAddedToCart()
	{
		LoginFunction loginFunction = new LoginFunction(driver);
		loginFunction.enterUsername("standard_user");
		loginFunction.enterPassword("secret_sauce");
		loginFunction.clickOnLoginButton();
		
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnBag();
		swagLabHomePage.ClickOnMyCart();
		
		SwagLabMyCart swagLabMyCart = new SwagLabMyCart(driver);
		int size  = swagLabMyCart.numberOfProductAddToCart();
		Assert.assertTrue(size == 1);
		System.out.println("Product Added Sucessfully");
		
	}
}
