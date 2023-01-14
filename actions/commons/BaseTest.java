package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX: 
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME :
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE :	
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("Please input with correct browser name.");
		}
		
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().maximize();
		driver.get(GlobalConstants.PORTAL_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}
	
	public WebDriver getBrowserDriver(String browserName, String appUrl) {
		BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX: 
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME :
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE :	
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("Please input with correct browser name.");
		}
		
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}
	
	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
