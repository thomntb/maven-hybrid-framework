package pageUIs.nopCommerce.user;

public class ProductDetailPageUI {

	public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add your review']";
	public static final String ADD_TO_WISHLIST_SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']/p";
	public static final String WISHLIST_LINK = "xpath=//div[@class='bar-notification success']/p/a";
	public static final String OVERVIEW_BUTTON = "xpath=//div[@class='overview-buttons']//button[text()='%s']";
	public static final String PROCESSOR_DROPDOWN = "xpath=//select[@id='product_attribute_1']";
	public static final String RAM_DROPDOWN = "xpath=//select[@id='product_attribute_2']";
	public static final String VALUE_RADIO_AND_CHECKBOX = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String ADD_TO_CART_BUTTON = "css=button.button-1.add-to-cart-button";
	public static final String ADD_TO_CART_SUCCESS_MESSAGE = "xpath=//p[@class='content']";
	public static final String CLOSE_NOTIFICATION_MESSAGE = "xpath=//span[@class='close']";
	public static final String PRODUCT_NAME_WHEN_HOVER_SHOPPING_CART = "xpath=//div[@class='header-links-wrapper']//div[@class='name']/a";
	public static final String PRODUCT_ATTRIBUTE_WHEN_HOVER_SHOPPING_CART = "xpath=//div[@class='header-links-wrapper']//div[@class='attributes']";
}
