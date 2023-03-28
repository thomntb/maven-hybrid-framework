package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	private WebElement loginButton;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement emailErrorUnsuccessfullyMessage;
	
	@FindBy(xpath = "//input[@class='email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@class='password']")
	private WebElement passwordTextbox;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getTextElement(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public String getErrorMessageUnsuccessfully() {
		waitForElementVisible(driver, emailErrorUnsuccessfullyMessage);
		return getTextElement(driver, emailErrorUnsuccessfullyMessage);
	}
}
