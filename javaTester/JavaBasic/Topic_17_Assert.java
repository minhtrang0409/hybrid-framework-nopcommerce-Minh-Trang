package JavaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.VerificationFailures;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.jQuery.uploadFiles.PageGeneratorManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

@Listeners(commons.MethodListener.class)
public class Topic_17_Assert extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Parameters({"browser", "url"})
	@BeforeClass
public void beforeClass() {
//		driver = getBrowserDriver(browserName,appUrl);
	driver = getBrowserDriver("CHROME","https://www.facebook.com/");
//		driver = WebDriverManager.chromedriver().create();
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com/");
}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		System.out.println("Assert 01");
		String loginPageUrl = driver.getCurrentUrl();
		verifyEquals(loginPageUrl, "https://www.facebook.com/");
		
		System.out.println("Assert 02");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "Facebook – log in or sign up");
		
		System.out.println("Assert 03 - Failed");
		String loginPageTitle2 = driver.getCurrentUrl();
		verifyEquals(loginPageTitle2, "Facebook – log in or sign up1111111");
		
		System.out.println("Assert 04");
		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		
		System.out.println("Assert 05 - Failed");
		verifyTrue(driver.findElement(By.xpath("//input[@name='login_source']")).isDisplayed());
		
	}
		
@AfterClass
public void afterClass() {
	driver.quit();
}
}
  

