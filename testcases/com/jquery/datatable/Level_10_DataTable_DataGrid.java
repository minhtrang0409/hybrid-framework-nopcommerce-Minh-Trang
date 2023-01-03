package com.jquery.datatable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}
	
	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(3);
		homePage.openPagingByPageNumber("8");
		homePage.sleepInSecond(3);
		homePage.openPagingByPageNumber("2");
		homePage.sleepInSecond(3);
		homePage.openPagingByPageNumber("1");
		
	}
	
	@Test
	public void Table_02_Enter_to_Header() {
		homePage.enterToHeaderTextboxByLabel("Country","Afghanistan");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextboxByLabel("Females","384187");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextboxByLabel("Males","407124");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextboxByLabel("Total","791312");
	}

	@Test
	public void Table_03() {

	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
