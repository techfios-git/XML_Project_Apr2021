package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id=\"cid\"]") WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id=\"country\"]") WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]") WebElement SAVE_BUTTON_ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_IN_LIST_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_BAR_IN_LIST_CUSTOMER_ELEMENT;
	
	String enteredName;
	
	public void enterFullName(String fullName) {
		enteredName = fullName + randomGenerator(999);
		FULL_NAME_ELEMENT.sendKeys(enteredName);
	}
	
	public void selectCompanyDropdown(String company) {
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT, company);
	}
	
	public void enterEmail(String email) {
		int randomNum = randomGenerator(9999);
		EMAIL_ELEMENT.sendKeys(randomNum + email);
	}
	
	public void enterPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + randomGenerator(99));
	}
	
	public void enterAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void enterCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	
	public void enterState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	
	public void enterZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}
	
	public void selectCountryDropdown(String country) {
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT, country);
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ADD_CUSTOMER_ELEMENT.click();
	}
	
	//tbody/tr[i]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[7]/a[2]
	//tbody/tr[2]/td[7]/a[1] --> profile
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_xpath_delete = "]/td[7]/a[2]";
	String after_xpath_profile = "]/td[7]/a[1]";
	
	public void verifyEnteredNameAndDelete() {
		
		for(int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			//System.out.println(name);
//			Assert.assertEquals(name, enteredName, "Entered name doesn't exist!!");
			if(name.contains(enteredName)) {
				System.out.println("Entered name exist");
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
			
			break;
		}
	}
	
	public void clickAddCustomerOnListCustomer() {
		ADD_CUSTOMER_IN_LIST_CUSTOMER_ELEMENT.click();
	}
	
	public void validateSearchBoxAndProfileButton() {
		SEARCH_BAR_IN_LIST_CUSTOMER_ELEMENT.sendKeys(enteredName);
		for(int i = 1; i <= 9; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if (name.contains(enteredName)) {
				System.out.println("Entered name exist!!");
				driver.findElement(By.xpath(before_xpath + i + after_xpath_profile)).click();
			}
		}
	}

}
