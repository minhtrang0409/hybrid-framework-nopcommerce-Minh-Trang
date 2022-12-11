package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AminLoginPageUI;
import pageUIs.nopCommerce.user.LoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	public AdminLoginPageObject(WebDriver driver,WebDriverWait explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToUsernameTextbox(String emailAddress) {
		waitForElementVisible(driver, AminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String string) {
		waitForElementVisible(driver, AminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AminLoginPageUI.PASSWORD_TEXTBOX, string);
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver,AminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToUsernameTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}