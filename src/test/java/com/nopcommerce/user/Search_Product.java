package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.admin.AdminDashboardsPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageUIs.nopCommerce.user.CustomerPageUI;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Search_Product extends BaseTest {

	private WebDriver driver;
	private String emailUser, firstName, lastName, passwordUser;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserSearchPageObject userSearchPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailUser = "automation" + userHomePage.randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		passwordUser = "123456";

		userRegisterPage = userHomePage.clickToRegisterLink();
		userRegisterPage.inputToFirstNameTextBox(firstName);
		userRegisterPage.inputToLastNameTextBox(lastName);
		userRegisterPage.inputToEmailTextBox(emailUser);
		userRegisterPage.inputToPasswordTextBox(passwordUser);
		userRegisterPage.inputToConfirmTextBox(passwordUser);

		userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		userHomePage = userRegisterPage.clickToContinueButton();
		// userRegisterPage.clickToUserLogoutButton(driver);

		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		userHomePage.clickToFooterLink("Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
	}

	@Test
	public void Search_TC_01_Empty_Data() {
		userSearchPage.clickToSearchButton();
		Assert.assertEquals(userSearchPage.getMinTextSearchErrorMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void Search_TC_02_Data_Not_Exits() {
		userSearchPage.sendkeyToSeachTextbox("Macbook Pro 2050");
		userSearchPage.clickToSearchButton();
		Assert.assertEquals(userSearchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_TC_03_Product_Name_Relatively() {
		userSearchPage.sendkeyToSeachTextbox("lenovo");
		userSearchPage.clickToSearchButton();
		Assert.assertEquals(userSearchPage.getNumberOfProduct(), 2);
	}

	@Test
	public void Search_TC_04_With_Product_Name_Absolutely() {
		userSearchPage.sendkeyToSeachTextbox("Lenovo Thinkpad X1 Carbon Laptop");
		userSearchPage.clickToSearchButton();
		Assert.assertEquals(userSearchPage.getNumberOfProduct(), 1);
		Assert.assertEquals(userSearchPage.getTextOfNameProduct(), "Lenovo Thinkpad X1 Carbon Laptop");
	}

	@Test
	public void Search_TC_05_Advanced_Search_Parent_Categories() {
		userSearchPage.sendkeyToSeachTextbox("Apple MacBook Pro");
		userSearchPage.selectAdvancedSearchCheckbox("Advanced search");
		userSearchPage.selectAdvancedSearchDropdown("Category", "Computers");
		userSearchPage.clickToSearchButton();
		Assert.assertEquals(userSearchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_TC_06_Advanced_Search_SubCategories() {
		userSearchPage.sendkeyToSeachTextbox("Apple MacBook Pro");
		userSearchPage.selectAdvancedSearchCheckbox("Advanced search");
		userSearchPage.selectAdvancedSearchDropdown("Category", "Computers");
		userSearchPage.selectAdvancedSearchCheckbox("Automatically search sub categories");
		userSearchPage.clickToSearchButton();
		Assert.assertEquals(userSearchPage.getNumberOfProduct(), 1);
		Assert.assertEquals(userSearchPage.getTextOfNameProduct(), "Apple MacBook Pro 13-inch");
	}

	@Test
	public void Search_TC_07_Advanced_Search_Incorrect_Manufacturer() {
		userSearchPage.sendkeyToSeachTextbox("Apple MacBook Pro");
		userSearchPage.selectAdvancedSearchCheckbox("Advanced search");
		userSearchPage.selectAdvancedSearchDropdown("Category", "Computers");
		userSearchPage.selectAdvancedSearchCheckbox("Automatically search sub categories");
		userSearchPage.selectAdvancedSearchDropdown("Manufacturer", "HP");
		userSearchPage.clickToSearchButton();
		Assert.assertEquals(userSearchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_TC_08_Advanced_Search_Correct_Manufacturer() {
		userSearchPage.sendkeyToSeachTextbox("Apple MacBook Pro");
		userSearchPage.selectAdvancedSearchCheckbox("Advanced search");
		userSearchPage.selectAdvancedSearchDropdown("Category", "Computers");
		userSearchPage.selectAdvancedSearchCheckbox("Automatically search sub categories");
		userSearchPage.selectAdvancedSearchDropdown("Manufacturer", "Apple");
		userSearchPage.clickToSearchButton();
		Assert.assertEquals(userSearchPage.getNumberOfProduct(), 1);
		Assert.assertEquals(userSearchPage.getTextOfNameProduct(), "Apple MacBook Pro 13-inch");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
