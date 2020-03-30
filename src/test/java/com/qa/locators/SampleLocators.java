package com.qa.locators;

import org.openqa.selenium.By;

public class SampleLocators {
	public By tutorialsDropdown() {
		return By.xpath("//a[@id='navbtn_tutorials']/i[contains(@class,'fa-caret-dow')]");
	}

	public By tutorialLink(String courseSection,String courseName) {
		return By.xpath("//h3[text()='"+courseSection+"']/following-sibling::a[text()='"+courseName+"']");
	}
	
	public By tutorialHeader(){
		return By.xpath("//div[@id='mainLeaderboard']//following-sibling::h1");

	}

	public By homeIcon() {
		return By.xpath("//a[contains(@class,'fa-home')]");
	}
}
