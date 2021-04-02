package com.selenium.orangehrm.TestCase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selenium.orangehrm.pageObjects.HomePageObjects;
import com.selenium.orangehrm.pageObjects.LoginPageObjects;
import com.selenium.orangehrm.testBase.TestBase;
import com.selenium.util.ExcelUtilClass;
import com.selenium.util.TestListeners;

// Test data, 

//Elements, WebDriver, Browser
@Listeners(TestListeners.class)
public class TestCaseTwo extends TestBase {

	LoginPageObjects loginPage;

	@Test(dataProvider = "loginDataInV")
	public void hrmLogin(String userName, String Password) {
		HomePageObjects home = new HomePageObjects(driver);

		loginPage = new LoginPageObjects(driver);

		loginPage.loginHRM(userName, Password);
		
		home.verifyMarketPlace();

	}

	/*
	 * @Test() public void hrmLogin2() {
	 * 
	 * loginPage = new LoginPageObjects(driver);
	 * 
	 * loginPage.loginHRM("Admin", "admin123");
	 * 
	 * HomePageObjects homePage = new HomePageObjects(driver);
	 * 
	 * homePage.verifyTopMenu();
	 * 
	 * }
	 */

	@DataProvider(name="loginDataInV")
	
	public String[][] getData() throws IOException{
		
		ExcelUtilClass excelUtil =new ExcelUtilClass("C:\\Users\\User\\Desktop\\Book1.xlsx");
		
		int rowCount = excelUtil.getRowCount("Sheet1");
		System.out.println(rowCount);
		int celloCount = excelUtil.getCellCount("Sheet1", 2);
		System.out.println(celloCount);
		
		String testData[][] = new String[rowCount][celloCount];
		
		for(int i = 1; i<=rowCount; i++){
			for(int j = 0; j<celloCount; j++){
				testData[i-1][j] = excelUtil.getCellData("Sheet1", i, j);
			}
		}
		
/*
			String[][] testData={
			{"Student", "buzz"},
			{"Student2", "buzz"},
			{"Student3", "buzz"},
			{"Student4", "buzz"},
			{"admin", "admin123"}
		};*/

	return testData;

}
/*
 * @DataProvider(name="loginDataV") public String[][] getDataV(){
 * 
 * String[][] testData={
 * 
 * {"Admin", "admin123"}, {"Student2", "buzz"}, {"Student3", "buzz"},
 * {"Student4", "buzz"}, {"Student5", "buzz"} };
 * 
 * return testData;
 * 
 * }
 */

}
