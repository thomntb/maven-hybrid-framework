package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.RecentViewProductPageUI;

public class UserRecentViewProductPageObject extends BasePage {

	private WebDriver driver;

	public UserRecentViewProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void getTextRecentViewProduct() {
		waitForElementVisible(RecentViewProductPageUI.ALL_PRODUCT_NAME);
		List<WebElement> listReview = getListWebElements(RecentViewProductPageUI.ALL_PRODUCT_NAME);
		for (WebElement webElement : listReview) {
			System.out.println(webElement);
		}
		System.out.println(listReview.get(0));
		System.out.println(listReview.get(1));
		System.out.println(listReview.get(2));
	}
}
