package stepDefinations;

import java.io.IOException;

import org.junit.Test;

import utilities.TestContextSetup;

public class LoginPageSteps {
	public TestContextSetup testContextSetup=new TestContextSetup();
	public LoginPageSteps() throws IOException
	{
		
	}
	@Test
	public void loginOrangeHrm()
	{
		testContextSetup.pageObjectManager.getlogin().openUrl("https://demowebshop.tricentis.com/login");;
		testContextSetup.pageObjectManager.getlogin().enterUserNameAndPassword("saiganesh123@gmail.com", "Saiganesh@123");
		testContextSetup.pageObjectManager.getlogin().clickOnLoginButton();
		
		
	}

}
