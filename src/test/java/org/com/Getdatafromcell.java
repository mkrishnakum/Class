package org.com;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Getdatafromcell 
{
  WebDriver driver;
public String getdatafromcell(String Sheetname,int rownum,int cellnum)
{
	 String res="";
	 File file = new File("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx");
	 Workbook workbook = new XSSFWorkbook();
	 Sheet sheet= workbook.createSheet("Sheet1");
	 Row row = sheet.getRow(rownum);
	 Cell cell = row.getCell(3);
	 CellType type=cell.getCellType();
	 switch(type)
	 {
	 case STRING:
		 res=cell.getStringCellValue();
		 break;
	 case NUMERIC:
		 if (DateUtil.isCellDateFormatted(cell))
		 {
			 Date datecellvalue=cell.getDateCellValue();
			 SimpleDateFormat dateformat = new SimpleDateFormat ("dd/mm/yyyy");
			 res=dateformat.format(datecellvalue);
		 }
		 else
		 {
			 double numericcellvalue = cell.getNumericCellValue();
			 long check = Math.round(numericcellvalue);
			 if(numericcellvalue==check) 
			 {
				res=String.valueOf(check);
			 }
			 else 
			 {
				 res=String.valueOf(numericcellvalue);
			 }
		 }
			 default:
			 break;
		
	 }
		 return res;
		 
	 }
}

