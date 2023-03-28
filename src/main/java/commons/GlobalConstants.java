package commons;

import java.io.File;

public class GlobalConstants {

	public static final String DEV_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String TESTING_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String STAGING_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String PRE_PROD_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String PROD_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static final String USER_WORDPRESS_URL = "http://megau.blog/";
	public static final String ADMIN_WORDPRESS_URL = "https://megau.blog/wp-admin/";
	public static final long LONG_TIMEOUT = 45;
	public static final long SHORT_TIMEOUT = 5;
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFile" + File.separator;
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImage" + File.separator;
	
}
