package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory{
	private WebDriver driver;

	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//a[contains(@class, 'continue-button')]")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextbox;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']//li")
	private WebElement invalidEmailErrorMessage;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']//li")
	private WebElement existingEmailErrorMessage;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstNameTextBox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getTextElement(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getTextElement(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getTextElement(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getTextElement(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getTextElement(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void inputToConfirmTextBox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getTextElement(driver, registerSuccessMessage);
	}

	public String getErrorMessageInvalidAndExistingEmail() {
		waitForElementVisible(driver, invalidEmailErrorMessage);
		return getTextElement(driver, invalidEmailErrorMessage);
	}

	public void clickToLogoutButton() {
		waitForElementVisible(driver, logoutButton);
		clickToElement(driver, logoutButton);
	}

	public void clickToContinueButton() {
		waitForElementVisible(driver, continueButton);
		clickToElement(driver, continueButton);
	}
}
