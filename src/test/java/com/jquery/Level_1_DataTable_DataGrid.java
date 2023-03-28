package com.jquery;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jquery.datatable.HomePageObject;
import pageObject.jquery.datatable.PageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_1_DataTable_DataGrid extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = getBrowserDriver(browser,url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Table_01_Select_Pagination() {
		homePage.openPagingByPageNumber("4");
		Assert.assertTrue(homePage.isPageNumberActive("4"));
	}
	
	@Test
	public void Table_02_Filter_Value_Coloum() {
		homePage.enterHeaderToTextboxByLabel("Country", "Angola");
		homePage.getValueEachRowAllPage("country");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
