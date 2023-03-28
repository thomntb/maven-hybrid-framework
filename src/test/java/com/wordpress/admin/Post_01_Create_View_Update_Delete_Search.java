package com.wordpress.admin;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailPO;
import pageObject.wordpress.UserSearchPostPO;
import pageObjects.nopCommerce.user.UserSearchPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Post_01_Create_View_Update_Delete_Search extends BaseTest {

	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostSearchPO adminPostSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private UserHomePO userHomePage;
	private UserPostDetailPO userPostDetailPage;
	private UserSearchPostPO userSearchPostPage;

	String adminUsername = "automationfc";
	String adminPassword = "automationfc";
	String urlPostSearch;
	int randomData = randomNumber();
	String titleTextbox = "Live coding " + randomData;
	String bodyTextbox = "Live coding body " + randomData;
	String editTitleTextbox = "Edit coding " + randomData;
	String editBodyTextbox = "Edit coding body " + randomData;
	String author = "automationfc";
	String adminUrl, userUrl;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browser, String adminUrl, String userUrl) {
		driver = getBrowserDriver(browser, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		this.adminUrl = adminUrl;
		this.userUrl = userUrl;

		log.info("Precondition: enter to username '" + adminUsername + "'");
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Precondition: enter to password '" + adminPassword + "'");
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Precondition: click to 'Login' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create_New_Add() {
		log.info("Create - Step 01: click to 'Post' menu");
		adminPostSearchPage = adminDashboardPage.clickToPostMenu();

		log.info("Create - Step 02: get URL at 'Post Search' page");
		urlPostSearch = adminPostSearchPage.getPostSearchUrl();

		log.info("Create - Step 03: click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create - Step 04: enter to tilte textbox");
		adminPostAddNewPage.enterToTilteTextbox(titleTextbox);

		log.info("Create - Step 05: enter to body textbox");
		adminPostAddNewPage.enterToBodyTextbox(bodyTextbox);

		log.info("Create - Step 06: click to 'Publish' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Create - Step 07: verify 'Publish' message is displayed");
		Assert.assertTrue(adminPostAddNewPage.isgetPostAddNewOrUpdateSuccessMessage("Post published."));

	}

	@Test
	public void Post_02_Search_And_View() {
		log.info("Search - Step 01: open 'Post Search' page");
		adminPostSearchPage = adminPostAddNewPage.openPostSearchPageUrl(urlPostSearch);

		log.info("Search - Step 02: enter to 'Search' textbox is '" + titleTextbox + "'");
		adminPostSearchPage.enterToSearchTextbox(titleTextbox);

		log.info("Search - Step 03: click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Search - Step 04: verify search table contains: '" + titleTextbox + "'");
		Assert.assertEquals(adminPostSearchPage.getPostSearchTable("title"), titleTextbox);

		log.info("Search - Step 05: verify search table contains: '" + author + "'");
		Assert.assertEquals(adminPostSearchPage.getPostSearchTable("author"), author);

		log.info("Search - Step 06: open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(this.userUrl);

		log.info("Search - Step 07: verify Post info displayed at Home page");
		Assert.assertTrue(userHomePage.isPostInfoTitleDisplayByTitlePost(titleTextbox));
		Assert.assertTrue(userHomePage.isPostInfoBodyDisplayByTitlePost(titleTextbox, bodyTextbox));
		Assert.assertTrue(userHomePage.isPostInfoAuthorDisplayByTitlePost(titleTextbox, author));
		Assert.assertTrue(userHomePage.isPostInfoDateDisplayByTitlePost(titleTextbox, currentDay));

		log.info("Search - Step 08: click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(titleTextbox);

		log.info("Search - Step 09: verify Post infor displayed at Post Detail page");
		Assert.assertTrue(userPostDetailPage.isPostInfoTitleDisplayByTitlePost(titleTextbox));
		Assert.assertTrue(userPostDetailPage.isPostInfoBodyDisplayByTitlePost(titleTextbox, bodyTextbox));
		Assert.assertTrue(userPostDetailPage.isPostInfoAuthorDisplayByTitlePost(titleTextbox, author));
		Assert.assertTrue(userPostDetailPage.isPostInfoDateDisplayByTitlePost(titleTextbox, currentDay));

	}

	@Test
	public void Post_03_Update() {
		log.info("Update - Step 01: open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(this.adminUrl);

		log.info("Update - Step 02: click to 'Post' menu and open Post Search page");
		adminPostSearchPage = adminDashboardPage.clickToPostMenu();

		log.info("Update - Step 03: enter to 'Search' textbox is '" + titleTextbox + "'");
		adminPostSearchPage.enterToSearchTextbox(titleTextbox);

		log.info("Update - Step 04: click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Update - Step 05: click to Post Title row ");
		adminPostSearchPage.clickToPostTitle(titleTextbox);

		log.info("Update - Step 06: enter update to title textbox is '" + editTitleTextbox + "'");
		adminPostAddNewPage.enterToTilteTextbox(editTitleTextbox);

		log.info("Update - Step 07: enter update to body textbox is '" + editBodyTextbox + "'");
		adminPostAddNewPage.enterToEditBodyTextbox(editBodyTextbox);

		log.info("Update - Step 08: click to 'Update' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Update - Step 09: verify 'Publish' message is displayed");
		Assert.assertTrue(adminPostAddNewPage.isgetPostAddNewOrUpdateSuccessMessage("Post updated."));
		
		log.info("Update - Step 10: open 'Post Search' page");
		adminPostSearchPage = adminPostAddNewPage.openPostSearchPageUrl(urlPostSearch);

		log.info("Update - Step 11: enter to 'Search' textbox is '" + editTitleTextbox + "'");
		adminPostSearchPage.enterToSearchTextbox(editTitleTextbox);

		log.info("Update - Step 12: click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Update - Step 13: verify search table contains: '" + editTitleTextbox + "'");
		Assert.assertEquals(adminPostSearchPage.getPostSearchTable("title"), editTitleTextbox);

		log.info("Update - Step 14: verify search table contains: '" + author + "'");
		Assert.assertEquals(adminPostSearchPage.getPostSearchTable("author"), author);

		log.info("Update - Step 15: open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(this.userUrl);

		log.info("Update - Step 16: verify Post info displayed at Home page");
		Assert.assertTrue(userHomePage.isPostInfoTitleDisplayByTitlePost(editTitleTextbox));
		Assert.assertTrue(userHomePage.isPostInfoBodyDisplayByTitlePost(editTitleTextbox, editBodyTextbox));
		Assert.assertTrue(userHomePage.isPostInfoAuthorDisplayByTitlePost(editTitleTextbox, author));
		Assert.assertTrue(userHomePage.isPostInfoDateDisplayByTitlePost(editTitleTextbox, currentDay));

		log.info("Update - Step 17: click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(editTitleTextbox);

		log.info("Update - Step 18: verify Post infor displayed at Post Detail page");
		Assert.assertTrue(userPostDetailPage.isPostInfoTitleDisplayByTitlePost(editTitleTextbox));
		Assert.assertTrue(userPostDetailPage.isPostInfoBodyDisplayByTitlePost(editTitleTextbox, editBodyTextbox));
		Assert.assertTrue(userPostDetailPage.isPostInfoAuthorDisplayByTitlePost(editTitleTextbox, author));
		Assert.assertTrue(userPostDetailPage.isPostInfoDateDisplayByTitlePost(editTitleTextbox, currentDay));
	}

	@Test
	public void Post_04_Delete() {
		log.info("Delete - Step 01: open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(this.adminUrl);

		log.info("Delete - Step 02: click to 'Post' menu and open Post Search page");
		adminPostSearchPage = adminDashboardPage.clickToPostMenu();

		log.info("Delete - Step 03: enter to 'Search' textbox is '" + editTitleTextbox + "'");
		adminPostSearchPage.enterToSearchTextbox(editTitleTextbox);

		log.info("Delete - Step 04: click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Delete - Step 05: hover mouse to 'Post title'");
		adminPostSearchPage.hoverToPostTitle(editTitleTextbox);
		
		log.info("Delete - Step 06: click to 'Track' link");
		adminPostSearchPage.clickToTrackLink(editTitleTextbox, "Trash");
		
		log.info("Delete - Step 07: enter to 'Search' textbox is '" + editTitleTextbox + "'");
		adminPostSearchPage.enterToSearchTextbox(editTitleTextbox);

		log.info("Delete - Step 08: click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Delete - Step 09: verify no search data");
		Assert.assertTrue(adminPostSearchPage.isNoPostFoundDataMessageDisplay("No posts found."));
		
		log.info("Delete - Step 10: open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(this.userUrl);
		
		log.info("Delete - Step 11: enter to 'Search' textbox");
		userHomePage.enterToSearchPostTextbox(editTitleTextbox);
		
		log.info("Delete - Step 12: enter to 'Search' button");
		userSearchPostPage = userHomePage.clickToSearchPostButton();
		
		log.info("Delete - Step 13: verify no found search data");
		Assert.assertTrue(userSearchPostPage.isNoSearchDataMessageDisplayed("Sorry, but nothing matched your search terms. Please try again with some different keywords."));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
