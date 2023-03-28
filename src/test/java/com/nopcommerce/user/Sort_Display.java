package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNotebooksPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Sort_Display extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserNotebooksPageObject userNotebooksPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(Common_Register_End_User.emailUser, Common_Register_End_User.passwordUser);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Sort_TC_01_AToZ() {
		log.info("Sort A - Z - Step 01: hover mouse to 'Computer' menu link");
		userHomePage.hoverMouseToHeaderMenuLink("Computers");
		
		log.info("Sort A - Z - Step 02: click to 'Notebooks' menu");
		userHomePage.clickToChildHeaderMenu("Computers", "Notebooks");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Sort A - Z - Step 03: click open to 'Position' dropdown and select 'Name: A to Z' ");
		userNotebooksPage.selectValueInDropdown("Name: A to Z");
		
		log.info("Sort A - Z - Step 04: sort name ascending");
		Assert.assertTrue(userNotebooksPage.isDataSortAscendingString());
	}
	
	@Test
	public void Sort_TC_02_ZToA() {
		log.info("Sort Z - A - Step 01: hover mouse to 'Computer' menu link");
		userHomePage.hoverMouseToHeaderMenuLink("Computers");
		
		log.info("Sort Z - A - Step 02: click to 'Notebooks' menu");
		userHomePage.clickToChildHeaderMenu("Computers", "Notebooks");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Sort Z - A - Step 03: click open to 'Position' dropdown and select 'Name: Z to A' ");
		userNotebooksPage.selectValueInDropdown("Name: Z to A");
		
		log.info("Sort Z - A - Step 04: sort name descending");
		Assert.assertTrue(userNotebooksPage.isDataSortDescendingString());
	}
	
	@Test
	public void Sort_TC_03_HighToLow() {
		log.info("Sort High - Low - Step 01: hover mouse to 'Computer' menu link");
		userHomePage.hoverMouseToHeaderMenuLink("Computers");
		
		log.info("Sort High - Low - Step 02: click to 'Notebooks' menu");
		userHomePage.clickToChildHeaderMenu("Computers", "Notebooks");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Sort High - Low - Step 03: click open to 'Position' dropdown and select 'Price: High to Low' ");
		userNotebooksPage.selectValueInDropdown("Price: High to Low");
		
		log.info("Sort High - Low - Step 04: sort price ascending");
		Assert.assertTrue(userNotebooksPage.isDataSortDescendingFloat());
	}
	
	@Test
	public void Sort_TC_04_LowToHigh() {
		log.info("Sort Low - High - Step 01: hover mouse to 'Computer' menu link");
		userHomePage.hoverMouseToHeaderMenuLink("Computers");
		
		log.info("Sort Low - High - Step 02: click to 'Notebooks' menu");
		userHomePage.clickToChildHeaderMenu("Computers", "Notebooks");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Sort Low - High - Step 03: click open to 'Position' dropdown and select 'Price: Low to High' ");
		userNotebooksPage.selectValueInDropdown("Price: Low to High");
		
		log.info("Sort Low - High - Step 04: sort price descending");
		Assert.assertTrue(userNotebooksPage.isDataSortAscendingFloat());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
