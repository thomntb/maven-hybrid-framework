package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;
import pageUIs.wordpress.UserSearchPostPageUI;

public class UserSearchPostPO extends BasePage {

	private WebDriver driver;

	public UserSearchPostPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isNoSearchDataMessageDisplayed(String valueMessage) {
		waitForElementVisible(UserSearchPostPageUI.NO_FOUND_POST_DATA_MESSAGE, valueMessage);
		return isElementDisplayed(UserSearchPostPageUI.NO_FOUND_POST_DATA_MESSAGE, valueMessage);
	}

}
