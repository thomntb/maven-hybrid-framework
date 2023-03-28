package pageUIs.nopCommerce.user;

public class MyProductReviewPageUI {

	public static final String REVIEW_TITLE_TEXTBOX = "xpath=//label[contains(text(),'Review title')]/following-sibling::input";
	public static final String REVIEW_TEXT_TEXTAREA = "xpath=//label[contains(text(),'Review text')]/following-sibling::textarea";
	public static final String SUBMIT_REVIEW_BUTTON = "xpath=//button[text()='Submit review']";
	public static final String REVIEW_TEXT_CONTENT = "xpath=//div[@class='review-text']";
	public static final String REVIEW_PRODUCT_NAME_CONTENT = "xpath=//div[@class='review-info']/span/a";
}
