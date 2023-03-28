package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.CartPageUI;

public class UserCartPageObject extends BasePage {
	private WebDriver driver;

	public UserCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getTextPageTitleCart() {
		waitForElementVisible(CartPageUI.CART_PAGE_TITLE);
		return isElementDisplayed(CartPageUI.CART_PAGE_TITLE);
	}

	public String getValueTableByRowAndColumnName(String columnName, String rowNumber) {
		int columnIndex = getElementSize(CartPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return getTextElement(CartPageUI.TEXTBOX_BY_ROW_AND_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
	}

	public String getProductTitleName() {
		waitForElementVisible(CartPageUI.PRODUCT_NAME);
		return getTextElement(CartPageUI.PRODUCT_NAME);
	}

	public boolean isProcessorNameDisplayed(String valueEqual) {
		waitForElementVisible(CartPageUI.PRODUCT_ATTRIBUTE);
		String text = getTextElement(CartPageUI.PRODUCT_ATTRIBUTE);
		String[] subString = text.split("\n");
		for (int i = 0; i < subString.length; i++) {
			if (valueEqual.equals(subString[0].substring(10).trim())) {
				return true;
			}
		}
		return false;
	}

	public boolean isRamNameDisplayed(String valueEqual) {
		waitForElementVisible(CartPageUI.PRODUCT_ATTRIBUTE);
		String text = getTextElement(CartPageUI.PRODUCT_ATTRIBUTE);
		String[] subString = text.split("\n");
		for (int i = 0; i < subString.length; i++) {
			if (valueEqual.equals(subString[1].substring(4).trim())) {
				return true;
			}
		}
		return false;
	}

	public boolean isHddNameDisplayed(String valueEqual) {
		waitForElementVisible(CartPageUI.PRODUCT_ATTRIBUTE);
		String text = getTextElement(CartPageUI.PRODUCT_ATTRIBUTE);
		String[] subString = text.split("\n");
		for (int i = 0; i < subString.length; i++) {
			if (valueEqual.equals(subString[2].substring(4).trim())) {
				return true;
			}
		}
		return false;
	}

	public boolean isOSNameDisplayed(String valueEqual) {
		waitForElementVisible(CartPageUI.PRODUCT_ATTRIBUTE);
		String text = getTextElement(CartPageUI.PRODUCT_ATTRIBUTE);
		String[] subString = text.split("\n");
		for (int i = 0; i < subString.length; i++) {
			if (valueEqual.equals(subString[3].substring(3).trim())) {
				return true;
			}
		}
		return false;
	}

	public boolean isSoftwareNameDisplayed(String valueEqual) {
		waitForElementVisible(CartPageUI.PRODUCT_ATTRIBUTE);
		String text = getTextElement(CartPageUI.PRODUCT_ATTRIBUTE);
		String[] subString = text.split("\n");
		for (int i = 0; i < subString.length; i++) {
			if (valueEqual.equals(subString[4].substring(9).trim())) {
				return true;
			}
		}
		return false;
	}

}
