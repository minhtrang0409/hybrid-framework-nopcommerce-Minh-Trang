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

public class BasePage {

	// Hàm cho webBrowser
	public void openPageUrl(WebDriver driver, String pageUrl) {
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
		driver.navigate().back();
		;
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
		;
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
		;
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
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

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	// Windown
	public void swichToWindownbyID(WebDriver driver, String parentID) {
		Set<String> allWindownsID = driver.getWindowHandles();
		for (String ID : allWindownsID) {
			if (!ID.equals(parentID)) {
				driver.switchTo().window(ID);
			}
		}
	}

	// Dùng được cho >2 tab/windowns
	public void swichToWindownbytitle(WebDriver driver, String expectedPageTitle) {
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
	public void Closealltabwithoutparent(WebDriver driver, String parentID) {
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

	public void sleepInSecond(long timeInsecond) {
	try {
		Thread.sleep(timeInsecond * 1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
	
	//Hàm cho webElement
	public By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator));
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.click();
	}
	
	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}

	public String selectedOptionInDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectitemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath,
			String expectedTextitem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		List<WebElement> allDropdownItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		for (WebElement item : allDropdownItems) {
			String actualTextitem = item.getText().trim();
			if (actualTextitem.equals(expectedTextitem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(2);
				item.click();
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getAttribute(propertyName);
	}
	public String convertRgbaToHexa(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
		}

	public void uncheckToCheckbox(WebDriver driver, String xpathLocator) {
		if(isElementSelected(driver, xpathLocator)) {
			getWebElement(driver, xpathLocator).click();
		}
	}
		
	public void checkToCheckboxRadio(WebDriver driver, String xpathLocator) {
		if(!isElementSelected(driver, xpathLocator)) {
			getWebElement(driver, xpathLocator).click();
		}
	}
	
	public boolean  isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	public boolean  isElementEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	public boolean  isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	public void switchtoFrame (WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
	public void switchToDefaultContent(WebDriver driver, String xpathLocator) {
		driver.switchTo().defaultContent();
	}
	
	public void moveToElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).moveToElement(getWebElement(driver, xpathLocator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).doubleClick(getWebElement(driver, xpathLocator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).contextClick(getWebElement(driver, xpathLocator)).perform();
	}
	
	public void dragDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}
	
	public void sendKeyBoardToElement(WebDriver driver, String xpathLocator, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, xpathLocator), key).perform();
	}
	
	//JavascriptExcutor
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	//Wait
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForListElementsClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitForListElementsInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
	}
	
	public void waitForListElementsPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public Boolean waitForPageUrlTobe(WebDriver driver, String pageUrl) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.urlToBe(pageUrl));
	}

	public void waitForElementSelected(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeSelected(getByXpath(locator)));
	}
}