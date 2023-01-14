package com.jquery;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;

import commons.BaseTest;
import pageObject.jQuery.uploadFiles.HomePageObject;
import pageObject.jQuery.uploadFiles.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	HomePageObject homePage;
	String dreamFile ="Dream.png";
	String imageFile ="Image.png";
	String lifeFile ="Life.png";
	String[] multiple = {dreamFile,imageFile,lifeFile};
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}
	
	@Test
	public void TC_01_Upload_One_File_Per_Time() {
		//Step 01 - Load single file
		homePage.uploadMultipleFiles(driver, lifeFile);
		
		Assert.assertTrue(homePage.isFileLoadedByName(lifeFile));
		
		homePage.clickToStartButton();
		
		//Step 04- Verify single link uploaded success
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(lifeFile));
		//Step 05- Verify single image uploaded success
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(lifeFile));
		}
	
	@Test
	public void TC_02_Upload_Multiple_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, multiple);
		
		Assert.assertTrue(homePage.isFileLoadedByName(dreamFile));
		Assert.assertTrue(homePage.isFileLoadedByName(imageFile));
		Assert.assertTrue(homePage.isFileLoadedByName(lifeFile));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(dreamFile));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(imageFile));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(lifeFile));
		
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(dreamFile));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(imageFile));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(lifeFile));
		}

//	@Test
	public void Table_03_Get_all_value_Table() {
	}
	

//	@Test
	public void Table_04_Enter_To_Textbox_at_Any_Row() {
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
