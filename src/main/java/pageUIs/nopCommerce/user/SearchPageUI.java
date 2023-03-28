package pageUIs.nopCommerce.user;

public class SearchPageUI {
	public static final String SEARCH_INPUT_TEXTBOX = "xpath=//input[@class='search-text']";
	public static final String SEARCH_BUTTON = "xpath=//div[@class='fieldset']/following-sibling::div/button[@type='submit']";
	public static final String ERROR_SEARCH_MESSAGE = "xpath=//div[@class='search-results']//div[@class='no-result']";
	public static final String NUMBER_LIST_PRODUCT = "xpath=//div[@class='product-item']";
	public static final String NAME_PRODUCT = "xpath=//h2[@class='product-title']/a";
	public static final String SEARCH_ADVANCED_CHECKBOX = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String SEARCH_ADVANCED_DROPDOWN = "xpath=//label[contains(text(),'%s')]/parent::div/select";
	public static final String MIN_TEXT_ERROR_SEARCH_MESSAGE = "xpath=//div[@class='search-results']//div[@class='warning']";
	
}
