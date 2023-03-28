package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {

	public static final String USER_LOGOUT_BUTTON = "xpath=//a[@class='ico-logout']";
	public static final String ADMIN_LOGOUT_BUTTON = "xpath=//a[text()='Logout']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String HEADER_LOGO_LINK = "XPATH=//div[@class='header-logo']/a";
	public static final String CURRENCY_CUSTOMER = "css=#customerCurrency";
	public static final String SHOOPING_CART_LINK = "xpath=//a[@class='ico-cart']";
	
	public static final String CUSTOMER_LINK = "xpath=//li[contains(@class,'customer-info')]/a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "xpath=//li[contains(@class,'customer-addresses')]/a[text()='Addresses']";
	public static final String ODERS_LINK = "xpath=//li[contains(@class,'customer-orders')]/a[text()='Orders']";
	public static final String DOWNLOADABLE_PRODUCT_LINK = "xpath=//li[contains(@class,'downloadable-products')]/a[text()='Downloadable products']";
	public static final String BACK_IN_STOCK_SUBSCRIPTION_LINK = "xpath=//li[contains(@class,'back-in-stock-subscriptions')]/a[text()='Back in stock subscriptions']";
	public static final String REWARD_POINT_LINK = "xpath=//li[contains(@class,'reward-points')]/a[text()='Reward points']";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//li[contains(@class,'change-password')]/a[text()='Change password']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//li[contains(@class,'customer-reviews')]/a[text()='My product reviews']";
	
	public static final String OPEN_DYNAMIC_PAGE_AT_MY_ACCOUNT = "xpath=//div[contains(@class,'account-navigation')]//li/a[text()='%s']";
	public static final String MENU_AT_FOOTER_LINK = "xpath=//div[@class='footer']//ul/li/a[text()='%s']";
	
	public static final String TOP_HEADER_MENU_LINK = "xpath=//div/ul[@class='top-menu notmobile']/li/a[contains(text(),'%s')]";
	public static final String SUB_MENU_TOP_HEADER_MENU_LINK = "xpath=//div/ul[@class='top-menu notmobile']/li/a[contains(text(),'%s')]/following-sibling::ul/li/a[contains(text(),'%s')]";
	
}
