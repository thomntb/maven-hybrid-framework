package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Level_03_Page_Object_Login {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String correctEmail, incorrectEmail, invalidEmail, firstName, lastName, correctPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);
		
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
		
		registerPage.clickToContinueButton();
		//registerPage.clickToLogoutButton();
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Login_03_Incorrect_Email() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(incorrectEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Exist_Email_Empty_Password() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(correctEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Exist_Email_Incorrect_Password() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(correctEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_06_Login_Success() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(correctEmail);
		loginPage.inputToPasswordTextbox(correctPassword);
		
		loginPage.clickToLoginButton();
		
		homePage = new UserHomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(99999);
	}

}
