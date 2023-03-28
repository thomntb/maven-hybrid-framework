package pageUIs.nopCommerce.user;

public class WishListPageUI {

	public static final String WISHLIST_URL_LINK = "xpath=//div[@class='share-info']/a";
	public static final String TEXTBOX_BY_ROW_AND_COLUMN_NAME = "XPATH=//tbody/tr[%s]/td[%s]/a";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//thead/tr/th[contains(text(), '%s')]/preceding-sibling::th";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[@name='addtocartbutton']";
	public static final String ADD_TO_CART_CHECKBOX_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]/td[1]/input";
	public static final String REMOVE_BUTTON_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]/td/button[@class='remove-btn']";
	public static final String WISHLIST_TABLE_EMPTY_DATA_MESSAGE = "xpath=//div[@class='no-data']";
}
