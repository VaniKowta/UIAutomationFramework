package com.util;

import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	
	private static Logger log = Logger.getLogger(ExcelConfig.class);
	
	private static final String DATA_PATH = "C:\\Users\\rkowt\\workspace\\AutomationWhiteboxQa\\resources\\testData\\loginData.xlsx";
	
	public static Object[][]getData(String filepath){
		
		Object[][]data = null;
		
		try {
			XSSFWorkbook wb = new XSSFWorkbook (new FileInputStream(DATA_PATH));
			
			XSSFSheet sheet = wb.getSheetAt(0);
			
			int noOfRows = sheet.getLastRowNum()+1;
			
			data = new Object[noOfRows-1][];
			
			for(int i=1;i<noOfRows;i++){
				
			Row row = 	sheet.getRow(i);
			
			int noOfColumns= row.getLastCellNum();
			
			String[]columnData = new String[noOfColumns];
			
			for(int j=0;j<noOfColumns;j++){
				
			Cell cell = row.getCell(j);
			
			columnData[j]=cell.getStringCellValue();
			}
			
			data[i-1]=columnData;
			}
			
			//wb.close();


			} catch (Exception e) {
			log.error(e);
		}
            return data;
        }

}
