//package com.nopcommerce.user;
//
//import org.testng.annotations.Test;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserLoginPageObject;
//import pageObjects.nopCommerce.user.UserRegisterPageObject;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//
//public class Level_14_Allure_Report extends BaseTest {
//
//	private WebDriver driver;
//	private String emailUser, firstName, lastName, passwordUser;
//	private UserHomePageObject userHomePage;
//	private UserRegisterPageObject userRegisterPage;
//	private UserLoginPageObject userLoginPage;
//	
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browser) {
//		driver = getBrowserDriver(browser);
//		userHomePage = PageGeneratorManager.getUserHomePage(driver);
//
//		emailUser = "automation" + userHomePage.randomNumber() + "@gmail.com";
//		firstName = "Automation";
//		lastName = "Nguyen";
//		passwordUser = "123456";
//		
//	}
//
//	@Description("Register to system")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TC_01_Register_User() {
//		
//		userHomePage.clickToRegisterLink();
//		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
//		userRegisterPage.inputToFirstNameTextBox(firstName);
//		userRegisterPage.inputToLastNameTextBox(lastName);
//		userRegisterPage.inputToEmailTextBox(emailUser);
//		userRegisterPage.inputToPasswordTextBox(passwordUser);
//		userRegisterPage.inputToConfirmTextBox(passwordUser);
//		userRegisterPage.clickToRegisterButton();
//		
//		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
//		userHomePage = userRegisterPage.clickToContinueButton();
//		// registerPage.clickToLogoutButton();
//	}
//	
//	@Description("Login to system")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TC_02_Login_System() {
//		userLoginPage = userHomePage.clickToLoginLink();
//		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
//		
//		Assert.assertFalse(userHomePage.isMyAccountLinkDisplayed(driver));
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//}
