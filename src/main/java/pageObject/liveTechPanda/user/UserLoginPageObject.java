package pageObject.liveTechPanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTechPanda.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject clickToCreateAnAccountButton() {
		waitForElementClickable(LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	
}
