package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPortSearchPageUI;

public class AdminPostSearchPO extends BasePage {

	private WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getPostSearchUrl() {
		return getCurrentURLPage();
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(AdminPortSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(AdminPortSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void enterToSearchTextbox(String titleTextbox) {
		waitForElementVisible(AdminPortSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(AdminPortSearchPageUI.SEARCH_TEXTBOX, titleTextbox);
	}

	public void clickToSearchPostButton() {
		waitForElementClickable(AdminPortSearchPageUI.SEARCH_POST_BUTTON);
		clickToElement(AdminPortSearchPageUI.SEARCH_POST_BUTTON);
	}

	public String getPostSearchTable(String idHeader) {
		int index_column = getElementSize(AdminPortSearchPageUI.HEADER_TABLE_INDEX_BY_ID_HEADER, idHeader) + 1;
		return getTextElement(AdminPortSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(index_column));
	}

	public void clickToPostTitle(String rowValue) {
		waitForElementClickable(AdminPortSearchPageUI.ROW_VALUE_BY_NAME_VALUE, rowValue);
		clickToElement(AdminPortSearchPageUI.ROW_VALUE_BY_NAME_VALUE, rowValue);
	}

	public void hoverToPostTitle(String rowName) {
		waitForElementClickable(AdminPortSearchPageUI.ROW_VALUE_BY_NAME_VALUE, rowName);
		hoverMouseToElement(AdminPortSearchPageUI.ROW_VALUE_BY_NAME_VALUE, rowName);
	}

	public void clickToTrackLink(String rowName, String actionMouse) {
		waitForElementClickable(AdminPortSearchPageUI.ROW_ACTION_HOVER_MOUSE, rowName, actionMouse);
		clickToElement(AdminPortSearchPageUI.ROW_ACTION_HOVER_MOUSE, rowName, actionMouse);
	}

	public boolean isNoPostFoundDataMessageDisplay(String valueMessage) {
		waitForElementVisible(AdminPortSearchPageUI.NO_FOUND_DATA_MESSAGE, valueMessage);
		return isElementDisplayed(AdminPortSearchPageUI.NO_FOUND_DATA_MESSAGE, valueMessage);
	}


}
