package com.nopcommerce.common;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Common_Register_Cookies extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName;
	public static String emailUser, passwordUser;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	public static Set<Cookie> loggedCookies;
	
	@Parameters("browser")
	@BeforeTest
	public void Register_User(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailUser = "automation" + randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		passwordUser = "123456";
		
		log.info("Precondition - Step 01: Click to 'Register' link");
		userHomePage.clickToRegisterLink();
		
		log.info("Precondition - Step 02: Navigate to Register page");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Precondition - Step 03: Input to First name is '" +firstName+ "'");
		userRegisterPage.inputToFirstNameTextBox(firstName);
		
		log.info("Precondition - Step 04: Input to Last name is '" +lastName+ "'");
		userRegisterPage.inputToLastNameTextBox(lastName);
		
		log.info("Precondition - Step 05: Input to Email is '" +emailUser+ "'");
		userRegisterPage.inputToEmailTextBox(emailUser);
		
		log.info("Precondition - Step 06: Input to password is '" +passwordUser+ "'");
		userRegisterPage.inputToPasswordTextBox(passwordUser);
		
		log.info("Precondition - Step 07: Input to password is '" +passwordUser+ "'");
		userRegisterPage.inputToConfirmTextBox(passwordUser);

		log.info("Precondition - Step 08: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Precondition - Step 09: Verify Register success message");
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Precondition - Step 10: Click to 'Continue' button");
		userHomePage = userRegisterPage.clickToContinueButton();
		
		log.info("Precondition - Step 11: Click to 'Login' link");
		userLoginPage = userHomePage.clickToLoginLink();
		
		log.info("Precondition - Step 12: Login with Email is: '" +emailUser+ "'" + " and Password is: '" +passwordUser+ "'");
		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
		
		log.info("Precondition - Step 13: Click to 'My Account' link");
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());
		
		loggedCookies= userRegisterPage.getAllCookies();
		
		driver.quit();
	}
}
