package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserDownloadableProductPageObject extends BasePage {

	private WebDriver driver;
	
	public UserDownloadableProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
