package pageObject.liveTechPanda.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTechPanda.admin.HomePageUI;

public class AdminHomePageObject extends BasePage{

	private WebDriver driver;

	public AdminHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void closePopupDisplayed() {
		waitForElementVisible(HomePageUI.INCOMMING_MESSAGE_POPUP);
		
		if(isElementDisplayed(HomePageUI.INCOMMING_MESSAGE_POPUP)) {
			clickToElement(HomePageUI.CLOSE_POPUP_BUTTON);
		}
	}
	
	public void sendkeyToFilterTextboxByColumnNumber(String columnName, String textValue) {
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(HomePageUI.FILTER_TEXTBOX_BY_COLUM_NAME, String.valueOf(columnIndex));
		sendkeyToElement(HomePageUI.FILTER_TEXTBOX_BY_COLUM_NAME, textValue, String.valueOf(columnIndex));
	}

	public void clickToSearchButton() {
		waitForElementVisible(HomePageUI.SEARCH_BUTTON);
		clickToElement(HomePageUI.SEARCH_BUTTON);
	}
	
	public String getTextByRowAndColumnNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(HomePageUI.TEXTBOX_BY_ROW_AND_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
		return getTextElement(HomePageUI.TEXTBOX_BY_ROW_AND_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
	}
}
