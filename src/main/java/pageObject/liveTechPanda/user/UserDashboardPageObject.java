package pageObject.liveTechPanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTechPanda.user.DashboardPageUI;
import pageUIs.liveTechPanda.user.HomePageUI;
import pageUIs.liveTechPanda.user.RegisterPageUI;

public class UserDashboardPageObject extends BasePage{
	private WebDriver driver;

	public UserDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isTitleDashboardDisplayed() {
		waitForElementVisible(DashboardPageUI.DASHBOARD_TITLE);
		return isElementDisplayed(DashboardPageUI.DASHBOARD_TITLE);
	}
}
