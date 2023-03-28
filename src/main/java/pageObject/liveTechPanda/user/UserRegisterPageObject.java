package pageObject.liveTechPanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTechPanda.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {

	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendkeyToRegisterInputTextbox(String inputType, String textValue) {
		waitForElementVisible(RegisterPageUI.REGISTER_INPUT_TEXTBOX, inputType);
		sendkeyToElement(RegisterPageUI.REGISTER_INPUT_TEXTBOX, textValue, inputType);
	}
	
	public void clickToSignUpForNewsLetterCheckbox() {
		waitForElementClickable(RegisterPageUI.SIGN_UP_FOR_NEWSLETTER_CHECKBOX);
		checkTheCheckboxOrRadio(RegisterPageUI.SIGN_UP_FOR_NEWSLETTER_CHECKBOX);
	}

	public UserDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserDashboardPage(driver);
	}
	
}
