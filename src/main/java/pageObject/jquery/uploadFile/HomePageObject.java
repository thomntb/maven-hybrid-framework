package pageObject.jquery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isFileNameLoadedDisplayed(String fileName) {
		waitForElementVisible(HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElements(HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileNameLinkUploadedByName(String fileName) {
		waitForElementVisible(HomePageUI.FILE_NAME_LINK_UPLOADED, fileName);
		return isElementDisplayed(HomePageUI.FILE_NAME_LINK_UPLOADED, fileName);
	}

	public boolean isFileNameImageUploadedByName(String fileName) {
		waitForElementVisible(HomePageUI.FILE_NAME_IMAGE_UPLOADED, fileName);
		return isImageLoaded(HomePageUI.FILE_NAME_IMAGE_UPLOADED, fileName);
	}

}
