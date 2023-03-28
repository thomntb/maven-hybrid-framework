package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Level_03_Page_Object_Register {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailText, firstName, lastName, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		emailText = "automation" + randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		password = "123456";
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("abc@kjfsk");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageInvalidAndExistingEmail(), "Wrong email");
	}

	@Test
	public void Register_03_Register_Success() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailText);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		// registerPage.clickToLogoutButton();
	}

	@Test
	public void Register_04_Email_Exists() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailText);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageInvalidAndExistingEmail(), "The specified email already exists");
	}

	@Test
	public void Register_05_Invalid_Password() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailText);
		registerPage.inputToPasswordTextBox("123");
		registerPage.inputToConfirmTextBox(password);

		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailText);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmTextBox(emailText);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "The password and confirmation password do not match.");
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
