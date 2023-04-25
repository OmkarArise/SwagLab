package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage {

	@FindBy (xpath = "//button[@id='react-burger-menu-btn']") private WebElement  menu;
	@FindBy (xpath = "//a[@id='logout_sidebar_link']") private WebElement  logOut ;
	@FindBy (xpath = "//div[@class='inventory_item']") private List<WebElement> products ;
	@FindBy (xpath = "//a[@class='shopping_cart_link']") private WebElement mycartbutton ;
	@FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement bagAddtoCart ;
	@FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement lightAddtoCart ;
	//@FindBy (xpath = "") private WebElement  ;
	//@FindBy (xpath = "") private WebElement  ;
	
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnMenu()
	{
		menu.click();
	}
	public void clickOnLogOut()
	{
		logOut.click();
	}
	public int numberOfProduct()
	{
		int size = products.size();
		return size;
	}
	public void ClickOnMyCart()
	{
		mycartbutton.click();
	}
	public void clickOnBag()
	{
		bagAddtoCart.click();
	}
	public void clickOnLight()
	{
		lightAddtoCart.click();
	}
}

