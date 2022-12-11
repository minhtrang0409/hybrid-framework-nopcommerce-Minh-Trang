package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	public UserLoginPageObject(WebDriver driver,WebDriverWait explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String string) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, string);
	}

	public UserHomePageObject clickToLoginButton() {
	waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	//2 return  new HomePageObject(driver);
	return PageGeneratorManager.getUserHomePage(driver);
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailAddressTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}