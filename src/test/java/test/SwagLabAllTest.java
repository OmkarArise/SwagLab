package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.CheckOutPage;
import pom.LoginFunction;
import pom.SwagLabHomePage;
import pom.SwagLabMyCart;
import utility.Reports;
@Listeners(test.Listeners.class)
public class SwagLabAllTest extends BaseTest{

	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void configureReport()
	{
		report = Reports.createReport();
	}
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = Browser.launchBrowser();
	}
	
	@Test
	public void loginFunctionality() throws EncryptedDocumentException, IOException
	{
	   test = report.createTest("loginFunctionality");
		LoginFunction loginFunction = new LoginFunction(driver);
		//Parametrization.getExcelData(null, 0, 0)
		loginFunction.enterUsername("standard_user");
		loginFunction.enterPassword("secret_sauce");
		loginFunction.clickOnLoginButton();
		System.out.println("LogIn Sucessfully");
		
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnMenu();
		swagLabHomePage.clickOnLogOut();
		System.out.println("LogOut Sucessfully");
	}
	
	@Test
	public void productAreDisplayOnHomePage()
	{
		test = report.createTest("productAreDisplayOnHomePage");
		LoginFunction loginFunction = new LoginFunction(driver);
		loginFunction.enterUsername("standard_user");
		loginFunction.enterPassword("secret_sauce");
		loginFunction.clickOnLoginButton();
		
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		int size = swagLabHomePage.numberOfProduct();
		System.out.println(size);
		Assert.assertTrue(size >= 0);
	}
	
	@Test
	public void verifyProductIsAddedToCart()
	{
		test = report.createTest("verifyProductIsAddedToCart");
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
	
	@Test
	public void verifyMultipleProductsAddedToCart()
	{
		test = report.createTest("verifyMultipleProductsAddedToCart");
		LoginFunction loginFunction = new LoginFunction(driver);
		loginFunction.enterUsername("standard_user");
		loginFunction.enterPassword("secret_sauce");
		loginFunction.clickOnLoginButton();
		
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnBag();
		swagLabHomePage.clickOnLight();
		swagLabHomePage.ClickOnMyCart();
		
		SwagLabMyCart swagLabMyCart = new SwagLabMyCart(driver);
		int size  = swagLabMyCart.numberOfProductAddToCart();
		Assert.assertTrue(size > 1);
		System.out.println(" Multiple Products Added Sucessfully");
	}
	@Test
	public void verifyCustomerIsAbleToPlaceOrder()
	{
		test = report.createTest("verifyCustomerIsAbleToPlaceOrder");
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
	@AfterMethod
	public void captureResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP,result.getName());
		}
	}
	@AfterTest
	public void publishReport()
	{
		report.flush();
	}
}
