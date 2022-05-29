package com.actitime.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
	/*
	@DataProvider(name = "logindata")
	public static Object[][] loginDataprovider()
	{
		Object[][] obj = new String[3][2];
		
		obj[0][0] = "admin";
		obj[0][1] = "manager";
		obj[1][0] = "admin";
		obj[1][1] = "manager";
		obj[2][0] = "admin";
		obj[2][1] = "manager";
		
		return obj;
	}
	
	*/
	
	@DataProvider(name = "logindata")
	public static Object[][] loginDataprovider() throws IOException
	{
		File f = new File("./data/testdata.xlsx");		
		FileInputStream fio = new FileInputStream(f);
		
		// Creating the object of the Work Book	
		XSSFWorkbook wb = new XSSFWorkbook(fio);
		
		// Creating the object of WOrk Sheet
		XSSFSheet ws = wb.getSheet("logindata");
		
		// To get the number of used rows	
		int rows = ws.getLastRowNum();		
	
		Object[][] obj = new String[rows+1][2];
		
		for(int x=0; x<=rows;x++)
		{
			
			String page = ws.getRow(x).getCell(0).getStringCellValue();
			String element = ws.getRow(x).getCell(1).getStringCellValue();
			
			obj[x][0] = page;
			obj[x][1] = element;			
			
		}	
		wb.close();	
		return obj;
	}

}
