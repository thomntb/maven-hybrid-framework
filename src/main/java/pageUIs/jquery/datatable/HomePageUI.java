package pageUIs.jquery.datatable;

public class HomePageUI {

	public static final String PAGINATION_PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_SELECTED_PAGE = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "xpath=//li[@class='qgrd-pagination-page']";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALL_COLUMN_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='%s']";
	//public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	
	public static final String COLUM_INDEX_BY_NAME = "XPATH=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String LOAD_DATA_BUTTON = "xpath=//button[@id='load']";
	public static final String TEXTBOX_BY_ROW_AND_COLUM_NAME = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_ROW_AND_COLUM_NAME = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String RADIO_BY_ROW_AND_COLUM_NAME = "xpath=//tbody/tr[%S]/td[%S]//input";
	public static final String ICON_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]/td//button[@title='%s']";
	
}
