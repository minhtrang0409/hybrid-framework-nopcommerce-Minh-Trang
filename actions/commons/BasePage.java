package commons;

import java.awt.Color;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	//Mở 1 url ra
	public void openPageUrl(WebDriver driver, String pageUrl){
		driver.get(pageUrl);
	}
	public String getPagetitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	public void backToPage(WebDriver driver) {
		driver.navigate().back();;
	}
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();;
	}
	public void refreshCurrentPage(WebDriver driver) {
		 driver.navigate().refresh();;
	}
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	public void senkeyToAlert(WebDriver driver, String textValue) {
		 waitForAlertPresence(driver).sendKeys(textValue);
	}
	//Windown
	public void swichToWindownbyID(WebDriver driver, String parentID) {
		Set<String> allWindownsID = driver.getWindowHandles();
		for(String ID : allWindownsID) {
			if(!ID.equals(parentID)) {
				driver.switchTo().window(ID);
			}
		}
	}

	//Dùng được cho >2 tab/windowns
	public void swichToWindownbytitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindownsID = driver.getWindowHandles();
		for(String ID : allWindownsID) {	
			driver.switchTo().window(ID);
			String titlecurrenttab = driver.getTitle();
			if(titlecurrenttab.equals(expectedPageTitle)) {
				break;
			}
		}
		
	}
	//Close all tab trừ parent page
	public void Closealltabwithoutparent(WebDriver driver,String parentID) {
				Set<String> allWindownsID = driver.getWindowHandles();
				for(String ID : allWindownsID) {	
					if(!ID.equals(parentID)) {
						driver.switchTo().window(ID);
						driver.close();
					}
		}
				driver.switchTo().window(parentID);
				System.out.println(driver.getCurrentUrl());
	}
	public By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	public WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator));
	}
	public void clickToElement(WebDriver driver, String xpathLocator,String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	public void getElementText(WebDriver driver, String xpathLocator,String textValue) {
		getWebElement(driver, xpathLocator).getText();
	}
	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}
	public void getFirstSelectedItemDefaulDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.getFirstSelectedOption().getText();
	}
	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	public void selectitemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextitem) {
		getWebElement(driver, parentXpath).click();
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		List<WebElement> allDropdownItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		for (WebElement item : allDropdownItems) {
			String actualTextitem = item.getText().trim();
			if(actualTextitem.equals(expectedTextitem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(2);
				item.click();
				break;
			}
			}
	}
	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getAttribute(propertyName);
	}
	public String convertRgbaToHexa(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		driver.findElements(getByXpath(xpathLocator));
	}
	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
		}
	

	
	
public void sleepInSecond(long timeInsecond) {
	try {
		Thread.sleep(timeInsecond * 1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	}