package commons;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	protected final Log log;

	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(99999);
	}

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		
		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox1 = new FirefoxOptions();
			optionFirefox1.setAcceptInsecureCerts(false);
			driver = new FirefoxDriver(optionFirefox1);
			break;
		case H_FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox = new FirefoxOptions();
			optionFirefox.addArguments("--headless");
			optionFirefox.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(optionFirefox);
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionChrome1 = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			
			optionChrome1.setExperimentalOption("prefs", prefs);
			optionChrome1.setAcceptInsecureCerts(true);
			optionChrome1.setExperimentalOption("useAutomationExtension", false);
			optionChrome1.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(optionChrome1);
			break;
		case H_CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionChrome = new ChromeOptions();
			optionChrome.addArguments("--headless");
			optionChrome.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(optionChrome);
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case COCCOC:
			WebDriverManager.chromedriver().driverVersion("109.0.5414.74").setup();
			ChromeOptions optionCocCoc = new ChromeOptions();
			optionCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(optionCocCoc);
			break;
		case BRAVE:
			WebDriverManager.chromedriver().driverVersion("110.0.5481.77").setup();
			ChromeOptions optionBrave = new ChromeOptions();
			optionBrave.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(optionBrave);
			break;
		case OPERA:
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("Browser is incorrect name");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.DEV_PAGE_URL);
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String environmentName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		
		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox1 = new FirefoxOptions();
			optionFirefox1.setAcceptInsecureCerts(false);
			driver = new FirefoxDriver(optionFirefox1);
			break;
		case H_FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox = new FirefoxOptions();
			optionFirefox.addArguments("--headless");
			optionFirefox.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(optionFirefox);
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionChrome1 = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			
			optionChrome1.setExperimentalOption("prefs", prefs);
			optionChrome1.setAcceptInsecureCerts(true);
			optionChrome1.setExperimentalOption("useAutomationExtension", false);
			optionChrome1.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(optionChrome1);
			break;
		case H_CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionChrome = new ChromeOptions();
			optionChrome.addArguments("--headless");
			optionChrome.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(optionChrome);
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case COCCOC:
			WebDriverManager.chromedriver().driverVersion("109.0.5414.74").setup();
			ChromeOptions optionCocCoc = new ChromeOptions();
			optionCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(optionCocCoc);
			break;
		case BRAVE:
			WebDriverManager.chromedriver().driverVersion("110.0.5481.77").setup();
			ChromeOptions optionBrave = new ChromeOptions();
			optionBrave.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(optionBrave);
			break;
		case OPERA:
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("Browser is incorrect name");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(environmentName);
		return driver;
	}

	private String getEnvironment(String environmentName) {
		String envUrl = "";
		EnvironmentList environment = EnvironmentList.valueOf(environmentName.toUpperCase());
		
		switch (environment) {
		case DEV:
			envUrl = GlobalConstants.DEV_PAGE_URL;
			break;
		case TESTING:
			envUrl = GlobalConstants.TESTING_PAGE_URL;
			break;
		case STAGING:
			envUrl = GlobalConstants.STAGING_PAGE_URL;
			break;
		case PRE_PROD:
			envUrl = GlobalConstants.PRE_PROD_PAGE_URL;
			break;
		case PROD:
			envUrl = GlobalConstants.PROD_PAGE_URL;
			break;
		case USER:
			envUrl = GlobalConstants.USER_WORDPRESS_URL;
			break;
		case ADMIN:
			envUrl = GlobalConstants.ADMIN_WORDPRESS_URL;
			break;
		default:
			envUrl = null;
			break;
		}
		return envUrl;
	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = GlobalConstants.OS_NAME;
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return String.valueOf(now.getYear());
	}

	protected String getCurrentDay() {
		return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}
}
