package com.selenium.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

@Test
public class ExcelReader {

	public void readExcel() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\User\\3D Objects\\TestData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis); // workbook

		XSSFSheet sheet = wb.getSheet("Sheet1"); // Sheet

		Iterator<Row> itr = sheet.iterator(); // Iterating over excel file

		while (itr.hasNext()) {
			Row row = itr.next();
			// System.out.println(row);

			Iterator<Cell> cellitr = row.iterator();

			while (cellitr.hasNext()) {
				Cell cell = cellitr.next();
				
				switch (cell.getCellTypeEnum()){
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
				case STRING:
					System.out.println(cell.getStringCellValue());
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					/*if(DateUtil.isCellDateFormatted(cell)){
						System.out.println(cell.getDateCellValue());
					}else {
						System.out.println(cell.getNumericCellValue());
					}*/
					
				case FORMULA:
					System.out.println(cell.getCellFormula());
				}
				
				/*if(cell.getCellType()==CellType.STRING){
					System.out.print(cell.getStringCellValue());
				}else if(cell.getCellType()==CellType.NUMERIC){
				
					System.out.print(cell.getNumericCellValue());
				}*/
			}
			System.out.println();

		}
	}

}
