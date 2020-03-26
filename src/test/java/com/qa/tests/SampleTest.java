package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.baseclass.BaseTest;
import com.qa.implementations.SampleImplementation;
import com.qa.utils.ExcelUtility;

public class SampleTest extends BaseTest {
	SampleImplementation implementation = new SampleImplementation();
	@Test
	public void searchTutorial() throws Exception {
		implementation.clickTutorialsDropdownMenu();
		implementation.selectCourseToLearn(ExcelUtility.getCellData(1, 0),ExcelUtility.getCellData(1, 1));
		implementation.assertCourseHeader(ExcelUtility.getCellData(1, 2));
		implementation.clickHomeIcon();
	}
}
