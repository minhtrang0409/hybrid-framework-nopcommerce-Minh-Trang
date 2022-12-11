package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyproductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;

public class PageGeneratorManager {	
	
	public static UserHomePageObject getUserHomePage (WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage (WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage (WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserCustomerInforPageObject getUserCustomerInforPage (WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}
	
	public static UserAddressPageObject getUserAddressPage (WebDriver driver) {
		return new UserAddressPageObject(driver);
	}
	
	public static UserMyproductReviewPageObject getUserMyproductReviewPage (WebDriver driver) {
		return new UserMyproductReviewPageObject(driver);
	}
	
	public static UserRewardPointPageObject getUserRewardPointPage (WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage (WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage (WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
}
