package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCartPageObject;
import pageObjects.nopCommerce.user.UserDesktopPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNotebooksPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Order_Product extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserDesktopPageObject userDesktopPage;
	private UserCartPageObject userCartPage;
	private UserProductDetailPageObject userProductDetailPage;
	
	private String productName = "Build your own computer";
	private String processor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
	private String ram = "8GB [+$60.00]";
	private String hdd = "400 GB [+$100.00]";
	private String os = "Vista Premium [+$60.00]";
	private String software = "Microsoft Office [+$50.00]";
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(Common_Register_End_User.emailUser, Common_Register_End_User.passwordUser);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Order_01_Add_Product_To_Cart() {
		log.info("Add Product To Cart - Step 01: hover mouse to 'Computer' menu link");
		userHomePage.hoverMouseToHeaderMenuLink("Computers");
		
		log.info("Add Product To Cart - Step 02: click to 'Desktops' menu");
		userHomePage.clickToChildHeaderMenu("Computers", "Desktops");
		userDesktopPage = PageGeneratorManager.getDesktopPage(driver);
		
		log.info("Add Product To Cart - Step 03: click to product name is '" +productName+ "'");
		userProductDetailPage = userDesktopPage.clickToProductNameTitle(productName);
		
		log.info("Add Product To Cart - Step 04: choose Processor");
		userProductDetailPage.selectValueProcessorDropdown(processor);
		
		log.info("Add Product To Cart - Step 04: choose RAM");
		userProductDetailPage.selectValueRamDropdown(ram);
		
		log.info("Add Product To Cart - Step 04: choose HDD");
		userProductDetailPage.chooseValueHddRadio(hdd);
		
		log.info("Add Product To Cart - Step 04: choose OS");
		userProductDetailPage.chooseValueOsRadio(os);
		
		log.info("Add Product To Cart - Step 04: choose Software");
		userProductDetailPage.chooseValueSoftwareCheckbox(software);
		
		log.info("Add Product To Cart - Step 04: click to 'Add to cart' button");
		userProductDetailPage.clickToAddToCartButton();
		
		log.info("Add Product To Cart - Step 04: verify add to cart message success");
		Assert.assertEquals(userProductDetailPage.isAddToCartMessageSuccess(), "The product has been added to your shopping cart");
		
		log.info("Add Product To Cart - Step 04: close to Notification message");
		userProductDetailPage.clickToCloseNotificationMessage();
		
		log.info("Add Product To Cart - Step 10: hover to 'Shopping cart' menu link");
		userProductDetailPage.hoverMouseToShoppingCartMenuLink();
		
		log.info("Add Product To Cart - Step 11: verify product info in cart");
		Assert.assertEquals(userProductDetailPage.getProductTitleName(), productName);
		Assert.assertTrue(userProductDetailPage.isShoppingCartTextDisplayed(processor));
		Assert.assertTrue(userProductDetailPage.isShoppingCartTextDisplayed(ram));
		Assert.assertTrue(userProductDetailPage.isShoppingCartTextDisplayed(hdd));
		Assert.assertTrue(userProductDetailPage.isShoppingCartTextDisplayed(os));
		Assert.assertTrue(userProductDetailPage.isShoppingCartTextDisplayed(software));
	}
	
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
