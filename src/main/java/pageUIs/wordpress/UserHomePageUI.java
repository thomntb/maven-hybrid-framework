package pageUIs.wordpress;

public class UserHomePageUI  {

	public static final String TITLE_POST_TEXT = "xpath=//article//a[contains(text(),'%s')]";
	public static final String AUTHOR_POST_TEXT = "xpath=//article//a[contains(text(),'%s')]/following-sibling::div//li[contains(text(),'%s')]";
	public static final String DATE_POST_TEXT = "xpath=//article//a[contains(text(),'%s')]/following-sibling::div//li[contains(text(),'%s')]";
	public static final String BODY_POST_TEXT = "xpath=//article//a[contains(text(),'%s')]/following-sibling::div[@class='buzz-description']/p[text()='%s']";
	public static final String SEARCH_POST_TEXTBOX = "xpath=//section[@id='secondaryright']//input[@type='search']";
	public static final String SEARCH_POST_BUTTON = "xpath=//section[@id='secondaryright']//button[@type='submit']";
}
