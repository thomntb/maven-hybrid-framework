//package com.nopcommerce.user;
//
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.Status;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserLoginPageObject;
//import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentTestManagerV5;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//
//public class Level_14_Extend_Report_V5 extends BaseTest {
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
//	@Test
//	public void TC_01_Register_User(Method method) {
//		ExtentTestManagerV5.startTest(method.getName(), "Register user");
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Click to 'Register' link");
//		userHomePage.clickToRegisterLink();
//		
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Navigate to Register page");
//		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
//		
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Input to First name is '" +firstName+ "'");
//		userRegisterPage.inputToFirstNameTextBox(firstName);
//		
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04: Input to Last name is '" +lastName+ "'");
//		userRegisterPage.inputToLastNameTextBox(lastName);
//		
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 05: Input to Email is '" +emailUser+ "'");
//		userRegisterPage.inputToEmailTextBox(emailUser);
//		
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 06: Input to password is '" +passwordUser+ "'");
//		userRegisterPage.inputToPasswordTextBox(passwordUser);
//		
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 07: Input to password is '" +passwordUser+ "'");
//		userRegisterPage.inputToConfirmTextBox(passwordUser);
//
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 08: Click to 'Register' button");
//		userRegisterPage.clickToRegisterButton();
//		
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 09: Verify Register success message");
//		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
//
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 10: Click to 'Continue' button");
//		userHomePage = userRegisterPage.clickToContinueButton();
//		// registerPage.clickToLogoutButton();
//	}
//	
//	@Test
//	public void TC_02_Login_System(Method method) {
//		ExtentTestManagerV5.startTest(method.getName(), "Login user");
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 01: Click to 'Login' link");
//		userLoginPage = userHomePage.clickToLoginLink();
//		
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 02: Login with Email is: '" +emailUser+ "'" + " and Password is: '" +passwordUser+ "'");
//		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
//		
//		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 03: Click to 'My Account' link");
//		Assert.assertFalse(userHomePage.isMyAccountLinkDisplayed(driver));
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//}
