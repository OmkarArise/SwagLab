package test;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CheckOutPage;
import pom.LoginFunction;
import pom.SwagLabHomePage;
import pom.SwagLabMyCart;

public class VerifyCustomerIsAbletoPlaceOrder extends BaseTest{


	@BeforeMethod
	public void openBrowser()
	{
		driver = Browser.launchBrowser();
	}
	
	@Test
	public void verifyCustomerIsAbleToPlaceOrder()
	{
		LoginFunction loginFunction = new LoginFunction(driver);
		loginFunction.enterUsername("standard_user");
		loginFunction.enterPassword("secret_sauce");
		loginFunction.clickOnLoginButton();
		
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnBag();
		swagLabHomePage.ClickOnMyCart();
		
		SwagLabMyCart swagLabMyCart = new SwagLabMyCart(driver);
		swagLabMyCart.clickOnCheckOutButton();
		
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		checkOutPage.enterFirstname("omk");
		checkOutPage.enterLasttname("omk");
		checkOutPage.enterPostcode("000000");
		checkOutPage.clickOnContinueButton();
		checkOutPage.clickOnFinishButton();
		
		System.out.println("Order Placed Sucessfully");
		
		
	}
}
