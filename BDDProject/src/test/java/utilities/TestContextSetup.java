package utilities;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
//	public WebDriver driver;
	public TestBase testBase;
	public PageObjectManager pageObjectManager;
	public GenericUtilsFuctions genericUtilsFuctions;
	public TestContextSetup() throws IOException
	{
		testBase=new TestBase();
		pageObjectManager=new PageObjectManager(testBase.getWebDriverManager());
		genericUtilsFuctions=new GenericUtilsFuctions(testBase.getWebDriverManager());
	}

}
