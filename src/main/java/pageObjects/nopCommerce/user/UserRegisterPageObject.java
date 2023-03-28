package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFirstNameTextBox() {
		waitForElementVisible(RegisterPageUI.FIRST_NAME_ERROR_MESSAGES);
		return getTextElement(RegisterPageUI.FIRST_NAME_ERROR_MESSAGES);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(RegisterPageUI.LAST_NAME_ERROR_MESSAGES);
		return getTextElement(RegisterPageUI.LAST_NAME_ERROR_MESSAGES);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(RegisterPageUI.EMAIL_ERROR_MESSAGES);
		return getTextElement(RegisterPageUI.EMAIL_ERROR_MESSAGES);
	}

	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(RegisterPageUI.PASSWORD_ERROR_MESSAGES);
		return getTextElement(RegisterPageUI.PASSWORD_ERROR_MESSAGES);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGES);
		return getTextElement(RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGES);
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmTextBox(String confirmPassword) {
		waitForElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getTextElement(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getErrorMessageInvalidAndExistingEmail() {
		waitForElementVisible(RegisterPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return getTextElement(RegisterPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	}

	public UserHomePageObject clickToContinueButton() {
		waitForElementVisible(RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(RegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
