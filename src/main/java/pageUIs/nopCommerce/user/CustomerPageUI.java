package pageUIs.nopCommerce.user;

public class CustomerPageUI {

	public static final String GENDER_RADIO = "xpath=//div[@class='gender']/span/label[text()='%s']";
	public static final String CUSTOMER_INFO_TEXTBOX = "xpath=//input[@id='%s']";
	public static final String DATE_OF_BIRTH_DROPDOWN = "xpath=//select[@name='%s']";
	public static final String SAVE_BUTTON = "xpath=//button[@id='save-info-button']";
	public static final String SUCCESSFULLY_UPDATE_MESSAGE = "xpath=//p[text()='The customer info has been updated successfully.']";
	public static final String GENDER_RADIO_IS_SELECTED = "xpath=//div[@class='gender']/span[@class='%s']/input"; 
}