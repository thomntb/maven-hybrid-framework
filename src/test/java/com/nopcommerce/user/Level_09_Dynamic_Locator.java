package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.admin.AdminDashboardsPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptionPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerPageObject;
import pageObjects.nopCommerce.user.UserDownloadableProductPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_09_Dynamic_Locator extends BaseTest {

	private WebDriver driver;
	private String emailUser, firstName, lastName, passwordUser, emailAdmin, passwordAdmin;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerPageObject userCustomerPage;
	private UserAddressesPageObject userAddressesPage;
	private UserOdersPageObject userOrderPage;
	private UserDownloadableProductPageObject userDownloadableProductPage;
	private UserBackInStockSubscriptionPageObject userBackInStockSubscription;
	private UserRewardPointPageObject userRewardPointPage;
	private UserChangePasswordPageObject userChangePasswordPage;
	private UserMyProductReviewPageObject userMyProductReviewPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardsPageObject adminDashboardsPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailUser = "automation" + randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		passwordUser = "123456";
		emailAdmin = "admin@yourstore.com";
		passwordAdmin = "admin";
	}

	@Test
	public void TC_01_Register_User() {
		userHomePage.clickToRegisterLink();
		userRegisterPage = new UserRegisterPageObject(driver);

		userRegisterPage.inputToFirstNameTextBox(firstName);
		userRegisterPage.inputToLastNameTextBox(lastName);
		userRegisterPage.inputToEmailTextBox(emailUser);
		userRegisterPage.inputToPasswordTextBox(passwordUser);
		userRegisterPage.inputToConfirmTextBox(passwordUser);

		userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickToContinueButton();
		// registerPage.clickToLogoutButton();
	}
	
	@Test
	public void TC_02_Login_System() {
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void TC_03_Dynamic_Page() {
		userCustomerPage = userHomePage.clickToMyAccountLink();
		userAddressesPage = (UserAddressesPageObject) userCustomerPage.openDynamicPageAtMyAccountByPageName("Addresses");
		userMyProductReviewPage = (UserMyProductReviewPageObject) userAddressesPage.openDynamicPageAtMyAccountByPageName("My product reviews");
		userChangePasswordPage = (UserChangePasswordPageObject) userMyProductReviewPage.openDynamicPageAtMyAccountByPageName("Change password");
		userAddressesPage = (UserAddressesPageObject) userChangePasswordPage.openDynamicPageAtMyAccountByPageName("Addresses");
		userCustomerPage = (UserCustomerPageObject) userAddressesPage.openDynamicPageAtMyAccountByPageName("Customer info");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
