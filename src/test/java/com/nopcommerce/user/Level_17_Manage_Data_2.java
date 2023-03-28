package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_17_Manage_Data_2 extends BaseTest {

	private WebDriver driver;
	private String emailUser, firstName, lastName, passwordUser, successMessage;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	
	@Parameters({"browser", "firstName","lastName","emailAddress","password","sucessMessage"})
	@BeforeClass
	public void beforeClass(String browser, String firstName, String lastName, String emailAddress, String password, String sucessMessage) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		this.emailUser = emailAddress + randomNumber() + "@gmail.com";
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordUser = password;
		this.successMessage = sucessMessage;
		 
	}

	@Test
	public void TC_01_Register_User() {
		userHomePage.clickToRegisterLink();
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);

		userRegisterPage.inputToFirstNameTextBox(this.firstName);
		userRegisterPage.inputToLastNameTextBox(this.lastName);
		userRegisterPage.inputToEmailTextBox(this.emailUser);
		userRegisterPage.inputToPasswordTextBox(this.passwordUser);
		userRegisterPage.inputToConfirmTextBox(this.passwordUser);

		userRegisterPage.clickToRegisterButton();
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(),this.successMessage);

		userHomePage = userRegisterPage.clickToContinueButton();
		// registerPage.clickToLogoutButton();
	}
	
	@Test
	public void TC_02_Login_System() {
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(this.emailUser, this.passwordUser);
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
