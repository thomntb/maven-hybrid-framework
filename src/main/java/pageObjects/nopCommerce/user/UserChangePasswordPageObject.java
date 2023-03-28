package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.ChangePasswordPageUI;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserChangePasswordPageObject extends BasePage {

	private WebDriver driver;
	
	public UserChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendkeyToChangePasswordTextbox(String inputType, String textValue) {
		waitForElementVisible(ChangePasswordPageUI.CHANGE_PASSWORD_TEXTBOX, inputType);
		sendkeyToElement(ChangePasswordPageUI.CHANGE_PASSWORD_TEXTBOX, textValue, inputType);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public boolean getSuccessMessageAfterChangePassword() {
		waitForElementVisible(ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		return isElementDisplayed(ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}

	public void clickToCloseIconSuccessMessage() {
		waitForElementClickable(ChangePasswordPageUI.CLOSE_ICON_CHANGE_PASSWORD_SUCCESS_MESSAGE);
		clickToElement(ChangePasswordPageUI.CLOSE_ICON_CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}

}
