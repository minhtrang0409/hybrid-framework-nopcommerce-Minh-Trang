package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyproductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;

public class Level_08_Switch_Role extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		UserEmailAddress = "minhtrang.9898@gmail.com";
		userPassword = "123456";
		adminEmailAddress= "admin@yourstore.com";
		adminPassword = "admin";
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();
		//Login as User role
		userHomePage = userLoginPage.loginAsUser(UserEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
		//Home page -> Customer infor
		userCustomerInforPage = userHomePage.openMyAccountPage();
		
		//Customer infor -> click logout -> HomePage
		userHomePage = userCustomerInforPage.clickToLogoutUserPage(driver);
		
		//User Home page -> Open Admin page -> Login page (admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		//Login as admin role
		adminDashboardPage= adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplay());
	    // Dashboard Page -> Click Logout -> Login Page (admin)
		adminLoginPage = adminDashboardPage.clickToLogoutAdminPage(driver);
	
	}

	@Test
	public void Role_02_Admin() {
		//Login Page (Admin) -> Open User Url -> Hompage user
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		// Home Page -> Login Page User
		userLoginPage = userHomePage.openLoginPage();
		//Login as User role
		userHomePage = userLoginPage.loginAsUser(UserEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
	}	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	WebDriverWait explicitWait;
	private String UserEmailAddress, userPassword, adminEmailAddress, adminPassword ;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
}
