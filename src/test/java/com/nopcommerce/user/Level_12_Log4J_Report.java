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

public class Level_12_Log4J_Report extends BaseTest {

	private WebDriver driver;
	private String emailUser, firstName, lastName, passwordUser;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailUser = "automation" + userHomePage.randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		passwordUser = "123456";
		
	}

	@Test
	public void TC_01_Register_User() {
		log.info("Register - Step 01: Click to 'Register' link");
		userHomePage.clickToRegisterLink();
		
		log.info("Register - Step 02: Navigate to Register page");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Register - Step 03: Input to First name is '" +firstName+ "'");
		userRegisterPage.inputToFirstNameTextBox(firstName);
		
		log.info("Register - Step 04: Input to Last name is '" +lastName+ "'");
		userRegisterPage.inputToLastNameTextBox(lastName);
		
		log.info("Register - Step 05: Input to Email is '" +emailUser+ "'");
		userRegisterPage.inputToEmailTextBox(emailUser);
		
		log.info("Register - Step 06: Input to password is '" +passwordUser+ "'");
		userRegisterPage.inputToPasswordTextBox(passwordUser);
		
		log.info("Register - Step 07: Input to password is '" +passwordUser+ "'");
		userRegisterPage.inputToConfirmTextBox(passwordUser);

		log.info("Register - Step 08: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register - Step 09: Verify Register success message");
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed...");

		log.info("Register - Step 10: Click to 'Continue' button");
		userHomePage = userRegisterPage.clickToContinueButton();
		// registerPage.clickToLogoutButton();
	}
	
	@Test
	public void TC_02_Login_System() {
		log.info("Login - Step 01: Click to 'Login' link");
		userLoginPage = userHomePage.clickToLoginLink();
		
		log.info("Login - Step 02: Login with Email is: '" +emailUser+ "'" + " and Password is: '" +passwordUser+ "'");
		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
		
		log.info("Login - Step 03: Click to 'My Account' link");
		verifyFalse(userHomePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
