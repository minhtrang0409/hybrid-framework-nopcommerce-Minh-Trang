package eclipeTips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Topic_01_Hot_Keys {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
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
	}

	public void TC_01_Invisible() {
		expliciteWait = new WebDriverWait(driver, 30);
		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();
		expliciteWait.until(ExpectedConditions.invisibilityOfElementLocated(Loadingicon));
		Assert.assertEquals(driver.findElement(Helloworldtext).getText(), "Hello World!");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
