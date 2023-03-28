package pageObject.liveTechPanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTechPanda.user.HomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserLoginPageObject clickToMyAccountLinkAtFooter() {
		waitForElementClickable(HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	

}
