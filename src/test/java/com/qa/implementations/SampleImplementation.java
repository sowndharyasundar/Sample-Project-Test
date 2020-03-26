package com.qa.implementations;

import com.qa.baseclass.BaseCommands;
import com.qa.locators.SampleLocators;

public class SampleImplementation {
	BaseCommands baseCommands = new BaseCommands();
	SampleLocators locators = new SampleLocators();

	public void clickTutorialsDropdownMenu() throws Exception{
		baseCommands.clickElement(locators.tutorialsDropdown());
	}

	public void selectCourseToLearn(String courseSection, String courseName) throws Exception {
		baseCommands.clickElement(locators.tutorialLink(courseSection,courseName));
	}

	public void assertCourseHeader(String expectedText) throws Exception {
		baseCommands.assertElementText(locators.tutorialHeader(), expectedText);
	}

	public void clickHomeIcon() throws Exception {
		baseCommands.clickElement(locators.homeIcon());
	}
}
