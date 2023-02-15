package com.facebook.register;

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
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGeneratorManager;


public class Level_13_Element_Undisplayed extends BaseTest {
	private LoginPageObject loginPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
	}

	@Test
	public void TC_01_Verify_Element_Display() {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailTextBoxDisplayed());
		
		//Verify mong đợi Confirm Email displayed(true)
		loginPage.entertoEmailAddressTextbox("minhtrang@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmaillAddressTextboxDisplayed());
		
	}
	
	@Test
	public void TC_02_Verify_Element_UnDisplay_IN_DOM() {
		
	}
	
	@Test
	public void TC_03_Verify_Element_UnDisplay_IN_DOM() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
