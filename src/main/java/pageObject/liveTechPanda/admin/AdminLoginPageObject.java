package pageObject.liveTechPanda.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.liveTechPanda.user.PageGeneratorManager;
import pageUIs.liveTechPanda.admin.LoginPageUI;

public class AdminLoginPageObject extends BasePage{

	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void sendkeyToLoginInputTextbox(String inputType, String textValue) {
		waitForElementVisible(LoginPageUI.LOGIN_INPUT_TEXTBOX, inputType);
		sendkeyToElement(LoginPageUI.LOGIN_INPUT_TEXTBOX, textValue, inputType);
	}

	public AdminHomePageObject clickToLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminHomePage(driver);
	}
}
