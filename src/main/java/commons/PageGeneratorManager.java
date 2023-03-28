package commons;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.admin.AdminDashboardsPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.UserWishListPageObject;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptionPageObject;
import pageObjects.nopCommerce.user.UserCartPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCompareProductPageObject;
import pageObjects.nopCommerce.user.UserCustomerPageObject;
import pageObjects.nopCommerce.user.UserDesktopPageObject;
import pageObjects.nopCommerce.user.UserDownloadableProductPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserNotebooksPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserRecentViewProductPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}

	public static UserBackInStockSubscriptionPageObject getUserBackInStockSubscriptionPage(WebDriver driver) {
		return new UserBackInStockSubscriptionPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static UserCustomerPageObject getUserCustomerPage(WebDriver driver) {
		return new UserCustomerPageObject(driver);
	}

	public static UserDownloadableProductPageObject getUserDownloadableProductPage(WebDriver driver) {
		return new UserDownloadableProductPageObject(driver);
	}

	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}

	public static UserOdersPageObject getUserOdersPage(WebDriver driver) {
		return new UserOdersPageObject(driver);
	}

	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardsPageObject getAdminDashbroadsPage(WebDriver driver) {
		return new AdminDashboardsPageObject(driver);
	}

	public static UserProductDetailPageObject getUserProductDetailPage(WebDriver driver) {
		return new UserProductDetailPageObject(driver);
	}

	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}

	public static UserWishListPageObject getUserWishlistPage(WebDriver driver) {
		return new UserWishListPageObject(driver);
	}

	public static UserCartPageObject getUserCartPage(WebDriver driver) {
		return new UserCartPageObject(driver);
	}
	
	public static UserCompareProductPageObject getUserCompareProductPage(WebDriver driver) {
		return new UserCompareProductPageObject(driver);
	}

	public static UserRecentViewProductPageObject getUserRecentViewProductPage(WebDriver driver) {
		return new UserRecentViewProductPageObject(driver);
	}
	
	public static UserNotebooksPageObject getNotebooksPage(WebDriver driver) {
		return new UserNotebooksPageObject(driver);
	}
	
	public static UserDesktopPageObject getDesktopPage(WebDriver driver) {
		return new UserDesktopPageObject(driver);
	}
}
