package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {

	private WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostMenu() {
		waitForElementClickable(AdminDashboardPageUI.POST_MENU_LINK);
		clickToElement(AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

}
