package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.user.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePageFactory {
	private WebDriver driver;
	
	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(id="gender-male")
	private WebElement genderMaleRadio;
	
	@FindBy(id="FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	private WebElement lastNameTextbox;

	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	private WebElement dayDropDown;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	private WebElement monthDropDown;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	private WebElement yearDropDown;
		
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Company")
	private WebElement companyTextbox;
	
	public boolean isGenderMaleRadioSelected() {
		waitForElementSelected(driver, genderMaleRadio);
		return isElementSelected(driver, genderMaleRadio);
	}

	public String getFirstNameTextboxAttribute() {
		waitForElementVisible(driver, firstNameTextbox);
		return getAttributeValue(driver, firstNameTextbox, "value");
	}

	public String getLastNameTextboxAttribute() {
		waitForElementVisible(driver, lastNameTextbox);
		return getAttributeValue(driver, lastNameTextbox, "value");
	}

	public String getDayDropDownSelectedItem() {
		waitForElementVisible(driver, dayDropDown);
		return selectedOptionInDropdown(driver, dayDropDown);
	}

	public String getMonthDropDownSelectedItem() {
		waitForElementVisible(driver, monthDropDown);
		return selectedOptionInDropdown(driver, monthDropDown);
	}

	public String getYearDropDownSelectedItem() {
		waitForElementVisible(driver, yearDropDown);
		return selectedOptionInDropdown(driver, yearDropDown);
	}

	public Object getEmailTextboxAttribute() {
		waitForElementVisible(driver, emailTextbox);
		return getAttributeValue(driver, emailTextbox, "value");
	}

	public Object getCompanyTextboxAttribute() {
		waitForElementVisible(driver, companyTextbox);
		return getAttributeValue(driver, companyTextbox, "value");
	}

}
