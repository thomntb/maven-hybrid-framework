package com.wordpress.admin;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_18_Multi_Environment_TestNG_Parameter extends BaseTest {

	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostSearchPO adminPostSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;

	String adminUsername = "automationfc";
	String adminPassword = "automationfc";
	String urlPostSearch;
	int randomData = randomNumber();
	String titleTextbox = "Live coding " + randomData;
	String bodyTextbox = "Live coding body " + randomData;
	String editTitleTextbox = "Edit coding " + randomData;
	String editBodyTextbox = "Edit coding body " + randomData;
	String author = "automationfc";
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "environment"})
	@BeforeClass
	public void beforeClass(String browser, String environment) {
		driver = getBrowserDriver(browser, environment);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Precondition: enter to username '" + adminUsername + "'");
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Precondition: enter to password '" + adminPassword + "'");
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Precondition: click to 'Login' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create_New_Add() {
		log.info("Create - Step 01: click to 'Post' menu");
		adminPostSearchPage = adminDashboardPage.clickToPostMenu();

		log.info("Create - Step 02: get URL at 'Post Search' page");
		urlPostSearch = adminPostSearchPage.getPostSearchUrl();

		log.info("Create - Step 03: click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create - Step 04: enter to tilte textbox");
		adminPostAddNewPage.enterToTilteTextbox(titleTextbox);

		log.info("Create - Step 05: enter to body textbox");
		adminPostAddNewPage.enterToBodyTextbox(bodyTextbox);

		log.info("Create - Step 06: click to 'Publish' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Create - Step 07: verify 'Publish' message is displayed");
		Assert.assertTrue(adminPostAddNewPage.isgetPostAddNewOrUpdateSuccessMessage("Post published."));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
