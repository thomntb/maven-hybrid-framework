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
//public class Level_02_Apply_BasePage_III extends BasePage{
//
//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	String emailText;
//
//	@BeforeClass
//	public void beforeClass() {
//
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		
//		emailText = "automation" + randomNumber() + "@gmail.com";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		driver.get("https://demo.nopcommerce.com/");
//	}
//
//	@Test
//	public void TC_01_Register_Empty_Data() {
//		waitForElementClickable("//a[@class='ico-register']");
//		clickToElement("//a[@class='ico-register']");
//		
//		waitForElementClickable("//button[@id='register-button']");
//		clickToElement("//button[@id='register-button']");
//		
//		Assert.assertEquals(getTextElement( "//span[@id='FirstName-error']"), "First name is required.");
//		Assert.assertEquals(getTextElement("//span[@id='LastName-error']"), "Last name is required.");
//		Assert.assertEquals(getTextElement("//span[@id='Email-error']"), "Email is required.");
//		Assert.assertEquals(getTextElement("//span[@id='Password-error']"), "Password is required.");
//		Assert.assertEquals(getTextElement("//span[@id='ConfirmPassword-error']"), "Password is required.");
//	}
//
//	@Test
//	public void TC_02_Register_Invalid_Email() {
//		waitForElementClickable("//a[@class='ico-register']");
//		clickToElement("//a[@class='ico-register']");
//
//		sendkeyToElement("//input[@id='FirstName']", "Automation");
//		sendkeyToElement("//input[@id='LastName']", "Nguyen");
//		sendkeyToElement("//input[@id='Email']", "abc@kjfsk");
//		sendkeyToElement("//input[@id='Password']", "123456");
//		sendkeyToElement("//input[@id='ConfirmPassword']", "123456");
//
//		waitForElementClickable("//button[@id='register-button']");
//		clickToElement("//button[@id='register-button']");
//
//		Assert.assertEquals(getTextElement("//div[@class='message-error validation-summary-errors']//li"), "Wrong email");
//	}
//
//	@Test
//	public void TC_03_Register_Success() {
//		waitForElementClickable("//a[@class='ico-register']");
//		clickToElement("//a[@class='ico-register']");
//
//		sendkeyToElement("//input[@id='FirstName']", "Automation");
//		sendkeyToElement("//input[@id='LastName']", "Nguyen");
//		sendkeyToElement("//input[@id='Email']", emailText);
//		sendkeyToElement("//input[@id='Password']", "123456");
//		sendkeyToElement("//input[@id='ConfirmPassword']", "123456");
//
//		waitForElementClickable("//button[@id='register-button']");
//		clickToElement("//button[@id='register-button']");
//
//		Assert.assertEquals(getTextElement("//div[@class='result']"), "Your registration completed");
//
//	}
//
//	@Test
//	public void TC_04_Register_Email_Exists() {
//		waitForElementClickable("//a[@class='ico-register']");
//		clickToElement("//a[@class='ico-register']");
//
//		sendkeyToElement("//input[@id='FirstName']", "Automation");
//		sendkeyToElement("//input[@id='LastName']", "Nguyen");
//		sendkeyToElement("//input[@id='Email']", emailText);
//		sendkeyToElement("//input[@id='Password']", "123456");
//		sendkeyToElement("//input[@id='ConfirmPassword']", "123456");
//
//		waitForElementClickable("//button[@id='register-button']");
//		clickToElement("//button[@id='register-button']");
//
//		Assert.assertEquals(getTextElement("//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");
//	}
//
//	@Test
//	public void TC_05_Register_Invalid_Password() {
//		waitForElementClickable("//a[@class='ico-register']");
//		clickToElement("//a[@class='ico-register']");
//
//		sendkeyToElement("//input[@id='FirstName']", "Automation");
//		sendkeyToElement("//input[@id='LastName']", "Nguyen");
//		sendkeyToElement("//input[@id='Email']", emailText);
//		sendkeyToElement("//input[@id='Password']", "123");
//		sendkeyToElement("//input[@id='ConfirmPassword']", "123");
//
//		Assert.assertEquals(getTextElement("//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
//	}
//
//	@Test
//	public void TC_06_Register_Invalid_Confirm_Password() {
//		waitForElementClickable("//a[@class='ico-register']");
//		clickToElement("//a[@class='ico-register']");
//
//		sendkeyToElement("//input[@id='FirstName']", "Automation");
//		sendkeyToElement("//input[@id='LastName']", "Nguyen");
//		sendkeyToElement("//input[@id='Email']", emailText);
//		sendkeyToElement("//input[@id='Password']", "123456");
//		sendkeyToElement("//input[@id='ConfirmPassword']", "123");
//
//		waitForElementClickable("//button[@id='register-button']");
//		clickToElement("//button[@id='register-button']");
//
//		Assert.assertEquals(getTextElement("//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//}
