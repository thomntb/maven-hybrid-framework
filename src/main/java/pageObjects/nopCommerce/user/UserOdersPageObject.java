package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserOdersPageObject extends BasePage {

	private WebDriver driver;
	
	public UserOdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
