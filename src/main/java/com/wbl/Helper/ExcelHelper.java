package com.wbl.Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	private static Logger logger=Logger.getLogger(ExcelHelper.class);
 public static Object[][] getData(String filename){
	 logger.info("Readig data from excel file");
	 Object[][] data=null;
	 XSSFWorkbook wb=null;
	 try {
		wb=new XSSFWorkbook(new FileInputStream(filename));
		XSSFSheet sheet=wb.getSheet("postData");
		int rows=sheet.getLastRowNum();
		data=new Object[rows][];
		
		for(int i=1;i<rows;i++){
			XSSFRow row=sheet.getRow(i); 
			int cols=row.getLastCellNum();
			String[] coldata=new String[cols];
			
			for(int j=0;j<cols;j++){
				coldata[j]=row.getCell(j).getStringCellValue();
			}
			data[i-1]=coldata;
			
		}
		
	} catch (FileNotFoundException e) {
		logger.error("File not found - please give valid file name");
	} catch (IOException e) {
		 logger.error("Issue in reading given excel file");
	}finally{
		if(wb!=null)
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	 
	 
	 
	 
	 return data;
 }
}