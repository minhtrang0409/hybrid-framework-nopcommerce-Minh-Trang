package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;
import pageUIs.nopCommerce.user.HomePageUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;
	
	public AdminDashboardPageObject(WebDriver driver) {
		//this: tham chiếu tới biến toàn cục của Class
		this.driver = driver;
	}
	
	public boolean isDashboardHeaderDisplay() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}
	
}
