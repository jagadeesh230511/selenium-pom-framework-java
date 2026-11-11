package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GenericUtilsFuctions;

public class Login {
	public WebDriver driver;
	public GenericUtilsFuctions genericUtilsFuctions;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		genericUtilsFuctions=new GenericUtilsFuctions(driver);
	}
	
	private final By username=By.xpath("//input[@id='Email']");
	public WebElement getUserName()
	{
		return driver.findElement(username);
	}
	
	private final By password=By.xpath("//input[@id='Password']");
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	private final By loginButton=By.xpath("//input[@class='button-1 login-button']");
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
	
	public void openUrl(String URL)
	{
		driver.get(URL);
	}
	
	public void enterUserNameAndPassword(String userName,String password)
	{
		getUserName().sendKeys(userName);
		getPassword().sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		getLoginButton().click();
	}
	

}
