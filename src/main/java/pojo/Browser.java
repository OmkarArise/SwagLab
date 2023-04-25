package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new  ChromeDriver(ops);
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		return driver;
	}
}
