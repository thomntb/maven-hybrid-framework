package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {

	private WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToTilteTextbox(String tiltleTextbox) {
		waitForElementVisible(AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(AdminPostAddNewPageUI.TITLE_TEXTBOX, tiltleTextbox);
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public boolean isgetPostAddNewOrUpdateSuccessMessage(String message) {
		waitForElementVisible(AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_SUCCESS_MESSAGE, message);
		return isElementDisplayed(AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_SUCCESS_MESSAGE, message);
	}

	public AdminPostSearchPO openPostSearchPageUrl(String urlPostSearch) {
		openPageUrl(urlPostSearch);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

	public void enterToBodyTextbox(String bodyTextbox) {
		waitForElementClickable(AdminPostAddNewPageUI.BODY_TEXTBOX_BEFORE_CLICK);
		clickToElement(AdminPostAddNewPageUI.BODY_TEXTBOX_BEFORE_CLICK);
		
		waitForElementVisible(AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK);
		sendkeyToElement(AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK, bodyTextbox);
	}

	public void enterToEditBodyTextbox(String editBodyTextbox) {
		waitForElementClickable(AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK);
		clickToElement(AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK);
		
		waitForElementVisible(AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK);
		clearValueElementByPressKey(AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK);
		sendkeyToElement(AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK, editBodyTextbox);
	}

}
