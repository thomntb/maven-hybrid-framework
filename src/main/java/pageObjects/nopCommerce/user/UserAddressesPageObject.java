package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.AddressesPageUI;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserAddressesPageObject extends BasePage {

	private WebDriver driver;
	
	public UserAddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(AddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(AddressesPageUI.ADD_NEW_BUTTON);
	}

	public void sendkeyToAddNewAddressTextbox(String inputType, String textValue) {
		waitForElementVisible(AddressesPageUI.ADD_NEW_INPUT_TEXTBOX, inputType);
		sendkeyToElement(AddressesPageUI.ADD_NEW_INPUT_TEXTBOX, textValue, inputType);
	}

	public void clickToSaveButton() {
		waitForElementClickable(AddressesPageUI.SAVE_BUTTON);
		clickToElement(AddressesPageUI.SAVE_BUTTON);
	}

	public String getTextToAddNewAddressesTextbox(String inputType) {
		waitForElementVisible(AddressesPageUI.GET_VALUE_AFTER_ADD_NEW_ADDRESS, inputType);
		return getTextElement(AddressesPageUI.GET_VALUE_AFTER_ADD_NEW_ADDRESS, inputType);
	}

	public String getTextToCityTextbox(String cityName) {
		waitForElementVisible(AddressesPageUI.GET_VALUE_AFTER_ADD_NEW_ADDRESS, cityName);
		String[] subString = getTextElement(AddressesPageUI.GET_VALUE_AFTER_ADD_NEW_ADDRESS, cityName).split(",");
		return subString[0];
	}

	public String getTextToZipCodeTextbox(String zipCodeName) {
		waitForElementVisible(AddressesPageUI.GET_VALUE_AFTER_ADD_NEW_ADDRESS, zipCodeName);
		String[] subString = getTextElement(AddressesPageUI.GET_VALUE_AFTER_ADD_NEW_ADDRESS, zipCodeName).split(",");
		return subString[1].trim();
	}

	public void selectToAddNewAddressDropdown(String inputType, String textValue) {
		waitForElementClickable(AddressesPageUI.ADD_NEW_SELECT_DROPDOWN, inputType);
		selectItemInDropdown(AddressesPageUI.ADD_NEW_SELECT_DROPDOWN, textValue, inputType);	
	}

	public String getTextToPrefixAddNewAddressesTextbox(String inputType) {
		waitForElementVisible(AddressesPageUI.GET_VALUE_AFTER_ADD_NEW_ADDRESS, inputType);
		String[] subString = getTextElement(AddressesPageUI.GET_VALUE_AFTER_ADD_NEW_ADDRESS, inputType).split(":");
		return subString[1].trim();
	}

}
