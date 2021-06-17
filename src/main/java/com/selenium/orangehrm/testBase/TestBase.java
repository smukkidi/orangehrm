package com.selenium.orangehrm.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	String browser = "Chrome";
	String URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	public WebDriver driver;

	//This is for Beformethod will launch the bt=rowser and load the URL
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(browser);
		driver.get(URL);
		
		
	}

	//This method will close the browser
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	//This is the core method for launching the browser
	public void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

	}

}
