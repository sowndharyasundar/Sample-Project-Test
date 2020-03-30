package com.qa.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.utils.ExcelUtility;

public class BaseTest {
	private static WebDriver driver;
	private static WebDriverWait webdriverWait;
	private static ExtentReports report;
	private ExtentHtmlReporter htmlReporter;
	@BeforeTest(alwaysRun = true)
	public void setReport() throws Exception {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "./reports/test-report.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		ExcelUtility.setExcelFile(System.getProperty("user.dir") + "/Testdata.xlsx","Tutorial");
	}

	@Parameters({ "browser", "wait", "url" })
	@BeforeMethod(alwaysRun = true)
	public void setup(String browser, long waitTimeout, String url) {
		setDriver(browser, url);
		setWait(waitTimeout);
	}

	public void setDriver(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public ExtentReports getReport() {
		return report;
	}

	public void setWait(long waitTimeout) {
		webdriverWait = new WebDriverWait(driver, waitTimeout);
	}

	public WebDriverWait getWait() {
		return webdriverWait;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownDriver() {
		driver.quit();
	}

	@AfterTest(alwaysRun = true)
	public void tearDownReport() {
		report.flush();
	}
}