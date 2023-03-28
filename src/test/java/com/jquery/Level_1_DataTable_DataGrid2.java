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

public class Level_1_DataTable_DataGrid2 extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = getBrowserDriver(browser,url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	
	public void Table_01_Select_Pagination() {
		homePage.sendkeyToDynamicTextboxByRowAndColumnName("Company","1","FPT Software");
		homePage.sendkeyToDynamicTextboxByRowAndColumnName("Contact Person","1","034239239");
		homePage.sendkeyToDynamicTextboxByRowAndColumnName("Order Placed","1","5");
		
		homePage.selectDropdownByRowAndColumnName("Country", "1", "Japan");
		homePage.selectDropdownByRowAndColumnName("Country", "1", "Malaysia");
		
		homePage.selectRadioByRowAndColumnName("NPO?", "1");
	}
	
	@Test
	public void Table_02_Edit_Table() {
		homePage.clickLoadDataButton();
		homePage.sendkeyToDynamicTextboxByRowAndColumnName("Company","1","FPT Software");
		homePage.sendkeyToDynamicTextboxByRowAndColumnName("Contact Person","6","034239239");
		homePage.selectDropdownByRowAndColumnName("Country", "4", "Japan");
		homePage.selectRadioByRowAndColumnName("NPO?", "1");
		homePage.unSelectRadioByRowAndColumnName("NPO?", "1");
		homePage.selectRadioByRowAndColumnName("NPO?", "6");

		homePage.actionIconByRowNumber("1", "Remove Current Row");
		homePage.actionIconByRowNumber("1", "Insert Row Above");
		homePage.actionIconByRowNumber("2", "Move Up");
		homePage.actionIconByRowNumber("1", "Move Down");
		homePage.actionIconByRowNumber("1", "Remove Current Row");
		homePage.actionIconByRowNumber("1", "Remove Current Row");
		homePage.actionIconByRowNumber("1", "Remove Current Row");
		homePage.actionIconByRowNumber("1", "Remove Current Row");
		homePage.actionIconByRowNumber("1", "Remove Current Row");
		homePage.actionIconByRowNumber("1", "Remove Current Row");
		homePage.actionIconByRowNumber("1", "Remove Current Row");
		homePage.actionIconByRowNumber("1", "Remove Current Row");
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
