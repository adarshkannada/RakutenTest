package com.qa.rakuten.util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class TestData {
	static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    
    public TestData(String pathName, String sheetName){
        try{
            workbook = new XSSFWorkbook(pathName);
            sheet = workbook.getSheet(sheetName);
        }catch(Exception e){
            e.getCause();
            e.getMessage();
            e.printStackTrace();
        }
        
    }
    
    public void getRowCount(){
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);
    }

    public Object getData(){
    	int rowCount = sheet.getPhysicalNumberOfRows();
    	int colCount = sheet.getRow(0).getLastCellNum();
    	DataFormatter dataFormatter = new DataFormatter();
    	Object value = null;
    	
    	for(int rowNumber = 1; rowNumber < rowCount; rowNumber++) {
    		for(int columnNumber = 0; columnNumber < colCount; columnNumber++) {
    			 value = dataFormatter.formatCellValue(sheet.getRow(rowNumber).getCell(columnNumber));
    			 //System.out.println(value);
    		}
    	}
        return value;
    }
    

    
	
}
