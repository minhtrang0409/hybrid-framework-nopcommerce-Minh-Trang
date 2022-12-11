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
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String emailAddress;

	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInforPageObject customerInforPage;
	
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



	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
