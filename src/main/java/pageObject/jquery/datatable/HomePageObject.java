package pageObject.jquery.datatable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.datatable.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void openPagingByPageNumber(String numberPage) {
		waitForElementClickable(HomePageUI.PAGINATION_PAGE_NUMBER, numberPage);
		clickToElement(HomePageUI.PAGINATION_PAGE_NUMBER, numberPage);
	}
	
	public boolean isPageNumberActive(String numberPage) {
		waitForElementVisible(HomePageUI.PAGINATION_SELECTED_PAGE, numberPage);
		return isElementDisplayed(HomePageUI.PAGINATION_SELECTED_PAGE, numberPage);
	}

	public void enterHeaderToTextboxByLabel(String labelTextbox, String value) {
		waitForElementVisible(HomePageUI.HEADER_TEXTBOX_BY_LABEL, labelTextbox);
		sendkeyToElement(HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, labelTextbox);
		pressKeyToElement(HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, labelTextbox);
	}
	
	public List getValueEachRowAllPage(String columName) {
		int totalPage = getElementSize(HomePageUI.TOTAL_PAGINATION);
		
		List<String> allRowValuePage = new ArrayList<String>();
		for (int i = 1; i <= totalPage; i++) {
			clickToElement(HomePageUI.PAGINATION_PAGE_NUMBER, String.valueOf(i));
			
			List<WebElement> allRowEachPage = getListWebElements(HomePageUI.ALL_ROW_EACH_PAGE , columName);
			//List<WebElement> allColumnEachPage = getListWebElements(HomePageUI.ALL_COLUMN_EACH_PAGE, columName);
			for (WebElement eachRow : allRowEachPage) {
				allRowValuePage.add(eachRow.getText());
			}
		}
		
		for (String eachRow : allRowValuePage) {
			System.out.println(eachRow);
		}
		return allRowValuePage;
	}

	public void sendkeyToDynamicTextboxByRowAndColumnName(String columnName, String rowNumber, String valueText ) {
		int columnNumber = getElementSize(HomePageUI.COLUM_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementVisible(HomePageUI.TEXTBOX_BY_ROW_AND_COLUM_NAME, rowNumber,String.valueOf(columnNumber));
		sendkeyToElement(HomePageUI.TEXTBOX_BY_ROW_AND_COLUM_NAME, valueText, rowNumber,String.valueOf(columnNumber));
	}

	public void selectDropdownByRowAndColumnName(String columnName, String rowNumber, String valueText) {
		int columnNumber = getElementSize(HomePageUI.COLUM_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(HomePageUI.DROPDOWN_BY_ROW_AND_COLUM_NAME, rowNumber,String.valueOf(columnNumber));
		selectItemInDropdown(HomePageUI.DROPDOWN_BY_ROW_AND_COLUM_NAME, valueText, rowNumber,String.valueOf(columnNumber));
	}

	public void selectRadioByRowAndColumnName(String columnName, String rowNumber) {
		int columnNumber = getElementSize(HomePageUI.COLUM_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(HomePageUI.RADIO_BY_ROW_AND_COLUM_NAME, rowNumber, String.valueOf(columnNumber));
		checkTheCheckboxOrRadio(HomePageUI.RADIO_BY_ROW_AND_COLUM_NAME, rowNumber, String.valueOf(columnNumber));
	}
	
	public void unSelectRadioByRowAndColumnName(String columnName, String rowNumber) {
		int columnNumber = getElementSize(HomePageUI.COLUM_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(HomePageUI.RADIO_BY_ROW_AND_COLUM_NAME, rowNumber, String.valueOf(columnNumber));
		uncheckTheCheckboxOrRadio(HomePageUI.RADIO_BY_ROW_AND_COLUM_NAME, rowNumber, String.valueOf(columnNumber));
	}

	public void clickLoadDataButton() {
		waitForElementClickable(HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(HomePageUI.LOAD_DATA_BUTTON);
	}

	public void actionIconByRowNumber(String rowNumber, String actionName) {
		waitForElementClickable(HomePageUI.ICON_BY_ROW_NUMBER, rowNumber, actionName);
		clickToElement(HomePageUI.ICON_BY_ROW_NUMBER, rowNumber, actionName);
	}
	
	

}
