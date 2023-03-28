package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getErrorMessageUnsuccessfully() {
		waitForElementVisible(LoginPageUI.EMAIL_ERROR_UNSUCCESSFULLY_MESSAGE);
		return getTextElement(LoginPageUI.EMAIL_ERROR_UNSUCCESSFULLY_MESSAGE);
	}

	public UserHomePageObject loginAsUser(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
	
}
