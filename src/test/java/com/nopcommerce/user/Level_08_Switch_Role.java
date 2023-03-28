package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.admin.AdminDashboardsPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_08_Switch_Role extends BaseTest {

	private WebDriver driver;
	private String emailUser, firstName, lastName, passwordUser, emailAdmin, passwordAdmin;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerPageObject userCustomerPage;
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
	public void TC_03_Switch_Page() {
		userCustomerPage = userHomePage.clickToMyAccountLink();
		userCustomerPage.openPageUrl(GlobalConstants.ADMIN_PAGE_URL);
		
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashboardsPage = adminLoginPage.loginAsAdmin(emailAdmin, passwordAdmin);
		
		adminLoginPage = adminDashboardsPage.clickToAdminLogoutButton();
		
		adminLoginPage.openPageUrl(GlobalConstants.DEV_PAGE_URL);
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
		userLoginPage.isMyAccountLinkDisplayed();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
