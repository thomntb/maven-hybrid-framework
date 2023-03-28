package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminDashboardsPageObject extends BasePage {

	private WebDriver driver;

	public AdminDashboardsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}
