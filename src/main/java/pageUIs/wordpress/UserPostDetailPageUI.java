package pageUIs.wordpress;

public class UserPostDetailPageUI {
	public static final String TITLE_POST_TEXT = "xpath=//article//header/h2[text()='%s']";
	public static final String AUTHOR_POST_TEXT = "xpath=//article//h2[text()='%s']/parent::header/following-sibling::div//li[contains(text(),'%s')]";
	public static final String DATE_POST_TEXT = "xpath=//article//h2[text()='%s']/parent::header/following-sibling::div//li[contains(text(),'%s')]";
	public static final String BODY_POST_TEXT = "xpath=//article//h2[text()='%s']/parent::header/following-sibling::div/p[text()='%s']";
}
