package com.live.techpanda.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveTechPanda.admin.AdminHomePageObject;
import pageObject.liveTechPanda.admin.AdminLoginPageObject;
import pageObject.liveTechPanda.user.GlobalContants;
import pageObject.liveTechPanda.user.PageGeneratorManager;
import pageObject.liveTechPanda.user.UserDashboardPageObject;
import pageObject.liveTechPanda.user.UserHomePageObject;
import pageObject.liveTechPanda.user.UserLoginPageObject;
import pageObject.liveTechPanda.user.UserRegisterPageObject;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class User_01_Register extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserDashboardPageObject userDashboardPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminHomePageObject adminHomePage;
	private String firstName, lastName, email, password, adminUserName, adminPassword;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = getBrowserDriver(browser, url);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Thom";
		lastName = "Nguyen Bich";
		email = "thomafc" + randomNumber() + "@gmail.com";
		password = "123456";
		adminUserName = "user01";
		adminPassword = "guru99com";
	}

	@Test
	public void Register_01() {
		userLoginPage = userHomePage.clickToMyAccountLinkAtFooter();
		userRegisterPage = userLoginPage.clickToCreateAnAccountButton();
		
		userRegisterPage.sendkeyToRegisterInputTextbox("firstname", firstName);
		userRegisterPage.sendkeyToRegisterInputTextbox("lastname", lastName);
		userRegisterPage.sendkeyToRegisterInputTextbox("email", email);
		userRegisterPage.sendkeyToRegisterInputTextbox("password", password);
		userRegisterPage.sendkeyToRegisterInputTextbox("confirmation", password);
		
		userRegisterPage.clickToSignUpForNewsLetterCheckbox();
		userDashboardPage = userRegisterPage.clickToRegisterButton();
		Assert.assertTrue(userDashboardPage.isTitleDashboardDisplayed());
	}
	
	@Test
	public void Switch_Role_Admin() {
		userDashboardPage.openPageUrl(GlobalContants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminLoginPage.sendkeyToLoginInputTextbox("username", adminUserName);
		adminLoginPage.sendkeyToLoginInputTextbox("login", adminPassword);
		
		adminHomePage = adminLoginPage.clickToLoginButton();
		adminHomePage.closePopupDisplayed();
		
		adminHomePage.sendkeyToFilterTextboxByColumnNumber("Email", email);
		adminHomePage.clickToSearchButton();
		adminHomePage.sleepInSecond(2);
		Assert.assertEquals(adminHomePage.getTextByRowAndColumnNumber("Email", "1"), email);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
