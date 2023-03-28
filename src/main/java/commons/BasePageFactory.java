package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	public static BasePageFactory getBasePage() {
		return new BasePageFactory();
	}
	protected void openPageUrl(WebDriver driver, String urlPage) {
		driver.get(urlPage);
	}
	
	protected String getTiltePage(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getCurrentURLPage(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	protected void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	protected Alert waitAlertOfPresence(WebDriver driver) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		return explixitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void acceptAlert(WebDriver driver) {
		waitAlertOfPresence(driver).accept();
	}
	
	protected void cancelAlert(WebDriver driver) {
		waitAlertOfPresence(driver).dismiss();
	}
	
	protected String getTextAlert(WebDriver driver) {
		return waitAlertOfPresence(driver).getText();
	}
	
	protected void sendkeyToAlert(WebDriver driver, String value) {
		waitAlertOfPresence(driver).sendKeys(value);
	}
	
	protected void switchToWindowByPageTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String id : allWindows) {
			driver.switchTo().window(id);
			String currentTitle = driver.getTitle();
			
			if(currentTitle.equals(title)) {
				break;
			}
		}
	}
	
	protected void closeAllWindowWithoutParentWindow(WebDriver driver, String parentId) {
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String id : allWindows) {
			if(!id.equals(parentId)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentId);
	}
	
	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	
	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	private List<WebElement> getWebElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	protected void sendkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected String getTextElement(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	protected void selectItemInDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(xpathLocator);
	}
	
	protected String getSelectItemInDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	protected Boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

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
	
	protected void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}
	
	protected String getHexaColorFromFGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	protected int getElementSize(WebDriver driver, String xpathLocator) {
		return getWebElements(driver, xpathLocator).size();
	}
	
	protected void checkTheCheckboxOrRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	protected void uncheckTheCheckboxOrRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	protected Boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	protected Boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	protected Boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	
	protected void switchToFrame(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}
	
	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	protected void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	protected void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
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

	protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	protected void waitForAllElementInvisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	
	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	private long longTimeOut = 30;
}
