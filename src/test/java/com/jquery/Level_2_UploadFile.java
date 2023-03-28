package com.jquery;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jquery.uploadFile.HomePageObject;
import pageObject.jquery.uploadFile.PageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_2_UploadFile extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private String babyFile = "baby.jpg";
	private String houseFile = "house.jpg";
	private String moneyFile = "money.jpg";
	
	private String[] multipleFileName = {babyFile, houseFile, moneyFile};
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = getBrowserDriver(browser,url);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	@Test
	public void Upload_01_Single_File() {
		homePage.uploadMultipleFiles(babyFile);
		Assert.assertTrue(homePage.isFileNameLoadedDisplayed(babyFile));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileNameLinkUploadedByName(babyFile));
		Assert.assertTrue(homePage.isFileNameImageUploadedByName(babyFile));
	}
	
	@Test
	public void Upload_02_Multiple_File() {
		homePage.refreshPage();
		homePage.uploadMultipleFiles(multipleFileName);
		
		Assert.assertTrue(homePage.isFileNameLoadedDisplayed(babyFile));
		Assert.assertTrue(homePage.isFileNameLoadedDisplayed(houseFile));
		Assert.assertTrue(homePage.isFileNameLoadedDisplayed(moneyFile));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileNameLinkUploadedByName(babyFile));
		Assert.assertTrue(homePage.isFileNameLinkUploadedByName(houseFile));
		Assert.assertTrue(homePage.isFileNameLinkUploadedByName(moneyFile));
		
		Assert.assertTrue(homePage.isFileNameImageUploadedByName(babyFile));
		Assert.assertTrue(homePage.isFileNameImageUploadedByName(houseFile));
		Assert.assertTrue(homePage.isFileNameImageUploadedByName(moneyFile));
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
