package com.selenium.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilClass {
	
	// Data read and data write
	
	public FileInputStream fis;
	public FileOutputStream fos;
	//Workbook
	public XSSFWorkbook workbook;
	//Sheet
	public XSSFSheet sheet;
	//Rows
	public XSSFRow row;
	//column
	public XSSFCell cell;
	String path = null;
	
	public ExcelUtilClass(String path) {
		this.path = path;
	}
	
	//Finding the number of rows in the sheet
	//Finding the number of cells in the row 
	// Get the cell data
	
	public int getRowCount(String sheetNumber) throws IOException{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetNumber);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		
		return rowCount;
	}
	
	public int getCellCount(String sheetNumber, int rowNum) throws IOException{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetNumber);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		
		return cellCount;
		
	}
	
	
	public String getCellData(String SheetName, int rowNum, int colNum) throws IOException{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(SheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try{
			data = formatter.formatCellValue(cell);
			//cell value;
			
		}catch(Exception e){
			data = 	"";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	
	public void setCellData(String SheetNumber, int rowNum, int colNum, String data) throws IOException{
		
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook();
		sheet = workbook.getSheet(SheetNumber);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		fos = new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
