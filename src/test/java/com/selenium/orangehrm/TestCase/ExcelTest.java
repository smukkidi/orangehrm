package com.selenium.orangehrm.TestCase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.selenium.util.ExcelUtilClass;

public class ExcelTest {
	
	@Test
	public void tesdata() throws IOException{
		String[][] data = excelTestMethod();
		
	
	}
	
	@Test
	public String[][] excelTestMethod() throws IOException{
		
		ExcelUtilClass excelUtil = new ExcelUtilClass("C:\\Users\\User\\Desktop\\Book1.xlsx");
		
		
		int rowCount = excelUtil.getRowCount("Sheet1");
		System.out.println(rowCount);
		int celloCount = excelUtil.getCellCount("Sheet1", 2);
		System.out.println(celloCount);
		
		String loginData[][] = new String[rowCount][celloCount];
		
		for(int i = 0; i<rowCount; i++){
			for(int j = 0; j<celloCount; j++){
				loginData[i][j] = excelUtil.getCellData("Sheet1", i, j);
			}
		}
		
		return loginData;
		
	}

}
