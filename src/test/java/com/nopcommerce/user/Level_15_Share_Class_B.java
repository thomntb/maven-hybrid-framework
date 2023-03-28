package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register_Cookies;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_15_Share_Class_B extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userLoginPage = userHomePage.clickToLoginLink();
		
		userLoginPage.setCookies(Common_Register_Cookies.loggedCookies);
		userLoginPage.sleepInSecond(2);
		userLoginPage.refreshPage();
		
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Search_01() {
	}
	
	@Test
	public void Search_02() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
