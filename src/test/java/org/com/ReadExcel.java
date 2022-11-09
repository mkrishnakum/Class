package org.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{
public static void main(String[] args) throws IOException 
	{
	File file = new File("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workBook=new XSSFWorkbook(stream);
	Sheet sheet=workBook.getSheet("Sheet1");
	Row row=sheet.getRow(2);
	Cell cell=row.getCell(1);
	System.out.println(cell);
	String value =cell.getStringCellValue();
	if(value.equals("Hotel sunshine"))
	{
		cell.setCellValue("java");
	}
	FileOutputStream out = new FileOutputStream(file); 
    workBook.write(out);
    }
}