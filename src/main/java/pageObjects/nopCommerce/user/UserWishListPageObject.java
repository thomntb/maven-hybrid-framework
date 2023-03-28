package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.WishListPageUI;

public class UserWishListPageObject extends BasePage {

	private WebDriver driver;

	public UserWishListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickWishlistURLLink() {
		waitForElementClickable(WishListPageUI.WISHLIST_URL_LINK);
		clickToElement(WishListPageUI.WISHLIST_URL_LINK);
	}

	public String getValueTableByRowAndColumnName(String columnName, String rowNumber) {
		int columnIndex = getElementSize(WishListPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return getTextElement(WishListPageUI.TEXTBOX_BY_ROW_AND_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
	}

	public UserCartPageObject clickToAddToCardButton() {
		waitForElementClickable(WishListPageUI.ADD_TO_CART_BUTTON);
		clickToElement(WishListPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getUserCartPage(driver);
	}

	public void clickToAddToCartCheckboxByRowNumber(String rowNumber) {
		waitForElementClickable(WishListPageUI.ADD_TO_CART_CHECKBOX_BY_ROW_NUMBER, rowNumber);
		checkTheCheckboxOrRadio(WishListPageUI.ADD_TO_CART_CHECKBOX_BY_ROW_NUMBER, rowNumber);
	}

	public void clickToRemoveButtonByRowNumber(String rowNumber) {
		waitForElementClickable(WishListPageUI.REMOVE_BUTTON_BY_ROW_NUMBER, rowNumber);
		clickToElement(WishListPageUI.REMOVE_BUTTON_BY_ROW_NUMBER, rowNumber);
	}

	public String getEmptyDataMessage() {
		waitForAllElementVisible(WishListPageUI.WISHLIST_TABLE_EMPTY_DATA_MESSAGE);
		return getTextElement(WishListPageUI.WISHLIST_TABLE_EMPTY_DATA_MESSAGE);
	}

}
