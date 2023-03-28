package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.admin.AdminDashboardsPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCartPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCompareProductPageObject;
import pageObjects.nopCommerce.user.UserCustomerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserRecentViewProductPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.UserWishListPageObject;
import pageUIs.nopCommerce.user.CustomerPageUI;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Wishlist extends BaseTest {

	private WebDriver driver;
	private String emailUser, firstName, lastName, passwordUser, productName1, productName2, productName3, productName4;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserProductDetailPageObject userProductDetailPage;
	private UserWishListPageObject userWishlistPage;
	private UserCartPageObject userCartPage;
	private UserCompareProductPageObject userCompareProductPage;
	private UserRecentViewProductPageObject userRecentViewProductPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailUser = "automation" + userHomePage.randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		passwordUser = "123456";
		productName1 = "Apple MacBook Pro 13-inch";
		productName2 = "HTC One M8 Android L 5.0 Lollipop";
		productName3 = "Build your own computer";
		productName4 = "$25 Virtual Gift Card";

		userRegisterPage = userHomePage.clickToRegisterLink();
		userRegisterPage.inputToFirstNameTextBox(firstName);
		userRegisterPage.inputToLastNameTextBox(lastName);
		userRegisterPage.inputToEmailTextBox(emailUser);
		userRegisterPage.inputToPasswordTextBox(passwordUser);
		userRegisterPage.inputToConfirmTextBox(passwordUser);

		userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		userHomePage = userRegisterPage.clickToContinueButton();
		// userRegisterPage.clickToUserLogoutButton(driver);

		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Wishlist_TC_01_Add_To_Wishlist() {
		userHomePage.scrollFeatureProductTitle();
		userProductDetailPage = userHomePage.clickToProductTitleLink(productName1);
		userProductDetailPage.clickToAddToWishlistButton("Add to wishlist");
		Assert.assertEquals(userProductDetailPage.getAddToWishlistSuccessMessage(), "The product has been added to your wishlist");
		userProductDetailPage.clickToFooterLink("Wishlist");
		userWishlistPage = PageGeneratorManager.getUserWishlistPage(driver);
		userWishlistPage.clickWishlistURLLink();
		Assert.assertEquals(userWishlistPage.getValueTableByRowAndColumnName("Product", "1"), productName1);
	}

	@Test
	public void Wishlist_TC_02() {
		userWishlistPage.clickToAddToCartCheckboxByRowNumber("1");
		userCartPage = userWishlistPage.clickToAddToCardButton();
		Assert.assertTrue(userCartPage.getTextPageTitleCart());
		Assert.assertEquals(userCartPage.getValueTableByRowAndColumnName("Product", "1"), productName1);
	}

	@Test
	public void Wishlist_TC_03() {
		userHomePage = userCartPage.clickToHeaderLogoLink();
		userProductDetailPage = userHomePage.clickToProductTitleLink(productName2);
		userProductDetailPage.clickToAddToWishlistButton("Add to wishlist");
		Assert.assertEquals(userProductDetailPage.getAddToWishlistSuccessMessage(), "The product has been added to your wishlist");
		userProductDetailPage.clickToFooterLink("Wishlist");
		userWishlistPage = PageGeneratorManager.getUserWishlistPage(driver);
		Assert.assertEquals(userWishlistPage.getValueTableByRowAndColumnName("Product", "2"), productName2);
		userWishlistPage.clickToRemoveButtonByRowNumber("1");
		userWishlistPage.clickToRemoveButtonByRowNumber("1");
		Assert.assertEquals(userWishlistPage.getEmptyDataMessage(), "The wishlist is empty!");
	}

	@Test
	public void Wishlist_TC_04() {
		userHomePage = userWishlistPage.clickToHeaderLogoLink();
		userHomePage.clickToCompareProductButton(productName1, "Add to compare list");
		Assert.assertEquals(userHomePage.getSuccessMessageAddToCompareList(), "The product has been added to your product comparison");
		userHomePage.sleepInSecond(1);
		userHomePage.clickToCompareProductButton(productName2, "Add to compare list");
		Assert.assertEquals(userHomePage.getSuccessMessageAddToCompareList(), "The product has been added to your product comparison");
		userHomePage.sleepInSecond(1);
		userHomePage.clickToFooterLink("Compare products list");
		userCompareProductPage = PageGeneratorManager.getUserCompareProductPage(driver);
		userCompareProductPage.sleepInSecond(2);
		userCompareProductPage.clickToClearListButton();
		Assert.assertEquals(userCompareProductPage.getErrorMessageNoDataCompare(), "You have no items to compare.");
	}

	@Test
	public void Wishlist_TC_05() {
		userHomePage = userCompareProductPage.clickToHeaderLogoLink();
		String[] itemList = {productName1, productName2, productName3, productName4};
		
		for (String nameProduct : itemList) {
			userProductDetailPage = userHomePage.clickToProductTitleLink(nameProduct);
			userHomePage = userProductDetailPage.clickToHeaderLogoLink();
		}
		userHomePage.clickToFooterLink("Recently viewed products");
		userRecentViewProductPage = PageGeneratorManager.getUserRecentViewProductPage(driver);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
