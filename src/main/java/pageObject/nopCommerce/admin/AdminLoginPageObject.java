package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;
import pageUIs.nopCommerce.user.LoginPageUI;

public class AdminLoginPageObject extends BasePage {

	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(AdminLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public AdminDashboardsPageObject clickToLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashbroadsPage(driver);
	}

	public AdminDashboardsPageObject loginAsAdmin(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
}
