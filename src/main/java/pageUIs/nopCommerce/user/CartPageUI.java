package pageUIs.nopCommerce.user;

public class CartPageUI {

	public static final String CART_PAGE_TITLE = "xpath=//h1[text()='Shopping cart']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//thead/tr/th[contains(text(), '%s')]/preceding-sibling::th";
	public static final String TEXTBOX_BY_ROW_AND_COLUMN_NAME = "XPATH=//tbody/tr[%s]/td[%s]/a";
	public static final String PRODUCT_NAME = "XPATH=//td/a[@class='product-name']";
	public static final String PRODUCT_ATTRIBUTE = "XPATH=//td/a[@class='product-name']/following-sibling::div";
	public static final String PRODUCT_NAME_IN_HOVER = "xpath=//div[@class='header-links-wrapper']//div[@class='name']/a";
	public static final String PRODUCT_ATTRIBUTE_IN_HOVER = "xpath=//div[@class='header-links-wrapper']//div[@class='attributes']";
}
