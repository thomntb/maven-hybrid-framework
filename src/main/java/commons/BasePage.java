package commons;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.UserHomePO;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptionPageObject;
import pageObjects.nopCommerce.user.UserCartPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerPageObject;
import pageObjects.nopCommerce.user.UserDownloadableProductPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUIs.jquery.uploadFile.BasePageJqueryUI;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class BasePage {
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageUrl(String urlPage) {
		driver.get(urlPage);
	}

	protected String getTiltePage() {
		return driver.getTitle();
	}

	protected String getCurrentURLPage() {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode() {
		return driver.getPageSource();
	}

	protected void backToPage() {
		driver.navigate().back();
	}

	protected void forwardPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public Set<Cookie> getAllCookies() {
		return driver.manage().getCookies();
	}

	public void setCookies(Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public Alert waitAlertOfPresence() {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		return explixitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		waitAlertOfPresence().accept();
	}

	public void cancelAlert() {
		waitAlertOfPresence().dismiss();
	}

	public String getTextAlert() {
		return waitAlertOfPresence().getText();
	}

	public void sendkeyToAlert(String value) {
		waitAlertOfPresence().sendKeys(value);
	}

	protected void switchToWindowByPageTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String id : allWindows) {
			driver.switchTo().window(id);
			String currentTitle = driver.getTitle();

			if (currentTitle.equals(title)) {
				break;
			}
		}
	}

	protected void closeAllWindowWithoutParentWindow(String parentId) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String id : allWindows) {
			if (!id.equals(parentId)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentId);
	}

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Browser is not support locator type");
		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... dynamicValue) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValue);
		}
		return locatorType;
	}

	private WebElement getWebElement(String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	protected List<WebElement> getListWebElements(String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	protected List<WebElement> getListWebElements(String locatorType, String... dynamicValue) {
		return driver.findElements(getByLocator(getDynamicXpath(locatorType, dynamicValue)));
	}

	protected void clickToElement(String locatorType) {
		getWebElement(locatorType).click();
	}

	protected void clickToElement(String locatorType, String... dynamicValue) {
		getWebElement(getDynamicXpath(locatorType, dynamicValue)).click();
	}

	protected void sendkeyToElement(String locatorType, String textValue) {
		getWebElement(locatorType).clear();
		getWebElement(locatorType).sendKeys(textValue);
	}

	protected void sendkeyToElement(String locatorType, String textValue, String... dynamicValue) {
		getWebElement(getDynamicXpath(locatorType, dynamicValue)).clear();
		getWebElement(getDynamicXpath(locatorType, dynamicValue)).sendKeys(textValue);
	}

	protected void clearValueElementByPressKey(String locatorType) {
		getWebElement(locatorType).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	protected String getTextElement(String locatorType) {
		return getWebElement(locatorType).getText();
	}

	protected String getTextElement(String locatorType, String... dynamicValue) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValue)).getText();
	}

	protected void selectItemInDropdown(String locatorType, String textItem) {
		Select select = new Select(getWebElement(locatorType));
		select.selectByVisibleText(textItem);
	}

	protected void selectItemInDropdown(String locatorType, String textItem, String... dynamicValue) {
		Select select = new Select(getWebElement(getDynamicXpath(locatorType, dynamicValue)));
		select.selectByVisibleText(textItem);
	}

	protected String getSelectItemInDropdown(String locatorType) {
		Select select = new Select(getWebElement(locatorType));
		return select.getFirstSelectedOption().getText();
	}

	protected String getSelectItemInDropdown(String locatorType, String... dynamicValue) {
		Select select = new Select(getWebElement(getDynamicXpath(locatorType, dynamicValue)));
		return select.getFirstSelectedOption().getText();
	}

	protected Boolean isDropdownMultiple(String locatorType) {
		Select select = new Select(getWebElement(locatorType));
		return select.isMultiple();
	}

	protected void selectItemInCustomDropdown(String parentLocator, String childItemLocator, String expectedItem) {
		getWebElement(parentLocator).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getElementAttribute(String locatorType, String attributeName) {
		return getWebElement(locatorType).getAttribute(attributeName);
	}

	protected String getElementAttribute(String locatorType, String attributeName, String... dynamicValue) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValue)).getAttribute(attributeName);
	}

	protected String getElementCssValue(String locatorType, String propertyName) {
		return getWebElement(locatorType).getCssValue(propertyName);
	}

	protected String getHexaColorFromFGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(String locatorType) {
		return getListWebElements(locatorType).size();
	}

	protected int getElementSize(String locatorType, String... dynamicValue) {
		return getListWebElements(getDynamicXpath(locatorType, dynamicValue)).size();
	}

	protected void checkTheCheckboxOrRadio(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void checkTheCheckboxOrRadio(String locatorType, String... dynamicValue) {
		WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValue));
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckTheCheckboxOrRadio(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckTheCheckboxOrRadio(String locatorType, String... dynamicValue) {
		WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValue));
		if (element.isSelected()) {
			element.click();
		}
	}

	protected Boolean isElementDisplayed(String locatorType) {
		return getWebElement(locatorType).isDisplayed();
	}

	protected Boolean isElementDisplayed(String locatorType, String... dynamicValue) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValue)).isDisplayed();
	}

	protected boolean isElementUndisplay(String locator) {
		overrideImplicitTimeOut(shortTimeOut);
		List<WebElement> elements = getListWebElements(locator);
		overrideImplicitTimeOut(longTimeOut);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isElementUndisplay(String locator, String... dynamicValue) {
		overrideImplicitTimeOut(shortTimeOut);
		List<WebElement> elements = getListWebElements(getDynamicXpath(locator, dynamicValue));
		overrideImplicitTimeOut(longTimeOut);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 1 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	private void overrideImplicitTimeOut(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	protected Boolean isElementSelected(String locatorType) {
		return getWebElement(locatorType).isSelected();
	}

	protected Boolean isElementSelected(String locatorType, String... dynamicValue) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValue)).isSelected();
	}

	protected Boolean isElementEnabled(String locatorType) {
		return getWebElement(locatorType).isEnabled();
	}

	protected void switchToFrame(String locatorType) {
		driver.switchTo().frame(getWebElement(locatorType));
	}

	protected void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	protected void hoverMouseToElement(String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locatorType)).perform();
	}

	protected void hoverMouseToElement(String locatorType, String... dynamicValue) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(getDynamicXpath(locatorType, dynamicValue))).perform();
	}

	protected void pressKeyToElement(String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(locatorType), key).perform();
	}

	protected void pressKeyToElement(String locatorType, Keys key, String... dynamicValue) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(getDynamicXpath(locatorType, dynamicValue)), key).perform();
	}

	protected void scrollToBottomPage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(locatorType));
	}

	protected void scrollToElement(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(locatorType));
	}

	protected void scrollToElement(String locatorType, String... dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(getDynamicXpath(locatorType, dynamicValue)));
	}

	protected void removeAttributeInDOM(String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(locatorType));
	}

	protected boolean areJQueryAndJSLoadedSuccess() {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(locatorType));
	}

	protected boolean isImageLoaded(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(locatorType));
		return status;
	}

	protected boolean isImageLoaded(String locatorType, String... dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(getDynamicXpath(locatorType, dynamicValue)));
		return status;
	}

	protected void waitForElementVisible( String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected void waitForElementVisible(String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	protected void waitForAllElementVisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	protected void waitForElementInvisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected void waitForElementInvisible(String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	/*
	 * waitForElementUndisplayed: use when check element in DOM or not in DOM but not display in UI
	 */
	protected void waitForElementUndisplayed(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeOut);
		overrideImplicitTimeOut(shortTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeOut(longTimeOut);
	}

	protected void waitForElementUndisplayed(String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeOut);
		overrideImplicitTimeOut(shortTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
		overrideImplicitTimeOut(longTimeOut);
	}

	protected void waitForAllElementInvisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(locatorType)));
	}

	protected void waitForElementClickable(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	protected void waitForElementClickable(String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void uploadMultipleFiles(String... fileName) {
		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";

		for (String file : fileName) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(BasePageJqueryUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	public UserAddressesPageObject openAddressesPage() {
		waitForElementClickable(BasePageNopCommerceUI.ADDRESSES_LINK);
		clickToElement(BasePageNopCommerceUI.ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressesPage(driver);
	}

	public UserBackInStockSubscriptionPageObject openBackInStockSuvscriptionPage() {
		waitForElementClickable(BasePageNopCommerceUI.BACK_IN_STOCK_SUBSCRIPTION_LINK);
		clickToElement(BasePageNopCommerceUI.BACK_IN_STOCK_SUBSCRIPTION_LINK);
		return PageGeneratorManager.getUserBackInStockSubscriptionPage(driver);
	}

	public UserChangePasswordPageObject openChangePasswordPage() {
		waitForElementClickable(BasePageNopCommerceUI.CHANGE_PASSWORD_LINK);
		clickToElement(BasePageNopCommerceUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getUserChangePasswordPage(driver);
	}

	public UserCustomerPageObject openCustomerPage() {
		waitForElementClickable(BasePageNopCommerceUI.CUSTOMER_LINK);
		clickToElement(BasePageNopCommerceUI.CUSTOMER_LINK);
		return PageGeneratorManager.getUserCustomerPage(driver);
	}

	public UserDownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(BasePageNopCommerceUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(BasePageNopCommerceUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getUserDownloadableProductPage(driver);
	}

	public UserMyProductReviewPageObject openMyProductReviewPage() {
		waitForElementClickable(BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public UserOdersPageObject openOdersPage() {
		waitForElementClickable(BasePageNopCommerceUI.ODERS_LINK);
		clickToElement(BasePageNopCommerceUI.ODERS_LINK);
		return PageGeneratorManager.getUserOdersPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage() {
		waitForElementClickable(BasePageNopCommerceUI.REWARD_POINT_LINK);
		clickToElement(BasePageNopCommerceUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(BasePageNopCommerceUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(BasePageNopCommerceUI.MY_ACCOUNT_LINK);
	}

	public UserCustomerPageObject clickToMyAccountLink() {
		waitForElementClickable(BasePageNopCommerceUI.MY_ACCOUNT_LINK);
		clickToElement(BasePageNopCommerceUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerPage(driver);
	}

	public UserCartPageObject clickToShoppingCartLink() {
		scrollToTopHeader();
		waitForElementClickable(BasePageNopCommerceUI.SHOOPING_CART_LINK);
		clickToElement(BasePageNopCommerceUI.SHOOPING_CART_LINK);
		return PageGeneratorManager.getUserCartPage(driver);
	}

	public void hoverMouseToShoppingCartMenuLink() {
		waitForElementVisible(BasePageNopCommerceUI.SHOOPING_CART_LINK);
		hoverMouseToElement(BasePageNopCommerceUI.SHOOPING_CART_LINK);
	}

	public void clickToFooterLink(String menuFooter) {
		waitForElementClickable(BasePageNopCommerceUI.MENU_AT_FOOTER_LINK, menuFooter);
		clickToElement(BasePageNopCommerceUI.MENU_AT_FOOTER_LINK, menuFooter);
	}

	public BasePage openDynamicPageAtMyAccountByPageName(String pageName) {
		waitForElementClickable(BasePageNopCommerceUI.OPEN_DYNAMIC_PAGE_AT_MY_ACCOUNT, pageName);
		clickToElement(BasePageNopCommerceUI.OPEN_DYNAMIC_PAGE_AT_MY_ACCOUNT, pageName);

		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressesPage(driver);
		case "Orders":
			return PageGeneratorManager.getUserOdersPage(driver);
		case "Downloadable products":
			return PageGeneratorManager.getUserDownloadableProductPage(driver);
		case "Back in stock subscriptions":
			return PageGeneratorManager.getUserBackInStockSubscriptionPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		case "Change password":
			return PageGeneratorManager.getUserChangePasswordPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		default:
			throw new RuntimeException("Page Name is invalid!");
		}
	}

	public UserHomePageObject clickToUserLogoutButton() {
		waitForElementVisible(BasePageNopCommerceUI.USER_LOGOUT_BUTTON);
		clickToElement(BasePageNopCommerceUI.USER_LOGOUT_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToAdminLogoutButton() {
		waitForElementVisible(BasePageNopCommerceUI.ADMIN_LOGOUT_BUTTON);
		clickToElement(BasePageNopCommerceUI.ADMIN_LOGOUT_BUTTON);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public UserHomePageObject clickToHeaderLogoLink() {
		waitForElementClickable(BasePageNopCommerceUI.HEADER_LOGO_LINK);
		clickToElement(BasePageNopCommerceUI.HEADER_LOGO_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void scrollToTopHeader() {
		scrollToElement(BasePageNopCommerceUI.CURRENCY_CUSTOMER);
	}

	public UserHomePO openEndUserSite(String userUrl) {
		openPageUrl(userUrl);
		return pageObject.wordpress.PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminDashboardPO openAdminSite(String adminUrl) {
		openPageUrl(adminUrl);
		return pageObject.wordpress.PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public void hoverMouseToHeaderMenuLink(String menuName) {
		scrollToTopHeader();
		waitForElementClickable(BasePageNopCommerceUI.TOP_HEADER_MENU_LINK, menuName);
		hoverMouseToElement(BasePageNopCommerceUI.TOP_HEADER_MENU_LINK, menuName);
	}

	public void clickToChildHeaderMenu(String parentMenu, String childMenu) {
		waitForElementClickable(BasePageNopCommerceUI.SUB_MENU_TOP_HEADER_MENU_LINK, parentMenu, childMenu);
		clickToElement(BasePageNopCommerceUI.SUB_MENU_TOP_HEADER_MENU_LINK, parentMenu, childMenu);
	}

	private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;

	public int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(99999);
	}
}
