package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.ProductDetailPageUI;
import pageUIs.nopCommerce.user.DesktopPageUI;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.ProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {

	private WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserMyProductReviewPageObject clickToAddYourReviewLink() {
		waitForElementClickable(ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public void clickToAddToWishlistButton(String overViewTypeButton) {
		waitForElementClickable(ProductDetailPageUI.OVERVIEW_BUTTON, overViewTypeButton);
		clickToElement(ProductDetailPageUI.OVERVIEW_BUTTON, overViewTypeButton);
	}

	public String getAddToWishlistSuccessMessage() {
		waitForAllElementVisible(ProductDetailPageUI.ADD_TO_WISHLIST_SUCCESS_MESSAGE);
		return getTextElement(ProductDetailPageUI.ADD_TO_WISHLIST_SUCCESS_MESSAGE);
	}

	public void selectValueProcessorDropdown(String processor) {
		waitForElementClickable(ProductDetailPageUI.PROCESSOR_DROPDOWN);
		selectItemInDropdown(ProductDetailPageUI.PROCESSOR_DROPDOWN, processor);
	}

	public void selectValueRamDropdown(String ram) {
		waitForElementClickable(ProductDetailPageUI.RAM_DROPDOWN);
		selectItemInDropdown(ProductDetailPageUI.RAM_DROPDOWN, ram);
	}

	public void chooseValueHddRadio(String hdd) {
		waitForElementClickable(ProductDetailPageUI.VALUE_RADIO_AND_CHECKBOX, hdd);
		checkTheCheckboxOrRadio(ProductDetailPageUI.VALUE_RADIO_AND_CHECKBOX, hdd);
	}

	public void chooseValueOsRadio(String os) {
		waitForElementClickable(ProductDetailPageUI.VALUE_RADIO_AND_CHECKBOX, os);
		checkTheCheckboxOrRadio(ProductDetailPageUI.VALUE_RADIO_AND_CHECKBOX, os);
	}

	public void chooseValueSoftwareCheckbox(String software) {
		waitForElementClickable(ProductDetailPageUI.VALUE_RADIO_AND_CHECKBOX, software);
		checkTheCheckboxOrRadio(ProductDetailPageUI.VALUE_RADIO_AND_CHECKBOX, software);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(ProductDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(ProductDetailPageUI.ADD_TO_CART_BUTTON);
	}

	public String isAddToCartMessageSuccess() {
		waitForElementVisible(ProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
		return getTextElement(ProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
	}
	
	public void clickToCloseNotificationMessage() {
		waitForElementClickable(ProductDetailPageUI.CLOSE_NOTIFICATION_MESSAGE);
		clickToElement(ProductDetailPageUI.CLOSE_NOTIFICATION_MESSAGE);
	}
	
	public String getProductTitleName() {
		waitForElementVisible(ProductDetailPageUI.PRODUCT_NAME_WHEN_HOVER_SHOPPING_CART);
		return getTextElement(ProductDetailPageUI.PRODUCT_NAME_WHEN_HOVER_SHOPPING_CART);
	}

	public boolean isShoppingCartTextDisplayed(String valueEqual) {
		waitForElementVisible(ProductDetailPageUI.PRODUCT_ATTRIBUTE_WHEN_HOVER_SHOPPING_CART);
		String text = getTextElement(ProductDetailPageUI.PRODUCT_ATTRIBUTE_WHEN_HOVER_SHOPPING_CART);
		String[] subString = text.split("\n");
		for (int i = 0; i < subString.length; i++) {
			if (valueEqual.contains(subString[i])) {
				break;
			}
		}
		return true;
	}
}
