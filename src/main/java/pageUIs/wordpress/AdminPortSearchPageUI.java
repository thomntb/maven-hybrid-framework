package pageUIs.wordpress;

public class AdminPortSearchPageUI {

	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
	public static final String SEARCH_POST_BUTTON = "css=input#search-submit";
	public static final String HEADER_TABLE_INDEX_BY_ID_HEADER = "xpath=//table/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX= "xpath=//table/tbody/tr/*[%s]";
	public static final String ROW_VALUE_BY_NAME_VALUE = "xpath=//table/tbody/tr/td//a[text()='%s']";
	public static final String ROW_ACTION_HOVER_MOUSE = "xpath=//table/tbody/tr/td//a[text()='%s']/parent::strong/following-sibling::div[@class='row-actions']/span/a[text()='%s']";
	public static final String NO_FOUND_DATA_MESSAGE = "xpath=//tbody/tr[@class='no-items']/td[text()='%s']";
}
