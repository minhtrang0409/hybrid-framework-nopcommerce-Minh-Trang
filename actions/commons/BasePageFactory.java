package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	// Hàm cho webBrowser
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPagetitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
		;
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
		;
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
		;
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	// Windown
	protected void swichToWindownbyID(WebDriver driver, String parentID) {
		Set<String> allWindownsID = driver.getWindowHandles();
		for (String ID : allWindownsID) {
			if (!ID.equals(parentID)) {
				driver.switchTo().window(ID);
			}
		}
	}

	// Dùng được cho >2 tab/windowns
	protected void swichToWindownbytitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindownsID = driver.getWindowHandles();
		for (String ID : allWindownsID) {
			driver.switchTo().window(ID);
			String titlecurrenttab = driver.getTitle();
			if (titlecurrenttab.equals(expectedPageTitle)) {
				break;
			}
		}

	}

	// Close all tab trừ parent page
	protected void Closealltabwithoutparent(WebDriver driver, String parentID) {
		Set<String> allWindownsID = driver.getWindowHandles();
		for (String ID : allWindownsID) {
			if (!ID.equals(parentID)) {
				driver.switchTo().window(ID);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		System.out.println(driver.getCurrentUrl());
	}

	protected void sleepInSecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Hàm cho webElement
	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected void sendkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, WebElement element, String textItem) {
		Select select = new Select(element);
		select.selectByValue(textItem);
	}

	protected String selectedOptionInDropdown(WebDriver driver, WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultiple(WebDriver driver, WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	protected String getAttributeValue(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	protected String convertRgbaToHexa(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	protected void uncheckToCheckbox(WebDriver driver, WebElement element) {
		if (isElementSelected(driver, element)) {
			element.click();
		}
	}

	protected void checkToCheckboxRadio(WebDriver driver, WebElement element) {
		if (!isElementSelected(driver, element)) {
			element.click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	protected boolean isElementEnabled(WebDriver driver, WebElement element) {
		return element.isEnabled();
	}

	protected boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}

	// JavascriptExcutor

	protected Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	protected String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	protected boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	protected void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	// Wait
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
	}

	protected Boolean waitForPageUrlTobe(WebDriver driver, String pageUrl) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.urlToBe(pageUrl));
	}

	protected void waitForElementSelected(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeSelected(element));
	}
}