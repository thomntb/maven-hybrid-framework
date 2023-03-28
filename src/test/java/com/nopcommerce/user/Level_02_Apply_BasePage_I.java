//package com.nopcommerce.user;
//
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class Level_02_Apply_BasePage_I {
//
//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	String emailText;
//	BasePage basePage;
//
//	@BeforeClass
//	public void beforeClass() {
//
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		basePage = new BasePage();
//		
//		emailText = "automation" + randomNumber() + "@gmail.com";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		driver.get("https://demo.nopcommerce.com/");
//	}
//
//	@Test
//	public void TC_01_Register_Empty_Data() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='FirstName-error']"), "First name is required.");
//		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='LastName-error']"), "Last name is required.");
//		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Email-error']"), "Email is required.");
//		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Password-error']"), "Password is required.");
//		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//	}
//
//	@Test
//	public void TC_02_Register_Invalid_Email() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", "abc@kjfsk");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getTextElement(driver, "//div[@class='message-error validation-summary-errors']//li"), "Wrong email");
//	}
//
//	@Test
//	public void TC_03_Register_Success() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailText);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getTextElement(driver, "//div[@class='result']"), "Your registration completed");
//
//	}
//
//	@Test
//	public void TC_04_Register_Email_Exists() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailText);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getTextElement(driver, "//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");
//	}
//
//	@Test
//	public void TC_05_Register_Invalid_Password() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailText);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
//
//		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
//	}
//
//	@Test
//	public void TC_06_Register_Invalid_Confirm_Password() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailText);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//	private int randomNumber() {
//		Random ran = new Random();
//		return ran.nextInt(99999);
//	}
//
//}
