//package com.nopcommerce.user;
//
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserLoginPageObject;
//import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentManagerV5;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//
//public class Level_14_Extend_Report_V2 extends BaseTest {
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
//		ExtentManagerV5.startTest(method.getName(), "TC_01_Register");
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 01: Click to 'Register' link");
//		userHomePage.clickToRegisterLink();
//		
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 02: Navigate to Register page");
//		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
//		
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 03: Input to First name is '" +firstName+ "'");
//		userRegisterPage.inputToFirstNameTextBox(firstName);
//		
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 04: Input to Last name is '" +lastName+ "'");
//		userRegisterPage.inputToLastNameTextBox(lastName);
//		
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 05: Input to Email is '" +emailUser+ "'");
//		userRegisterPage.inputToEmailTextBox(emailUser);
//		
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 06: Input to password is '" +passwordUser+ "'");
//		userRegisterPage.inputToPasswordTextBox(passwordUser);
//		
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 07: Input to password is '" +passwordUser+ "'");
//		userRegisterPage.inputToConfirmTextBox(passwordUser);
//
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 08: Click to 'Register' button");
//		userRegisterPage.clickToRegisterButton();
//		
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 09: Verify Register success message");
//		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed...");
//
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Register - Step 10: Click to 'Continue' button");
//		userHomePage = userRegisterPage.clickToContinueButton();
//		ExtentManagerV5.endTest();
//		// registerPage.clickToLogoutButton();
//	}
//	
//	@Test
//	public void TC_02_Login_System(Method method) {
//		ExtentManagerV5.startTest(method.getName(), "TC_02_Login");
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Login - Step 01: Click to 'Login' link");
//		userLoginPage = userHomePage.clickToLoginLink();
//		
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Login - Step 02: Login with Email is: '" +emailUser+ "'" + " and Password is: '" +passwordUser+ "'");
//		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
//		
//		ExtentManagerV5.getTest().log(LogStatus.INFO, "Login - Step 03: Click to 'My Account' link");
//		Assert.assertFalse(userHomePage.isMyAccountLinkDisplayed(driver));
//		ExtentManagerV5.endTest();
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//}
