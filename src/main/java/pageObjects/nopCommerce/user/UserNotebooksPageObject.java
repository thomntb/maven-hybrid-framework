package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.NotebooksPageUI;

public class UserNotebooksPageObject extends BasePage {

	private WebDriver driver;

	public UserNotebooksPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void selectValueInDropdown(String nameSelect) {
		waitForElementClickable(NotebooksPageUI.PRODUCT_ORDER_BY);
		selectItemInDropdown(NotebooksPageUI.PRODUCT_ORDER_BY, nameSelect);
		sleepInSecond(1);
	}

	public void selectValuePagingInDropdown(String nameSelect) {
		waitForElementClickable(NotebooksPageUI.PRODUCT_PAGING_SIZE);
		selectItemInDropdown(NotebooksPageUI.PRODUCT_PAGING_SIZE, nameSelect);
		sleepInSecond(1);
	}
	
	public boolean isDataSortAscendingString() {
		ArrayList<String> productList = new ArrayList<>();
		List<WebElement> elementList = getListWebElements(NotebooksPageUI.PRODUCT_NAME_TEXTS);
		for (WebElement productName : elementList) {
			productList.add(productName.getText());
		}
		
		ArrayList<String> sortList = new ArrayList<>();
		for (String child : productList) {
			sortList.add(child);
		}
		Collections.sort(sortList);
		
		return sortList.equals(productList);
	}
	
	public boolean isDataSortDescendingString() {
		ArrayList<String> productList = new ArrayList<>();
		List<WebElement> elementList = getListWebElements(NotebooksPageUI.PRODUCT_NAME_TEXTS);
		for (WebElement productName : elementList) {
			productList.add(productName.getText());
		}
		
		ArrayList<String> sortList = new ArrayList<>();
		for (String child : productList) {
			sortList.add(child);
		}
		Collections.sort(sortList);
		Collections.reverse(sortList);
		
		return sortList.equals(productList);
	}

	public boolean isDataSortAscendingFloat() {
		ArrayList<Float> productList = new ArrayList<>();
		List<WebElement> elementList = getListWebElements(NotebooksPageUI.PRODUCT_PRICE_TEXTS);
		for (WebElement productprice : elementList) {
			productList.add(Float.parseFloat(productprice.getText().replace("$", "").replace(",", "").trim()));
		}
		
		ArrayList<Float> sortList = new ArrayList<>();
		for (Float child : productList) {
			sortList.add(child);
		}
		Collections.sort(sortList);
		
		return sortList.equals(productList);
	}

	public boolean isDataSortDescendingFloat() {
		ArrayList<Float> productList = new ArrayList<>();
		List<WebElement> elementList = getListWebElements(NotebooksPageUI.PRODUCT_PRICE_TEXTS);
		for (WebElement productprice : elementList) {
			productList.add(Float.parseFloat(productprice.getText().replace("$", "").replace(",", "").trim()));
		}
		
		ArrayList<Float> sortList = new ArrayList<>();
		for (Float child : productList) {
			sortList.add(child);
		}
		Collections.sort(sortList);
		Collections.reverse(sortList);
		
		return sortList.equals(productList);
	}

	public boolean isSizePagingNotebooks(int numberPage) {
		waitForElementClickable(NotebooksPageUI.PRODUCT_NAME_TEXTS);
		if(getElementSize(NotebooksPageUI.PRODUCT_NAME_TEXTS) <= numberPage) {
			return true;
		}
		return false;
	}

	public boolean isIconPagingDisplayed(String iconPaging) {
		waitForElementClickable(NotebooksPageUI.ICON_PAGING, iconPaging);
		return isElementDisplayed(NotebooksPageUI.ICON_PAGING, iconPaging);
	}

	public void clickToIconPaging(String iconPaging) {
		waitForElementClickable(NotebooksPageUI.ICON_PAGING, iconPaging);
		clickToElement(NotebooksPageUI.ICON_PAGING, iconPaging);
	}

	public boolean isPagingUndisplayed(String iconPaging) {
		return isElementUndisplay(NotebooksPageUI.ICON_PAGING, iconPaging);
	}
}
