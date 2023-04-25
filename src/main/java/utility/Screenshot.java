package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void takeScreenshot(WebDriver driver , String name) throws IOException {
	String dateTime = DateAndTime.getDateAndTime();
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination = new File("D:\\program\\Eclipse JAVA\\SwagLab\\Screenshot\\"+name+dateTime+".png");
	FileHandler.copy(source, destination);
	}
}
