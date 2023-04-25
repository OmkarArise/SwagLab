package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
