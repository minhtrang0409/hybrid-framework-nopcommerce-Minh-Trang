package pageObject.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.JQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver= driver;
	}
	
	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Totalsize = " + totalPage);
		
		List<String> allRowValueAllPage = new ArrayList<String>();
		
		//k lưu trùng
//		Set<String> allRowValueUniqueAllPage = new HashSet<String>();
		
		for(int index = 1; index < totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			sleepInSecond(1);
			
			//Gettext của tất cả row mỗi page và add vào List
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		//In tất cả giá trị row ra- tất cả các page
		for(String value: allRowValueAllPage) {
			System.out.println(value);
		}
		return allRowValueAllPage;
	}

	public void enterToTextboxAtRowNumberByColumnName(String columName, String rowNumber, String value) {
		//Colum index dựa vào tên cột
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName ) + 1;
		
		//Sendkey vào dòng nào
		waitForElementVisible(driver, HomePageUI.TEXTBOX_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX, value , rowNumber,String.valueOf(columIndex));
	}

	public void selectDropDownByColumnNameAtRowNumber(String columName, String rowNumber, String value) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName ) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX, value , rowNumber,String.valueOf(columIndex));		
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName ) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
		checkToCheckboxRadio(driver, HomePageUI.CHECKBOX_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName ) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
		uncheckToCheckbox(driver, HomePageUI.CHECKBOX_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
	}

	public void clicktoIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
	}
}