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

public class Level_02_BasePage_Part_III extends BasePage {
	WebDriver driver;
	WebDriverWait explicitWait;
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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		emailAddress = "Johnterry" + getRandomNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Regiter() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Minh");
		sendkeyToElement(driver, "//input[@id='LastName']", "John");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "18");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "8");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1986");

		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Company']", "HANA company");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		clickToElement(driver, "//a[@class='ico-logout']");

		Assert.assertTrue(waitForPageUrlTobe(driver, "https://demo.nopcommerce.com/"));
		Assert.assertEquals(getPageUrl(driver), "https://demo.nopcommerce.com/");
	}

	@Test
	public void User_02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@class='email']", emailAddress);
		sendkeyToElement(driver, "//input[@class='password']", "123456");
		clickToElement(driver, "//button[text()='Log in']");

		Assert.assertTrue(waitForPageUrlTobe(driver, "https://demo.nopcommerce.com/"));
		Assert.assertEquals(getPageUrl(driver), "https://demo.nopcommerce.com/");
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));

		clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='FirstName']", "value"), "Minh");
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='LastName']", "value"), "John");
		Assert.assertEquals(selectedOptionInDropdown(driver, "//select[@name='DateOfBirthDay']"),
				"18");
		Assert.assertEquals(selectedOptionInDropdown(driver, "//select[@name='DateOfBirthMonth']"),
				"August");
		Assert.assertEquals(selectedOptionInDropdown(driver, "//select[@name='DateOfBirthYear']"),
				"1986");
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='Company']", "value"), "HANA company");

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
