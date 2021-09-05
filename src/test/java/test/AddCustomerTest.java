package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactor;



public class AddCustomerTest {
	
	WebDriver driver;
	
//	@Test
	@Parameters({"username", "password", "fullName", "companyName", "email", "phone", "address", "city", "country", "state", "zip"})
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String country, String state, String zip) {
		driver = BrowserFactor.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clikSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardElement();
		dashboard.clickCustomerButton();
		dashboard.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.selectCompanyDropdown(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.selectCountryDropdown(country);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.clickSaveButton();
		
		dashboard.verifyProfilePage();
		dashboard.clickListCustomerButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
		
		BrowserFactor.tearDown();
	}
	
	@Test
	@Parameters({"username", "password", "fullName", "companyName", "email", "phone", "address", "city", "country", "state", "zip"})
	public void validUserShouldBeAbleToAddCustomerFromListcustomer(String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String country, String state, String zip) {
		driver = BrowserFactor.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clikSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardElement();
		dashboard.clickCustomerButton();
		dashboard.clickListCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCustomer();
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.selectCompanyDropdown(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.selectCountryDropdown(country);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.clickSaveButton();
		
		dashboard.verifyProfilePage();
		dashboard.clickListCustomerButton();
		
		addCustomerPage.validateSearchBoxAndProfileButton();
		
//		BrowserFactor.tearDown();
	}
	
	

}
