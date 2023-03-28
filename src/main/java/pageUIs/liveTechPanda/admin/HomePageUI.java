package pageUIs.liveTechPanda.admin;

public class HomePageUI {

	public static final String CLOSE_POPUP_BUTTON = "xpath=//a[@title='close']";
	public static final String INCOMMING_MESSAGE_POPUP = "xpath=//div[@id='message-popup-window']";
	
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th//span[text()='%s']/parent::a/parent::span/parent::th/preceding-sibling::th";
	public static final String FILTER_TEXTBOX_BY_COLUM_NAME = "xpath=//thead/tr[@class='filter']/th[%s]//input";
	public static final String SEARCH_BUTTON = "xpath=//button[@title='Search']";
	public static final String TEXTBOX_BY_ROW_AND_COLUMN_NAME = "xpath=//tbody/tr[contains(@title,'customer')][%s]/td[%s]";
}
