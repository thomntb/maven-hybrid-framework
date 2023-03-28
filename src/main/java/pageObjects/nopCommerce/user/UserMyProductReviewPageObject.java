package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.MyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {

	private WebDriver driver;
	
	public UserMyProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendkeyToReviewTitleTextbox(String textValue) {
		waitForElementVisible(MyProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(MyProductReviewPageUI.REVIEW_TITLE_TEXTBOX, textValue);
	}
	
	public void sendkeyToReviewTextTextarea(String textValue) {
		waitForElementVisible(MyProductReviewPageUI.REVIEW_TEXT_TEXTAREA);
		sendkeyToElement(MyProductReviewPageUI.REVIEW_TEXT_TEXTAREA, textValue);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(MyProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(MyProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public String getReviewTextProduct() {
		waitForElementVisible(MyProductReviewPageUI.REVIEW_TEXT_CONTENT);
		return getTextElement(MyProductReviewPageUI.REVIEW_TEXT_CONTENT);
	}

	public String getProductNameAddReview() {
		waitForElementVisible(MyProductReviewPageUI.REVIEW_PRODUCT_NAME_CONTENT);
		return getTextElement(MyProductReviewPageUI.REVIEW_PRODUCT_NAME_CONTENT);
	}

}
