package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class My_Account_Pattern_Object extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, emailUpdate, newPassword;
	private String productName, reviewTitle, reviewText;
	private String date, month, year;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerPageObject userCustomerPage;
	private UserAddressesPageObject userAddressesPage;
	private UserChangePasswordPageObject userChangePasswordPage;
	private UserProductDetailPageObject userProductPage;
	private UserMyProductReviewPageObject userMyProductReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = getBrowserDriver(browser);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailUpdate = "automationfc.vn" + userHomePage.randomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "Nguyen";
		newPassword = "123123";
		date = "1";
		month = "January";
		year = "1999";
		
		productName = "Build your own computer" ;
		reviewTitle = "Quality product";
		reviewText = "Very good quality, description correct";

		log.info("Click to Login link");
		userLoginPage = userHomePage.clickToLoginLink();
		
		log.info("Login to system with Email is '" +Common_Register_End_User.emailUser+ "' and Password is '" +Common_Register_End_User.passwordUser+ "'");
		userHomePage = userLoginPage.loginAsUser(Common_Register_End_User.emailUser, Common_Register_End_User.passwordUser);
		
		log.info("Verify My Account link is displayed");
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void My_Account_01_Update_Info() {
		userCustomerPage = userHomePage.clickToMyAccountLink();
		userCustomerPage.selectGenderRadio("Female");
		userCustomerPage.sendkeyToCustomeInfoTextbox("FirstName", firstName);
		userCustomerPage.sendkeyToCustomeInfoTextbox("LastName", lastName);
		userCustomerPage.selectToDateOfBirth("DateOfBirthDay", date);
		userCustomerPage.selectToDateOfBirth("DateOfBirthMonth", month);
		userCustomerPage.selectToDateOfBirth("DateOfBirthYear", year);
		userCustomerPage.sendkeyToCustomeInfoTextbox("Email", emailUpdate);
		userCustomerPage.sendkeyToCustomeInfoTextbox("Company", "Automation FC");
		userCustomerPage.clickToSaveButton();

		Assert.assertTrue(userCustomerPage.isSuccessUpdateMessageDisplayed());
		Assert.assertTrue(userCustomerPage.isGenderSelected("female"));
		Assert.assertEquals(userCustomerPage.getTextToCustomerInfoTextbox("FirstName", "value"), firstName);
		Assert.assertEquals(userCustomerPage.getTextToCustomerInfoTextbox("LastName", "value"), lastName);
		Assert.assertEquals(userCustomerPage.getTextToCustomerInfoTextbox("Email", "value"), emailUpdate);
		Assert.assertEquals(userCustomerPage.getTextToCustomerInfoTextbox("Company", "value"), "Automation FC");
		Assert.assertEquals(userCustomerPage.getValueToDateOfBirth("DateOfBirthDay"), date);
		Assert.assertEquals(userCustomerPage.getValueToDateOfBirth("DateOfBirthMonth"), month);
		Assert.assertEquals(userCustomerPage.getValueToDateOfBirth("DateOfBirthYear"), year);

	}

	@Test
	public void My_Account_TC_02() {
		String firstName = "Automation";
		String lastName = "FC";
		String company = "Automation FC";
		String country = "Viet Nam";
		String city = "Da Nang";
		String address1 = "123/04 Le Lai";
		String address2 = "234/05 Hai Phong";
		String zipCode = "550000";
		String phoneNumber = "0123456789";
		String fax = "0987654321";
		String state = "Other";

		userAddressesPage = (UserAddressesPageObject) userCustomerPage.openDynamicPageAtMyAccountByPageName("Addresses");

		userAddressesPage.clickToAddNewButton();
		userAddressesPage.sendkeyToAddNewAddressTextbox("First name", firstName);
		userAddressesPage.sendkeyToAddNewAddressTextbox("Last name", lastName);
		userAddressesPage.sendkeyToAddNewAddressTextbox("Email", emailUpdate);
		userAddressesPage.sendkeyToAddNewAddressTextbox("Company", company);
		userAddressesPage.selectToAddNewAddressDropdown("Country", country);
		userAddressesPage.selectToAddNewAddressDropdown("State / province", state);
		userAddressesPage.sendkeyToAddNewAddressTextbox("City", city);
		userAddressesPage.sendkeyToAddNewAddressTextbox("Address 1", address1);
		userAddressesPage.sendkeyToAddNewAddressTextbox("Address 2", address2);
		userAddressesPage.sendkeyToAddNewAddressTextbox("Zip / postal code", zipCode);
		userAddressesPage.sendkeyToAddNewAddressTextbox("Phone number", phoneNumber);
		userAddressesPage.sendkeyToAddNewAddressTextbox("Fax number", fax);
		userAddressesPage.clickToSaveButton();

		Assert.assertEquals(userAddressesPage.getTextToAddNewAddressesTextbox("name"), firstName + " " + lastName);
		Assert.assertEquals(userAddressesPage.getTextToPrefixAddNewAddressesTextbox("email"), emailUpdate);
		Assert.assertEquals(userAddressesPage.getTextToPrefixAddNewAddressesTextbox("phone"), phoneNumber);
		Assert.assertEquals(userAddressesPage.getTextToPrefixAddNewAddressesTextbox("fax"), fax);
		Assert.assertEquals(userAddressesPage.getTextToAddNewAddressesTextbox("company"), company);
		Assert.assertEquals(userAddressesPage.getTextToAddNewAddressesTextbox("address1"), address1);
		Assert.assertEquals(userAddressesPage.getTextToAddNewAddressesTextbox("address2"), address2);
		Assert.assertEquals(userAddressesPage.getTextToCityTextbox("city"), city);
		Assert.assertEquals(userAddressesPage.getTextToZipCodeTextbox("zip"), zipCode);
		Assert.assertEquals(userAddressesPage.getTextToAddNewAddressesTextbox("country"), country);
	}

	@Test
	public void My_Account_TC_03() {
		// userCustomerPage = userHomePage.clickToMyAccountLink(driver);
		userChangePasswordPage = (UserChangePasswordPageObject) userAddressesPage.openDynamicPageAtMyAccountByPageName("Change password");
		userChangePasswordPage.sendkeyToChangePasswordTextbox("Old password", Common_Register_End_User.passwordUser);
		userChangePasswordPage.sendkeyToChangePasswordTextbox("New password", newPassword);
		userChangePasswordPage.sendkeyToChangePasswordTextbox("Confirm password", newPassword);
		userChangePasswordPage.clickToChangePasswordButton();
		userChangePasswordPage.sleepInSecond(2);

		Assert.assertTrue(userChangePasswordPage.getSuccessMessageAfterChangePassword());
		userChangePasswordPage.clickToCloseIconSuccessMessage();
		userChangePasswordPage.sleepInSecond(2);

		userHomePage = userChangePasswordPage.clickToUserLogoutButton();
		userHomePage.clickToLoginLink();

		userLoginPage.loginAsUser(emailUpdate, Common_Register_End_User.passwordUser);
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		userHomePage= userLoginPage.loginAsUser(emailUpdate, newPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void My_Account_TC_04() {
		userHomePage.scrollFeatureProductTitle();
		userProductPage = userHomePage.clickToProductTitleLink(productName);
		userMyProductReviewPage = userProductPage.clickToAddYourReviewLink();
		
		userMyProductReviewPage.sendkeyToReviewTitleTextbox(reviewTitle);
		userMyProductReviewPage.sendkeyToReviewTextTextarea(reviewText);
		userMyProductReviewPage.clickToSubmitReviewButton();
		
		userCustomerPage = userMyProductReviewPage.clickToMyAccountLink();
		userMyProductReviewPage = (UserMyProductReviewPageObject) userCustomerPage.openDynamicPageAtMyAccountByPageName("My product reviews");
		
		Assert.assertEquals(userMyProductReviewPage.getReviewTextProduct(), reviewText);
		Assert.assertEquals(userMyProductReviewPage.getProductNameAddReview(), productName);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
