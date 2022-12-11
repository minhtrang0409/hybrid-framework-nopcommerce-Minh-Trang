package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;
//	private WebDriverWait explicitWait;
//	
//	public AddressPageObject(WebDriver driver,WebDriverWait explicitWait) {
//		this.driver = driver;
//		this.explicitWait = explicitWait;
//	}
//	
	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
