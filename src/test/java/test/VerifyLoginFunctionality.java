package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginFunction;
import pom.SwagLabHomePage;

public class VerifyLoginFunctionality extends BaseTest {

	@BeforeMethod
	public void openBrowser()
	{
		driver = Browser.launchBrowser();
	}
	
	@Test
	public void loginFunctionality() throws EncryptedDocumentException, IOException
	{
		LoginFunction loginFunction = new LoginFunction(driver);
		//Parametrization.getExcelData(null, 0, 0)
		loginFunction.enterUsername("standard_user");
		loginFunction.enterPassword("secret_sauce");
		loginFunction.clickOnLoginButton();
		
		System.out.println("LogIn Sucessfully");
		
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnMenu();
    	swagLabHomePage.clickOnLogOut();
//		int size = swagLabHomePage.numberOfProduct();
//		System.out.println(size);
		
		System.out.println("LogOut Sucessfully");
	}
}
