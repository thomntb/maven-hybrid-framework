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

public class Paging_Display extends BaseTest {

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
	public void Paging_TC_01() {
		log.info("Paging1 - Step 01: hover mouse to 'Computer' menu link");
		userHomePage.hoverMouseToHeaderMenuLink("Computers");
		
		log.info("Paging1 - Step 02: click to 'Notebooks' menu");
		userHomePage.clickToChildHeaderMenu("Computers", "Notebooks");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Paging1 - Step 03: click open to 'Position' dropdown and select '3' ");
		userNotebooksPage.selectValuePagingInDropdown("3");
		
		log.info("Paging1 - Step 04: verify size page is 3");
		Assert.assertTrue(userNotebooksPage.isSizePagingNotebooks(3));
		
		log.info("Paging1 - Step 05: verify 'Next' icon displayed");
		Assert.assertTrue(userNotebooksPage.isIconPagingDisplayed("Next"));
		
		log.info("Paging1 - Step 06: click to 'Next' icon");
		userNotebooksPage.clickToIconPaging("Next");
		
		log.info("Paging1 - Step 07: verify 'Previous' icon displayed");
		Assert.assertTrue(userNotebooksPage.isIconPagingDisplayed("Previous"));
		
		log.info("Paging1 - Step 08: click open to 'Position' dropdown and select '6' ");
		userNotebooksPage.selectValuePagingInDropdown("6");
		
		log.info("Paging1 - Step 09: verify size page is <= 6");
		Assert.assertTrue(userNotebooksPage.isSizePagingNotebooks(6));
		
		log.info("Paging1 - Step 10: verify 'Next' icon displayed");
		Assert.assertTrue(userNotebooksPage.isPagingUndisplayed("Next"));
		
		log.info("Paging1 - Step 11: click open to 'Position' dropdown and select '9' ");
		userNotebooksPage.selectValuePagingInDropdown("9");
		
		log.info("Paging1 - Step 12: verify size page is <= 9");
		Assert.assertTrue(userNotebooksPage.isSizePagingNotebooks(9));
		
		log.info("Paging1 - Step 13: verify 'Next' icon displayed");
		Assert.assertTrue(userNotebooksPage.isPagingUndisplayed("Next"));
	}
	
	
	public void Paging_TC_02() {
		log.info("Paging9 - Step 01: hover mouse to 'Computer' menu link");
		userHomePage.refreshPage();
		userHomePage.hoverMouseToHeaderMenuLink("Computers");
		
		log.info("Paging9 - Step 02: click to 'Notebooks' menu");
		userHomePage.clickToChildHeaderMenu("Computers", "Notebooks");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Paging9 - Step 03: click open to 'Position' dropdown and select '9' ");
		userNotebooksPage.selectValuePagingInDropdown("9");
		
		log.info("Paging9 - Step 04: verify size page is <= 9");
		Assert.assertTrue(userNotebooksPage.isSizePagingNotebooks(9));
		
		log.info("Paging9 - Step 05: verify 'Next' icon displayed");
		Assert.assertTrue(userNotebooksPage.isPagingUndisplayed("Next"));
	}
	
	
	public void Paging_TC_03() {
		log.info("Paging6 - Step 01: hover mouse to 'Computer' menu link");
		userNotebooksPage.hoverMouseToHeaderMenuLink("Computers");
		
		log.info("Paging6 - Step 02: click to 'Notebooks' menu");
		userHomePage.clickToChildHeaderMenu("Computers", "Notebooks");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Paging6 - Step 03: click open to 'Position' dropdown and select '6' ");
		userNotebooksPage.selectValuePagingInDropdown("6");
		
		log.info("Paging6 - Step 04: verify size page is <= 6");
		Assert.assertTrue(userNotebooksPage.isSizePagingNotebooks(6));
		
		log.info("Paging6 - Step 05: verify 'Next' icon displayed");
		Assert.assertTrue(userNotebooksPage.isPagingUndisplayed("Next"));
	}
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
