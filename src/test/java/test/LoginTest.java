package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactor;


public class LoginTest {
	
	WebDriver driver;
	
	
	String userName = null;
	String password = null;
	
	@Test
	@Parameters({"username", "password"})
	public void validUserShouldBeAbleToLogin(String userName, String password) {
		
		driver = BrowserFactor.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clikSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardElement();
		
		BrowserFactor.tearDown();
		
	}

}
