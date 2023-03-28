package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_06_Page_Generator_Manager extends BaseTest {

	private WebDriver driver;
	private String correctEmail, incorrectEmail, invalidEmail, firstName, lastName, correctPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		correctEmail = "automation" + randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		correctPassword = "123456";
		incorrectPassword = "658594";
		incorrectEmail = "automation" + randomNumber() + "@gmail.vn";
		invalidEmail = "auto@398923@fjd";

		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(correctEmail);
		registerPage.inputToPasswordTextBox(correctPassword);
		registerPage.inputToConfirmTextBox(correctPassword);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToContinueButton();
		// registerPage.clickToLogoutButton();
	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Login_03_Incorrect_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(incorrectEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Exist_Email_Empty_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(correctEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Exist_Email_Incorrect_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(correctEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_06_Login_Success() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(correctEmail);
		loginPage.inputToPasswordTextbox(correctPassword);
		
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
