package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage {

	private WebDriver driver;

	public UserPostDetailPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isPostInfoTitleDisplayByTitlePost(String titleTextbox) {
		waitForElementVisible(UserPostDetailPageUI.TITLE_POST_TEXT, titleTextbox);
		return isElementDisplayed(UserPostDetailPageUI.TITLE_POST_TEXT, titleTextbox);
	}

	public boolean isPostInfoBodyDisplayByTitlePost(String titleTextbox, String bodyTextbox) {
		waitForElementVisible(UserPostDetailPageUI.BODY_POST_TEXT, titleTextbox, bodyTextbox);
		return isElementDisplayed(UserPostDetailPageUI.BODY_POST_TEXT, titleTextbox, bodyTextbox);
	}

	public boolean isPostInfoAuthorDisplayByTitlePost(String titleTextbox, String author) {
		waitForElementVisible(UserPostDetailPageUI.AUTHOR_POST_TEXT, titleTextbox, author);
		return isElementDisplayed(UserPostDetailPageUI.AUTHOR_POST_TEXT, titleTextbox, author);
	}

	public boolean isPostInfoDateDisplayByTitlePost(String titleTextbox, String currentDay) {
		waitForElementVisible(UserPostDetailPageUI.DATE_POST_TEXT, titleTextbox, currentDay);
		return isElementDisplayed(UserPostDetailPageUI.DATE_POST_TEXT, titleTextbox, currentDay);
	}

}
