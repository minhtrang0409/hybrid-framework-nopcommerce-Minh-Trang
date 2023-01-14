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
import org.testng.Assert;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserMyproductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;
import pageUIs.JQuery.uploadFile.BasePageJqueryUI;
import pageUIs.nopCommerce.user.BasePageUI;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}
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
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
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
	
	
	//LocatorType: id=/ css=/ xpath=/ name=/ class=
	private By getByLocator(String locatorType) {
		By by = null;
		if(locatorType.startsWith("id=")||locatorType.startsWith("ID=")||locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=")|| locatorType.startsWith("CLASS=")|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=")|| locatorType.startsWith("NAME=")|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=")||locatorType.startsWith("CSS=")||locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=")||locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")||locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}
	
	//Nếu như truyền vào locator type là xpath thì đúng
	// Nếu truyền locator type khác Xpath thì nó sẽ sai
	private String getDynamicXpath(String locatorType, String... values) {
		if(locatorType.startsWith("xpath=")||locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")||locatorType.startsWith("XPath=")) {
		locatorType = String.format(locatorType, (Object[]) values);
		}
		return locatorType;
	}
	
	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	
	public void clickToElement(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		element.click();
	}
	
	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.click();
	}
	
	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType,String textValue, String... dynamicValues ) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(textItem);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem,String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByValue(textItem);
	}

	public String selectedOptionInDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectitemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator,
			String expectedTextitem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		List<WebElement> allDropdownItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
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

	public String getAttributeValue(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getAttribute(propertyName);
	}
	public String convertRgbaToHexa(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
		}
	
	public int getElementSize(WebDriver driver, String locatorType,String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locatorType,String... dynamicValues) {
		if(isElementSelected(driver, getDynamicXpath(locatorType, dynamicValues))) {
			getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locatorType) {
		if(isElementSelected(driver, locatorType)) {
			getWebElement(driver, locatorType).click();
		}
	}
	
	public void checkToCheckboxRadio(WebDriver driver, String locatorType) {
		if(!isElementSelected(driver, locatorType)) {
			getWebElement(driver, locatorType).click();
		}
	}
		
	public void checkToCheckboxRadio(WebDriver driver, String locatorType,String... dynamicValues) {
		if(!isElementSelected(driver, getDynamicXpath(locatorType, dynamicValues))) {
			getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
		}
	}
	
	public boolean  isElementDisplayed(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}
	
	public boolean  isElementDisplayed(WebDriver driver, String locatorType,String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}
	public boolean  isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}
	public boolean  isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}
	
	public void switchtoFrame (WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	public void switchToDefaultContent(WebDriver driver, String locatorType) {
		driver.switchTo().defaultContent();
	}
	
	public void moveToElement(WebDriver driver, String locatorType) {
		new Actions(driver).moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locatorType) {
		new Actions(driver).doubleClick(getWebElement(driver, locatorType)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locatorType) {
		new Actions(driver).contextClick(getWebElement(driver, locatorType)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, locatorType), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues ) {
		new Actions(driver).sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}
	
	public void dragDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}
	
	public void sendKeyBoardToElement(WebDriver driver, String locatorType, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, locatorType), key).perform();
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
	
	public boolean isImageLoaded(WebDriver driver, String locator, String... dynamicValues ) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver,getDynamicXpath(locator, dynamicValues)));
		return status;
	}
	
	//Wait
	
	public void waitForElementVisible(WebDriver driver, String locatorType,String... dynamicValues) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locatorType,String... dynamicValues) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locatorType,String... dynamicValues) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForListElementsClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}
	
	public void waitForListElementsInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
	}
	
	public void waitForListElementsPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
	}
	
	public Boolean waitForPageUrlTobe(WebDriver driver, String pageUrl) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.urlToBe(pageUrl));
	}

	public void waitForElementSelected(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
	}

	public void uploadMultipleFiles (WebDriver driver, String ...fileNames) {
		//Đường dẫn của thư mục uploadFiles: Windows/ MAC/Linux
		String filePath = GlobalConstants.UPLOAD_FILE;
		//Đường dẫn của tất cả các files
		String fullFileName = "";
		for (String file: fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim(); // xóa khoảng trắng, ở đầu hoặc cuối chuỗi (String)
		getWebElement(driver, BasePageJqueryUI.UPLOAD_FILE).sendKeys(fullFileName);
		}
	
// Tối ưu ở bài học Level_07_Switch_Page
	public UserAddressPageObject openAddressPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserMyproductReviewPageObject openMyProductReviewPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyproductReviewPage(driver);
	}
	
	public UserRewardPointPageObject openRewardPointPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}
	
	public UserRewardPointPageObject openCustomerInforPage (WebDriver driver) {
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}
	
	//Tối ưu ở bài học Level_09
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MYACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MYACCOUNT_AREA,pageName);
		switch (pageName) {
		case "Customer info": 
			return PageGeneratorManager.getUserCustomerInforPage(driver);
		case "Addresses": 
			return PageGeneratorManager.getUserAddressPage(driver);
		case "My product reviews": 
			return PageGeneratorManager.getUserMyproductReviewPage(driver);
		case "Reward points": 
			return PageGeneratorManager.getUserRewardPointPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My Account area");
		}
	}
	
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MYACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MYACCOUNT_AREA,pageName);
	}
	
	//Level_08_Switch_Role
	public UserHomePageObject clickToLogoutUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_USER_PAGE);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_USER_PAGE);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogoutAdminPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_ADMIN_PAGE);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_ADMIN_PAGE);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	private long longTimeout =30;
}