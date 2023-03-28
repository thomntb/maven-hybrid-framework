package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_04_Page_Object_Multi_Browser extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);

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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
