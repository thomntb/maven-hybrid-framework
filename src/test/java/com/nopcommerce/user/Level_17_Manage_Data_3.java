package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_17_Manage_Data_3 extends BaseTest {

	private WebDriver driver;
	private String emailUser, firstName, lastName, passwordUser, successMessage;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailUser = UserData.Register.EMAIL_ADDRESS + userHomePage.randomNumber() + "@gmail.com";
		firstName = UserData.Register.FRIST_NAME;
		lastName = UserData.Register.LAST_NAME;
		passwordUser = UserData.Register.PASSWORD;
		successMessage = UserData.Register.SUCCESS_MESSAGE;
		 
	}

	@Test
	public void TC_01_Register_User() {
		userHomePage.clickToRegisterLink();
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);

		userRegisterPage.inputToFirstNameTextBox(firstName);
		userRegisterPage.inputToLastNameTextBox(lastName);
		userRegisterPage.inputToEmailTextBox(emailUser);
		userRegisterPage.inputToPasswordTextBox(passwordUser);
		userRegisterPage.inputToConfirmTextBox(passwordUser);

		userRegisterPage.clickToRegisterButton();
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(),successMessage);

		userHomePage = userRegisterPage.clickToContinueButton();
		// registerPage.clickToLogoutButton();
	}
	
	@Test
	public void TC_02_Login_System() {
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
