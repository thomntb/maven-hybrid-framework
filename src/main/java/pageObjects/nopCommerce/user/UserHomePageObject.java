package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserHomePageObject extends BasePage {

	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	
	public boolean isRegisterLinkDisplayed() {
		waitForElementVisible(HomePageUI.REGISTER_LINK);
		return isElementDisplayed(HomePageUI.REGISTER_LINK);
	}
	
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public void scrollFeatureProductTitle() {
		waitForElementVisible(HomePageUI.FEATURE_PRODUCT_TITLE);
		scrollToElement(HomePageUI.FEATURE_PRODUCT_TITLE);
	}
	
	public UserProductDetailPageObject clickToProductTitleLink(String productTitleName) {
		waitForElementClickable(HomePageUI.PRODUCT_NAME_TITLE_LINK, productTitleName);
		clickToElement(HomePageUI.PRODUCT_NAME_TITLE_LINK, productTitleName);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public void clickToCompareProductButton(String productName, String buttonType) {
		waitForElementClickable(HomePageUI.ALL_BUTTON_OF_PRODUCT, productName, buttonType);
		clickToElement(HomePageUI.ALL_BUTTON_OF_PRODUCT, productName, buttonType);
	}

	public String getSuccessMessageAddToCompareList() {
		waitForElementVisible(HomePageUI.COMPARE_PRODUCT_SUCCESS_MESSAGE);
		return getTextElement(HomePageUI.COMPARE_PRODUCT_SUCCESS_MESSAGE);
	}


}
