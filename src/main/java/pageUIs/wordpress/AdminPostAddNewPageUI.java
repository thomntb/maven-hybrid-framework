package pageUIs.wordpress;

public class AdminPostAddNewPageUI {

	public static final String TITLE_TEXTBOX = "css=h1[class*='editor-post-title']";
	public static final String BODY_TEXTBOX_BEFORE_CLICK = "css=p[role=button]";
	public static final String BODY_TEXTBOX_AFTER_CLICK = "css=p[role=document]";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "css=button.editor-post-publish-button";
	public static final String PUBLISH_OR_UPDATE_SUCCESS_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
