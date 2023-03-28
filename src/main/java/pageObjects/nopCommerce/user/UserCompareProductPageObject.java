package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CompareProductPageUI;

public class UserCompareProductPageObject extends BasePage {

	private WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToClearListButton() {
		waitForElementClickable(CompareProductPageUI.CLEAR_LIST_BUTTON);
		clickToElement(CompareProductPageUI.CLEAR_LIST_BUTTON);
	}

	public String getErrorMessageNoDataCompare() {
		waitForElementVisible(CompareProductPageUI.ERROR_MESSAGE_NO_DATA_COMPARE);
		return getTextElement(CompareProductPageUI.ERROR_MESSAGE_NO_DATA_COMPARE);
	}
}
