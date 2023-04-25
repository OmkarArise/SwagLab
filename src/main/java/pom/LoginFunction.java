package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFunction {

	@FindBy (xpath = "//input[@id='user-name']") private WebElement username ;
	@FindBy (xpath = "//input[@id='password']") private WebElement password ;
	@FindBy (xpath = "//input[@id='login-button']") private WebElement loginButton ;
	
	public LoginFunction(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterUsername(String usname)
	{
		username.sendKeys(usname);
	}
	public void waitForLoginFunction(WebDriver driver)
	{
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(loginButton));
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
}
