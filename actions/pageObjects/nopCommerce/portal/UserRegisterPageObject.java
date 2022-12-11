package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadio() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		checkToCheckboxRadio(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void clickToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void selectBirthDayDropdown(String day) {
		waitForElementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);
	}

	public void selectBirthMonthDropdown(String month) {
		waitForElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
		
	}
	
	public void selectBirthYearDropdown(String year) {
		waitForElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
		
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);
		
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisteredSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
//		2. return new HomePageObject(driver);
		return PageGeneratorManager.getUserHomePage(driver);
	}



}
