package com.selenium.orangehrm.TestCase;

import org.testng.annotations.Test;

import com.selenium.orangehrm.pageObjects.LoginPageObjects;
import com.selenium.orangehrm.testBase.TestBase;


// Test data, 

//Elements, WebDriver, Browser

public class TestCaseThree extends TestBase {
	
	LoginPageObjects loginPage ;
	
	@Test
	public void hrmLogin() {
		
		loginPage = new LoginPageObjects(driver);
		
		loginPage.loginHRM("Admin", "admin123");
		
	}
}
