package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserBackInStockSubscriptionPageObject extends BasePage {

	private WebDriver driver;
	
	public UserBackInStockSubscriptionPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
