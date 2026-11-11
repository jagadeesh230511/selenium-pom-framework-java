package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	
	public WebDriver getWebDriverManager() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;
	}

}
