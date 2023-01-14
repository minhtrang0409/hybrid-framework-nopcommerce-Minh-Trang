package com.jquery;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;
	List<String> allDataTableValues;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}
	
//	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		homePage.openPagingByPageNumber("8");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("8"));
		
		homePage.openPagingByPageNumber("2");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("2"));
		
		homePage.openPagingByPageNumber("1");
		Assert.assertTrue(homePage.isPageNumberActived("1"));
	}
	
//	@Test
	public void Table_02_Enter_to_Header() {
		homePage.enterToHeaderTextboxByLabel("Country","Afghanistan");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextboxByLabel("Females","384187");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextboxByLabel("Males","407124");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextboxByLabel("Total","791312");
	}

//	@Test
	public void Table_03_Get_all_value_Table() {
		
		//Đọc dữ liệu của file TableData.txt
		//Lưu vào 1 List<String> = Expected value
		//Verify Expected value = Actual value
		
		
		//Actual value
		homePage.getValueEachRowAtAllPage();
	}
	

	@Test
	public void Table_04_Enter_To_Textbox_at_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(3);
		//Value để nhập liệu- tham số 1
		// Row number: Tại row nào
		// Nhập textbox tại dòng số 2 3 4
		//ColumeNAme: .....Company
//		homePage.enterToTextboxAtRowNumberByColumnName("Company","1","Hanacompany");
//		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person","2","HAHA");
//		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed","5","13");
//		homePage.sleepInSecond(1);
//		homePage.selectDropDownByColumnNameAtRowNumber("Country","2","Germany" );
//		homePage.sleepInSecond(1);
//		homePage.selectDropDownByColumnNameAtRowNumber("Country","4","Hong Kong" );
//		homePage.sleepInSecond(1);
//		homePage.selectDropDownByColumnNameAtRowNumber("Country","5","United Kingdom" );
//		homePage.sleepInSecond(2);
//		
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "6");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "3");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "4");
//		
		homePage.clicktoIconByRowNumber("5", "Move Up");
		homePage.sleepInSecond(1);
		homePage.clicktoIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(1);
		homePage.clicktoIconByRowNumber("5", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clicktoIconByRowNumber("4", "Remove Current Row");
		homePage.clicktoIconByRowNumber("3", "Remove Current Row");
		homePage.clicktoIconByRowNumber("2", "Remove Current Row");
		homePage.clicktoIconByRowNumber("1", "Remove Current Row");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
