package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;
import pageUIs.wordpress.UserSearchPostPageUI;

public class UserHomePO extends BasePage {

	private WebDriver driver;

	public UserHomePO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserPostDetailPO clickToPostTitle(String titleTextbox) {
		waitForElementClickable(UserHomePageUI.TITLE_POST_TEXT, titleTextbox);
		clickToElement( UserHomePageUI.TITLE_POST_TEXT, titleTextbox);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public boolean isPostInfoTitleDisplayByTitlePost(String titleTextbox) {
		waitForElementVisible( UserHomePageUI.TITLE_POST_TEXT, titleTextbox);
		sleepInSecond(2);
		return isElementDisplayed( UserHomePageUI.TITLE_POST_TEXT, titleTextbox);
	}

	public boolean isPostInfoBodyDisplayByTitlePost(String titleTextbox, String bodyTextbox) {
		waitForElementVisible( UserHomePageUI.BODY_POST_TEXT, titleTextbox, bodyTextbox);
		return isElementDisplayed( UserHomePageUI.BODY_POST_TEXT, titleTextbox, bodyTextbox);
	}

	public boolean isPostInfoAuthorDisplayByTitlePost(String titleTextbox, String author) {
		waitForElementVisible( UserHomePageUI.AUTHOR_POST_TEXT, titleTextbox, author);
		return isElementDisplayed( UserHomePageUI.AUTHOR_POST_TEXT, titleTextbox, author);
	}

	public boolean isPostInfoDateDisplayByTitlePost(String titleTextbox, String currentDay) {
		waitForElementVisible( UserHomePageUI.DATE_POST_TEXT, titleTextbox, currentDay);
		return isElementDisplayed( UserHomePageUI.DATE_POST_TEXT, titleTextbox, currentDay);
	}

	public void enterToSearchPostTextbox(String editTitleTextbox) {
		waitForElementVisible( UserHomePageUI.SEARCH_POST_TEXTBOX, editTitleTextbox);
		sendkeyToElement( UserHomePageUI.SEARCH_POST_TEXTBOX, editTitleTextbox);
	}

	public UserSearchPostPO clickToSearchPostButton() {
		waitForElementClickable(UserHomePageUI.SEARCH_POST_BUTTON);
		clickToElement( UserHomePageUI.SEARCH_POST_BUTTON);
		return PageGeneratorManager.getUserSearchPostPage(driver);
	}
}
