package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_05_Page_Factory extends BaseTest {

	private WebDriver driver;
	private String correctEmail, incorrectEmail, invalidEmail, firstName, lastName, correctPassword, incorrectPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		homePage = new HomePageObject(driver);
		
		correctEmail = "automation" + randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		correctPassword = "123456";
		incorrectPassword = "658594";
		incorrectEmail = "automation" + randomNumber() + "@gmail.vn";
		invalidEmail = "auto@398923@fjd";
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(correctEmail);
		registerPage.inputToPasswordTextBox(correctPassword);
		registerPage.inputToConfirmTextBox(correctPassword);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		registerPage.clickToContinueButton();
		//registerPage.clickToLogoutButton();
		homePage = new pageFactory.nopCommerce.HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Login_03_Incorrect_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(incorrectEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Exist_Email_Empty_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(correctEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Exist_Email_Incorrect_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(correctEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_06_Login_Success() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(correctEmail);
		loginPage.inputToPasswordTextbox(correctPassword);
		
		loginPage.clickToLoginButton();
		
		homePage = new pageFactory.nopCommerce.HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
