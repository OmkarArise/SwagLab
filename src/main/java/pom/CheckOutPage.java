package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {

	@FindBy (xpath = "//input[@id='first-name']") private WebElement firstName ;
	@FindBy (xpath = "//input[@id='last-name']") private WebElement  lastName;
	@FindBy (xpath = "//input[@id='postal-code']") private WebElement postNumber ;
	@FindBy (xpath = "//input[@id='continue']") private WebElement continueButton ;
	@FindBy (xpath = "//button[@id='finish']") private WebElement finishButton ;
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterFirstname(String name)
	{
		firstName.sendKeys(name);
	}
	public void waitForCheckOutPage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(finishButton));
	}
	public void enterLasttname(String name)
	{
		lastName.sendKeys(name);
	}
	public void enterPostcode(String name)
	{
		postNumber.sendKeys(name);
	}
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	public void clickOnFinishButton()
	{
		finishButton.click();
	}
}
