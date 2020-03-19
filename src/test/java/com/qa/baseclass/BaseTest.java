package com.qa.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	private WebDriver driver;
	private static ExtentReports report;
	private ExtentHtmlReporter htmlReporter;

	@BeforeTest
	public void setReport() {
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\Sowndharya\\workspace\\ExtentReport\\reports\\test-report.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
	}

	@BeforeMethod
	public void setDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static ExtentReports getReport() {
		return report;
	}

	@AfterMethod
	public void tearDownDriver() {
		driver.quit();
	}

	@AfterTest
	public void tearDownReport() {
		report.flush();
	}
}
