package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src=new File("./TestData/Data.xlsx");
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) 
		{
			System.out.println("Unable to read Excel file>>"+e.getMessage());
		} 
	}
	
	
//	public String getStringData(int SheetIndex,int rowno,int colno)
//	{
//		return wb.getSheetAt(SheetIndex).getRow(rowno).getCell(colno).getStringCellValue();
//	}
	@DataProvider(name="wordpressData")	
	public Object[][] Logindata(Method m)
	{
		Object[][] arrayObject=null;
		String TestName=m.getName();
		if(TestName.equalsIgnoreCase("ValidLoginApp"))
		{
			arrayObject=passLoginData("login");
		}
		else if(TestName.equalsIgnoreCase("InalidLoginApp"))
		{
			arrayObject=passLoginData("Inlogin");
		}
		return arrayObject;
		
	}
	
	public Object[][] passLoginData(String SheetName)
	{
		int row=getRowCount(SheetName);
		Object[][] credentials=new Object[row][2];
		for(int i=0;i<row;i++)
		{
			credentials[i][0]=getStringData(SheetName, i, 0);
			credentials[i][1]=getStringData(SheetName, i, 1);
		}
		return credentials;
	}
	
	public String getStringData(String SheetName,int rowno,int colno)
	{
		return wb.getSheet(SheetName).getRow(rowno).getCell(colno).getStringCellValue();
	}
	
//	public double getNumericData(String SheetName,int rowno,int colno)
//	{
//		return wb.getSheet(SheetName).getRow(rowno).getCell(colno).getNumericCellValue();
//	}

	public int getRowCount(String SheetName)
	{
		int row=wb.getSheet(SheetName).getLastRowNum();
		row=row+1;
		return row;
	}
}
