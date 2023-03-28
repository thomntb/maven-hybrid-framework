package com.nopcommerce.user;

import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Level_01_User_01_Register_DRY {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailText;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		emailText = "automation" + randomNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
		
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc@kjfsk");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']//li")).getText(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailText);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");

	}

	@Test
	public void TC_04_Register_Email_Exists() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailText);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']//li")).getText(), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Invalid_Password() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailText);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123");

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailText);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "The password and confirmation password do not match.");
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
