package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {

		WebDriver driver;
		
		public LoginPageObject (WebDriver driver) {
			this.driver = driver;
			
		}

		public void clickToCreateNewAccountButton() {
			waitForElementVisible(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
			clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		}

		public  boolean isEmailTextBoxDisplayed() {
			waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
			return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		}

		public void entertoEmailAddressTextbox(String string) {
			// TODO Auto-generated method stub
			
		}

		public boolean isConfirmEmaillAddressTextboxDisplayed() {
			// TODO Auto-generated method stub
			return false;
		}
}
