package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerPageUI;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserCustomerPageObject extends BasePage {

	private WebDriver driver;

	public UserCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectGenderRadio(String gender) {
		waitForElementClickable(CustomerPageUI.GENDER_RADIO, gender);
		checkTheCheckboxOrRadio(CustomerPageUI.GENDER_RADIO, gender);
	}

	public void sendkeyToCustomeInfoTextbox(String filedName, String textValue) {
		waitForElementVisible(CustomerPageUI.CUSTOMER_INFO_TEXTBOX, filedName);
		sendkeyToElement(CustomerPageUI.CUSTOMER_INFO_TEXTBOX, textValue, filedName);
	}

	public void selectToDateOfBirth(String dateType, String textValue) {
		waitForElementClickable(CustomerPageUI.DATE_OF_BIRTH_DROPDOWN, dateType);
		selectItemInDropdown(CustomerPageUI.DATE_OF_BIRTH_DROPDOWN, textValue, dateType);
	}

	public void clickToSaveButton() {
		waitForElementClickable(CustomerPageUI.SAVE_BUTTON);
		clickToElement(CustomerPageUI.SAVE_BUTTON);
	}

	public boolean isSuccessUpdateMessageDisplayed() {
		waitForElementVisible(CustomerPageUI.SUCCESSFULLY_UPDATE_MESSAGE);
		return isElementDisplayed(CustomerPageUI.SUCCESSFULLY_UPDATE_MESSAGE);
	}

	public boolean isGenderSelected(String genderType) {
		waitForElementClickable(CustomerPageUI.GENDER_RADIO_IS_SELECTED, genderType);
		return isElementSelected(CustomerPageUI.GENDER_RADIO_IS_SELECTED, genderType);
	}

	public String getTextToCustomerInfoTextbox(String fileType, String attributeValue) {
		waitForElementVisible(CustomerPageUI.CUSTOMER_INFO_TEXTBOX, fileType);
		return getElementAttribute(CustomerPageUI.CUSTOMER_INFO_TEXTBOX, attributeValue, fileType);
	}

	public String getValueToDateOfBirth(String dateType) {
		waitForElementClickable(CustomerPageUI.DATE_OF_BIRTH_DROPDOWN, dateType);
		return getSelectItemInDropdown(CustomerPageUI.DATE_OF_BIRTH_DROPDOWN, dateType);
	}

}
