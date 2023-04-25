package test;

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
import pom.LoginFunction;
import pom.SwagLabHomePage;
import utility.Reports;
@Listeners(test.Listeners.class)
public class VerifyProductDisplayedOnHomepage extends BaseTest{
 
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
