package com.selenium.orangehrm.utils;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.selenium.util.TestListeners;

public class SeleniumHelper {
	TestListeners listener = new TestListeners();
	
	public void typeTextInTextBox(WebElement element, String textToBeElenter, String elementName){
		
		try {
			
			element.isDisplayed();
			element.isEnabled();
			element.clear();
			element.sendKeys(textToBeElenter);
			listener.extentTest.get().log(Status.PASS, "Entered text in to "+elementName);
		} catch (Exception e) {
			listener.extentTest.get().log(Status.FAIL, "Unable to enter the text in "+elementName);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void btnClick(WebElement element){
		element.isDisplayed();
		element.isEnabled();
		element.click();
	}

}
