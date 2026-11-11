package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtilsFuctions {
	public WebDriver driver;
	//constructor
	public GenericUtilsFuctions(WebDriver driver)
	{
		this.driver=driver;
	}

	//navigate to different url in same tab
	public void navigateTo(String url)
	{
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			System.err.println("given url is not correct, please send valid url");
		}
	}
	//Window Handles
	//switch to 1st child window tab
	public void switchToCurrentTab()
	{
		try {
			Set<String> setOfWindows=driver.getWindowHandles();
			Iterator<String> windows=setOfWindows.iterator();
			while(windows.hasNext())
			{
				String parentWindow=windows.next();
				String childWindow=windows.next();
				driver.switchTo().window(childWindow);
			}

		} catch (Exception e) {
			System.err.println("Not able to switch to child window, please check multiple windows are opened or not");
		}
	}


	//switch to parent window
	public void switchToParentTab()
	{
		try {
			Set<String> setOfWindows=driver.getWindowHandles();
			Iterator<String> windows=setOfWindows.iterator();
			while(windows.hasNext())
			{
				String parentWindow=windows.next();
				String childWindow=windows.next();
				driver.switchTo().window(parentWindow);
			}
		} catch (Exception e) {
			System.err.println("Not able to switch to child window, please check multiple windows are opened or not");
		}
	}
	//Get parent window ID
	public void getParentWindowSessionID()
	{
		String parentWindow=null;
		try {
			parentWindow=driver.getWindowHandle();

		} catch (Exception e) {
			System.err.println("No parent window ID found");
		}
	}
	//switch to parent window by session ID 
	public void switchToParentTab(String parentWindowId)
	{
		try {
			if(parentWindowId!=null)
			{
				driver.switchTo().window(parentWindowId);
				driver.switchTo().defaultContent();
			}
			else
			{
				System.err.println("parent session id is null");
			}

		} catch (Exception e) {
			System.err.println("Not able to switch to parent window, please check multiple windows are opened or not");
		}
	}
	//	switch to windows by passing texts example: main, child1, child2
	public void secondChild(String text)
	{
		try {
			Set<String> setOfWindows=driver.getWindowHandles();
			List<String> windows=new ArrayList<String>(setOfWindows.size());
			if(text.equalsIgnoreCase("Main")) {
				driver.switchTo().window(windows.get(0));
				System.out.println("switched to main window");
			}
			else if(text.equalsIgnoreCase("child1")) {
				driver.switchTo().window(windows.get(1));
				System.out.println("switched to child1 window");
			}
			else if(text.equalsIgnoreCase("child2")) {
				driver.switchTo().window(windows.get(2));
				System.out.println("switched to child2 window");
			}
		} catch (Exception e) {
			System.err.println("Not able to switch to window, please check multiple windows are opened or not");
		}

	}
	// Drop downs 

	//select dropdown values from visible text
	public void selectByVisisbleText(By element, String text)
	{
		try {
			WebElement dropDownElements=driver.findElement(element);
			Select dropDown=new Select(dropDownElements);
			List<WebElement> options=dropDown.getOptions();
			for(WebElement option: options)
			{
				if(text.equals(option.getText()))
				{
					option.click();
				}
			}
		} catch (Exception e) {
			System.err.println("Not able to select the given text, please check passed values");
		}
	}

	public void selectByVisibleText(List<WebElement> elements, String text) { 

		for(int i = 0; i<elements.size(); i++) {
			if(text.contains(elements.get(i).getText())) {
				elements.get(i).click();
				break;
			}

		}
	}

	//select by index
	public void selectByIndex (By variable, int index) { 
		try {

			Select dropdown = new Select(driver.findElement(variable));
			dropdown.selectByIndex (index);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//select dropdown values in single method
	public void selectDropDownValue (By locator, String type, String value) { 

		try {

			Select dropdown = new Select(driver.findElement(locator));

			switch (type) {

			case "index":

				dropdown.selectByIndex(Integer.parseInt(value));

				break;

			case "value":

				dropdown.selectByValue (value);

				break;

			case "visibleText":

				dropdown.selectByVisibleText(value);

				break;

			default:

				System.err.println("please pass the correct selection criteria");
				break;

			}
		}
		catch (Exception exception) {
			System.err.println("Not able to select given value from dropdown, please check passed value" );
		}
	}
	
	
	// Wait commands
	
	public void waitUntilpageToLoad() {

		try {

			JavascriptExecutor j = (JavascriptExecutor) driver;

			if (j.executeScript( "return document.readyState").toString().equals("complete")) {

				System.out.println("Page has loaded");
			}

		}catch (Exception exception) {

			System.err.println("Page is not loaded completely");
		}

		try {

			JavascriptExecutor j = (JavascriptExecutor)driver;

			if (j.executeScript( "return document.readyState").toString().equals("complete")) {

				System.out.println("Page has loaded");
			}

		}catch (Exception exception) {

			System.err.println("Page is not loaded completely");
		}

	}
	
	// wait using thread.sleep
	public void wait(int millisecs)
	{
		try {
			Thread.sleep(millisecs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 //to retrieve the page title
	public String getPageTitle()
	{
		String title=null;
		try {
			title=driver.getTitle();
			System.out.println("page title:"+title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return title;
	}
	
	// click on element
	


	public void click (WebElement element)
	{
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));

			wait.until(ExpectedConditions.elementToBeClickable(element));

			element.click();

			System.out.println("Successfully clicked");

		}catch (Exception exception) {
			System.err.println("Not able to click on element which sent");
		}
	}


	// click on enter key in keyboard
		public void pressEnter (WebElement element)
		{
			try{
				element.sendKeys((Keys.RETURN));

				System.out.println("Successfully press Enter key");
			}

			catch(Exception e)
			{
				System.err.println("Not able to press Enter Key");

			}

		}
		
		
		//wait and click until web element is visible
		public void clickBy (By element) { 

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));

				driver.findElement(element).click();

				System.out.println("Successfully clicked");

			}catch (Exception exception) {

				exception.printStackTrace();

				System.err.println("Not able to click on element which sent");

			}
		}
		
		//to enter text
		public void sendKeys(By element,String text)
		{
			try {
				driver.findElement(element).sendKeys(text);
				System.out.println("successfully entered");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// clear text from input tag
		public void clear(By element)
		{
			driver.findElement(element).clear();
		}
		
		





}


