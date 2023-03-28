package pageObject.facebook.login;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.login.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToCreateNewAccount() {
		waitForElementClickable(LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public void sendkeyToEmailTextbox(String value) {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(LoginPageUI.EMAIL_TEXTBOX, value);
	}

	public boolean isConfirmEmailDisplay() {
		return isElementDisplayed(LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public boolean isConfirmEmailAddressUndisplay() {
		//waitForElementUndisplayed(LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementUndisplay(LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToCloseButton() {
		waitForElementClickable(LoginPageUI.CLOSE_BUTTON);
		clickToElement(LoginPageUI.CLOSE_BUTTON);
	}

}
