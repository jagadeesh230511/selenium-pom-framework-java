package pageObjects;

import org.openqa.selenium.WebDriver;
public class PageObjectManager {
	public WebDriver driver;
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public Login login;
	public Login getlogin()
	{
		login=new Login(driver);
		return login;
	}
	

}
