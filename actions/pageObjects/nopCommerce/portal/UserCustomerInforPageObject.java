package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage {
	WebDriver driver;
	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isGenderMaleRadioSelected() {
		waitForElementSelected(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextboxAttribute() {
		waitForElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxAttribute() {
		waitForElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getDayDropDownSelectedItem() {
		waitForElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
		return selectedOptionInDropdown(driver, CustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getMonthDropDownSelectedItem() {
		waitForElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		return selectedOptionInDropdown(driver, CustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getYearDropDownSelectedItem() {
		waitForElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
		return selectedOptionInDropdown(driver, CustomerInforPageUI.YEAR_DROPDOWN);
	}

	public Object getEmailTextboxAttribute() {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, CustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public Object getCompanyTextboxAttribute() {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver, CustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}



}
