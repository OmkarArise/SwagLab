package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabMyCart {

	@FindBy (xpath = "//button[@id='continue-shopping']") private WebElement  continueshopping;
	@FindBy (xpath = "//div[@class='cart_item']") private List<WebElement> cartProducts ;
	@FindBy (xpath = "//button[@name='checkout']") private WebElement checkoutbuttton ;
	//@FindBy (xpath = "") private WebElement  ;
	
	public SwagLabMyCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOncontinueShopping()
	{
		continueshopping.click();
	}
	public int numberOfProductAddToCart()
	{
		int size = cartProducts.size();
		return size;
	}
	public void clickOnCheckOutButton()
	{
		checkoutbuttton.click();
	}
	
}
