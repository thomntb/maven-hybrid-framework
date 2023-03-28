package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.SearchPageUI;

public class UserSearchPageObject extends BasePage {

	private WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(SearchPageUI.SEARCH_BUTTON);
		clickToElement(SearchPageUI.SEARCH_BUTTON);
	}

	public String getSearchErrorMessage() {
		waitForElementVisible(SearchPageUI.ERROR_SEARCH_MESSAGE);
		return getTextElement(SearchPageUI.ERROR_SEARCH_MESSAGE);
	}

	public void sendkeyToSeachTextbox(String textValue) {
		waitForElementVisible(SearchPageUI.SEARCH_INPUT_TEXTBOX);
		sendkeyToElement(SearchPageUI.SEARCH_INPUT_TEXTBOX, textValue);
	}

	public int getNumberOfProduct() {
		waitForElementVisible(SearchPageUI.NUMBER_LIST_PRODUCT);
		return getElementSize(SearchPageUI.NUMBER_LIST_PRODUCT);
	}

	public String getTextOfNameProduct() {
		waitForElementVisible(SearchPageUI.NAME_PRODUCT);
		return getTextElement(SearchPageUI.NAME_PRODUCT);
	}

	public void selectAdvancedSearchCheckbox(String advancedSearchCheckbox) {
		waitForElementClickable(SearchPageUI.SEARCH_ADVANCED_CHECKBOX, advancedSearchCheckbox);
		checkTheCheckboxOrRadio(SearchPageUI.SEARCH_ADVANCED_CHECKBOX, advancedSearchCheckbox);
	}

	public void selectAdvancedSearchDropdown(String advancedSearchDropdown, String textValue) {
		waitForElementClickable(SearchPageUI.SEARCH_ADVANCED_DROPDOWN, advancedSearchDropdown);
		selectItemInDropdown(SearchPageUI.SEARCH_ADVANCED_DROPDOWN, textValue, advancedSearchDropdown);
	}

	public String getMinTextSearchErrorMessage() {
		waitForElementVisible(SearchPageUI.MIN_TEXT_ERROR_SEARCH_MESSAGE);
		return getTextElement(SearchPageUI.MIN_TEXT_ERROR_SEARCH_MESSAGE);
	}
	
}
