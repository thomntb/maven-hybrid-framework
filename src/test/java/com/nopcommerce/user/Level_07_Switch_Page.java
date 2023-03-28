package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptionPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_07_Switch_Page extends BaseTest {

	private WebDriver driver;
	private String email, firstName, lastName, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerPageObject customerPage;
	private UserAddressesPageObject addressesPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserBackInStockSubscriptionPageObject backInStockSubscriptionPage;
	private UserChangePasswordPageObject changePasswordPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		email = "automation" + randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		password = "123456";
	}

	@Test
	public void TC_01_Register_User() {
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(email);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmTextBox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToContinueButton();
		// registerPage.clickToLogoutButton();
	}
	
	@Test
	public void TC_02_Login_System() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void TC_03_Switch_Page() {
		customerPage = homePage.clickToMyAccountLink();
		addressesPage = customerPage.openAddressesPage();
		myProductReviewPage = addressesPage.openMyProductReviewPage();
		changePasswordPage = myProductReviewPage.openChangePasswordPage();
		addressesPage = changePasswordPage.openAddressesPage();
		customerPage = addressesPage.openCustomerPage();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
