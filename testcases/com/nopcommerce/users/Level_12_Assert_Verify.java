package com.nopcommerce.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import commons.VerificationFailures;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyproductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

@Listeners(commons.MethodListener.class)
public class Level_12_Assert_Verify extends BaseTest {
	String projectPath = System.getProperty("user.dir");

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		emailAddress = "Johnterry" + getRandomNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Regiter() {
		//1- Mở URL ra thì Khởi tạo Homepage
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadio();
		registerPage.inputToFirstNameTextbox("Minh");
		registerPage.clickToLastNameTextbox("John");
		registerPage.selectBirthDayDropdown("18");
		registerPage.selectBirthMonthDropdown("8");
		registerPage.selectBirthYearDropdown("1986");
		registerPage.inputToEmailAddressTextbox(emailAddress);
		registerPage.inputToCompanyTextbox("HANA company");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getRegisteredSuccessMessage(), "Your ..registration completed");
		
		//3- Click logout link => Khởi tạo Homepage
		homePage = registerPage.clickToLogOutLink();

		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailAddressTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123456");
		
		homePage =loginPage.clickToLoginButton();
		verifyFalse(homePage.isMyAccountLinkDisplay());

		customerInforPage = homePage.openMyAccountPage();
		
		customerInforPage.isGenderMaleRadioSelected();
		verifyEquals(customerInforPage.getFirstNameTextboxAttribute(),"Minh");
		verifyEquals(customerInforPage.getLastNameTextboxAttribute(), "John");
		verifyEquals(customerInforPage.getDayDropDownSelectedItem(),"18");
		verifyEquals(customerInforPage.getMonthDropDownSelectedItem(),"August");
		verifyEquals(customerInforPage.getYearDropDownSelectedItem(),"1986");
		verifyEquals(customerInforPage.getEmailTextboxAttribute(),emailAddress);
		verifyEquals(customerInforPage.getCompanyTextboxAttribute(),"HANA company");

	}
		
@AfterClass
public void afterClass() {
	driver.quit();
}

private WebDriver driver;
WebDriverWait explicitWait;
private String emailAddress;

private UserHomePageObject homePage;
private UserLoginPageObject loginPage;
private UserRegisterPageObject registerPage;
private UserCustomerInforPageObject customerInforPage;
private UserAddressPageObject addressPage;
private UserRewardPointPageObject rewardPointPage;
private UserMyproductReviewPageObject myProductReviewPage;
}
  
/// Từ bài học Assert trở đi thì khi ứng dụng các hàm verifyTrue.False phải thêm hàm lisntener vào file XML

