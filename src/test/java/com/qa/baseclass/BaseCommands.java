package com.qa.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BaseCommands extends BaseTest {
	BaseTest baseTest = new BaseTest();

	public void clickElement(By locator) throws Exception{
		try {
			waitForElementClickability(locator);
			baseTest.getDriver().findElement(locator).click();
		} catch (Exception e) {
			throw e;
		}
	}

	public void enterText(By locator, String text, boolean clearField) throws Exception {
		try {
			if (clearField) {
				clearField(locator);
			}
			baseTest.getDriver().findElement(locator).sendKeys(text);
		} catch (Exception e) {
			throw e;
		}
	}

	public void selectDropdownByVisibileText(By locator, String visibleText) throws Exception {
		Select element = new Select(baseTest.getDriver().findElement(locator));
		try {
			element.selectByVisibleText(visibleText);
		} catch (Exception e) {
			throw e;
		}
	}

	public void clearField(By locator) throws Exception {
		try {
			baseTest.getDriver().findElement(locator).clear();
		} catch (Exception e) {
			throw e;
		}
	}

	public void assertElementText(By locator, String expectedText) throws Exception {
		try {
			String actualValue = baseTest.getDriver().findElement(locator).getText();
			Assert.assertEquals(expectedText, actualValue);
		} catch (Exception e) {
			throw e;
		}
	}

	public void assertElementDisplayed(By locator) throws Exception {
		try {
			boolean flag = baseTest.getDriver().findElement(locator).isDisplayed();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			throw e;
		}
	}

	public void assertElementEnabled(By locator) throws Exception {
		try {
			boolean flag = baseTest.getDriver().findElement(locator).isEnabled();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			throw e;
		}
	}

	public void assertElementSelected(By locator) throws Exception {
		try {
			boolean flag = baseTest.getDriver().findElement(locator).isSelected();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			throw e;
		}
	}

	public void assertElementAttribute(By locator, String attributeName, String expectedValue) throws Exception {
		try {
			String actualValue = baseTest.getDriver().findElement(locator).getAttribute(attributeName);
			Assert.assertEquals(expectedValue, actualValue);
		} catch (Exception e) {
			throw e;
		}
	}

	public void waitForElementVisibility(By locator) throws Exception {
		try {
			baseTest.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			throw e;
		}
	}

	public void waitForElementInvisibility(By locator) throws Exception {
		try {
			baseTest.getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			throw e;
		}
	}

	public void waitForElementClickability(By locator) throws Exception {
		try {
			baseTest.getWait().until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			throw e;
		}
	}
}