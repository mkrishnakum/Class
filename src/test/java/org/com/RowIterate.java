package org.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RowIterate 
{
	public static void main(String[] args) throws IOException 
	{
	File file = new File("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workBook=new XSSFWorkbook(stream);
	Sheet sheet=workBook.getSheet("Sheet1");
	
	//row count
	//int count = sheet.getPhysicalNumberOfRows();
	//System.out.println(count);
	//cellcount
	//int count = sheet.getPhysicalNumberOfcells();
	//System.out.println(count);
	for (int i = 0; i < args.length; i++) 
	{
		
	}
}
}