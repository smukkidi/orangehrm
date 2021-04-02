package com.selenium.orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.selenium.util.TestListeners;

public class HomePageObjects {
	WebDriver driver;
	
	@FindBy(xpath="//b[normalize-space()='Admin']")
	WebElement menu_Admin;
	
	@FindBy(xpath="//b[normalize-space()='PIM']")
	WebElement menu_PIM;
	
	@FindBy(xpath="//b[normalize-space()='Leave']")
	WebElement menu_Leave;
	
	@FindBy(xpath = "//input[@id='MP_link']")
	WebElement MarketPlace;
	
	
	public HomePageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	TestListeners listener = new TestListeners();
	public void verifyMarketPlace(){
		boolean mp = false;
		try {
			mp = MarketPlace.isDisplayed();
			Assert.assertTrue(mp);
			listener.getExtent().log(Status.PASS, "Market place element is present.");
		} catch (Exception e) {
			Assert.assertFalse(mp);
			listener.getExtent().log(Status.FAIL, "Market place element is not present.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verifyTopMenu(){
		boolean admin = menu_Admin.isDisplayed();
		Assert.assertEquals(admin, true, "Admin top menu not dispalayed.");
		boolean pim = menu_PIM.isDisplayed();
		Assert.assertEquals(pim, true, "PIM top menu not dispalayed.");
		boolean leave = menu_Leave.isDisplayed();
		Assert.assertEquals(leave, true, "Admin top menu not dispalayed.");
	}

}
