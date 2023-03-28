package com.facebook.login;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.login.LoginPageObject;
import pageObject.facebook.login.PageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_11_Element_Display_And_Undisplay extends BaseTest {

	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = getBrowserDriver(browser, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Element_Visible_And_In_Dom() {
		loginPage.clickToCreateNewAccount();
		loginPage.sendkeyToEmailTextbox("acf@gmail.com");
		loginPage.sleepInSecond(2);
		//verifyTrue(loginPage.isConfirmEmailDisplay());
	}

	@Test
	public void TC_02_Element_Undisplay_And_In_Dom() {
		loginPage.sendkeyToEmailTextbox("");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressUndisplay());
	}

	@Test
	public void TC_03_Element_Undisplay_And_Not_In_Dom() {
		loginPage.clickToCloseButton();
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressUndisplay());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
