package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyproductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		emailAddress = "Johnterry" + getRandomNumber() + "@gmail.com";
		driver.get("https://demo.nopcommerce.com/");

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
		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");
		
		//3- Click logout link => Khởi tạo Homepage
		homePage = registerPage.clickToLogOutLink();
	}

	@Test
	public void User_02_Login() {
		
		//4.- Khởi tạo login page
		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailAddressTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123456");
		
		homePage =loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
	}	
		
	@Test
	public void User_03_Customer_Infor() {
		//6.- Khởi tạo Customer Infor Page
		customerInforPage = homePage.openMyAccountPage();
		
		customerInforPage.isGenderMaleRadioSelected();
		Assert.assertEquals(customerInforPage.getFirstNameTextboxAttribute(),"Minh");
		Assert.assertEquals(customerInforPage.getLastNameTextboxAttribute(), "John");
		Assert.assertEquals(customerInforPage.getDayDropDownSelectedItem(),"18");
		Assert.assertEquals(customerInforPage.getMonthDropDownSelectedItem(),"August");
		Assert.assertEquals(customerInforPage.getYearDropDownSelectedItem(),"1986");
		Assert.assertEquals(customerInforPage.getEmailTextboxAttribute(),emailAddress);
		Assert.assertEquals(customerInforPage.getCompanyTextboxAttribute(),"HANA company");

	}

	@Test
	public void User_04_Switch_Page() {
		//Customer infor => Address
		addressPage = customerInforPage.openAddressPage(driver);
		//Address -> My Product review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		//My Product review->Reward Point
		rewardPointPage= myProductReviewPage.openRewardPointPage(driver);
		//Reward Point => Address
		addressPage = rewardPointPage.openAddressPage(driver);
		//Address => Reward Point
		rewardPointPage= addressPage.openRewardPointPage(driver);
		//Reward Point => My product review
		myProductReviewPage  = rewardPointPage.openMyProductReviewPage(driver);
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
