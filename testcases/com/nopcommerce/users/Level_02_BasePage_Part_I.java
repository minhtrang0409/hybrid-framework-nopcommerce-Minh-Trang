package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_BasePage_Part_I {
	WebDriver driver;
	WebDriverWait explicitWait;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String emailAddress;
	WebDriverWait expliciteWait;
	By Loadingicon = By.cssSelector("div#loading");
	By Helloworldtext = By.cssSelector("div#finish>h4");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		driver = new FirefoxDriver();
		expliciteWait = new WebDriverWait(driver, 15);
		basePage = new BasePage();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		emailAddress = "Johnterry" + getRandomNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Regiter() {
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//input[@id='gender-male']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Minh");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "John");
		basePage.selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "18");
		basePage.selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "8");
		basePage.selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1986");
		
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Company']", "HANA company");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
		basePage.clickToElement(driver, "//a[@class='ico-logout']");
		
		Assert.assertTrue(basePage.waitForPageUrlTobe(driver, "https://demo.nopcommerce.com/"));
		Assert.assertEquals(basePage.getPageUrl(driver), "https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_02_Login() {
		basePage.clickToElement(driver, "//a[@class='ico-login']");
		
		basePage.sendkeyToElement(driver, "//input[@class='email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@class='password']", "123456");
		basePage.clickToElement(driver, "//button[text()='Log in']");
		
		Assert.assertTrue(basePage.waitForPageUrlTobe(driver, "https://demo.nopcommerce.com/"));
		Assert.assertEquals(basePage.getPageUrl(driver), "https://demo.nopcommerce.com/");
		Assert.assertTrue(basePage.isElementDisplayed(driver, "//a[@class='ico-account']"));
		
		basePage.clickToElement(driver, "//a[@class='ico-account']");
				
		Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='FirstName']", "value"), "Minh");
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='LastName']", "value"), "John");
		Assert.assertEquals(basePage.selectedOptionInDropdown(driver, "//select[@name='DateOfBirthDay']"), "18");
		Assert.assertEquals(basePage.selectedOptionInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "August");
		Assert.assertEquals(basePage.selectedOptionInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1986");
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Company']", "value"), "HANA company");
		
		
	}
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
