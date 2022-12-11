package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="gender-male")
	private WebElement genderMaleRadio;
	
	@FindBy(id="FirstName")
	private WebElement firstTextbox;
	
	@FindBy(id="LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordTexbox;
	
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Company")
	private WebElement companyTextbox;
	
	@FindBy(id="register-button")
	private WebElement registerButton;
	
	@FindBy(xpath="//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	private WebElement dayDropDown;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	private WebElement monthDropDown;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	private WebElement yearDropDown;
	

	public void clickToGenderMaleRadio() {
		waitForElementVisible(driver, genderMaleRadio);
		checkToCheckboxRadio(driver, genderMaleRadio);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstTextbox);
		sendkeyToElement(driver, firstTextbox, firstName);
	}

	public void clickToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
		
	}

	public void selectBirthDayDropdown(String day) {
		waitForElementClickable(driver, dayDropDown);
		selectItemInDefaultDropdown(driver, dayDropDown, day);
	}

	public void selectBirthMonthDropdown(String month) {
		waitForElementClickable(driver, monthDropDown);
		selectItemInDefaultDropdown(driver, monthDropDown, month);
		
	}
	
	public void selectBirthYearDropdown(String year) {
		waitForElementClickable(driver, yearDropDown);
		selectItemInDefaultDropdown(driver, yearDropDown, year);
		
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver,emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
		
	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, companyTextbox);
		sendkeyToElement(driver, companyTextbox, company);
		
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver,passwordTextbox);
		sendkeyToElement(driver,passwordTextbox, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTexbox);
		sendkeyToElement(driver, confirmPasswordTexbox, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisteredSuccessMessage() {
		waitForElementVisible(driver,registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogOutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		
	}

	
}
