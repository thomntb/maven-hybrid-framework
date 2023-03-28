package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.DesktopPageUI;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.NotebooksPageUI;

public class UserDesktopPageObject extends BasePage {

	private WebDriver driver;

	public UserDesktopPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserProductDetailPageObject clickToProductNameTitle(String productName) {
		waitForElementClickable(DesktopPageUI.PRODUCT_NAME_TITLE_LINK, productName);
		clickToElement(DesktopPageUI.PRODUCT_NAME_TITLE_LINK, productName);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}
}
