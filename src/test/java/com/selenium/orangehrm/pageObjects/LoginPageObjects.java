package com.selenium.orangehrm.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.orangehrm.utils.SeleniumHelper;

public class LoginPageObjects extends SeleniumHelper{
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement txt_UserName;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement txt_Password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement btn_Login;
	
	
	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginHRM(String userName, String password){
		
		typeTextInTextBox(txt_UserName, userName, "User Name Textbox");
		typeTextInTextBox(txt_Password, password, "Password textbox");
		btnClick(btn_Login);
		
		if(driver.getTitle().equals("OrangeHRM")){
			Assert.assertTrue(true);
			
		}else{
			Assert.assertFalse(false);
		}
		
		/*txt_UserName.isEnabled();
		txt_UserName.clear();
		txt_UserName.sendKeys(userName);*/
		
		/*txt_Password.isEnabled();
		txt_Password.clear();
		txt_Password.sendKeys(password);*/
		
		/*btn_Login.isEnabled();
		btn_Login.click();*/
	}

}
