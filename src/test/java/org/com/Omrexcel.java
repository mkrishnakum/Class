package org.com;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Omrexcel 
{

	public static void main(String[] args)throws Exception {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://omrbranch.com/apitestingtraininginchennaiomr");
	 driver.manage().window().maximize();
	 
     File file = new File("D:\\Selenium Automation\\Class\\Excel\\countryList.xlsx");
	 Workbook workbook = new XSSFWorkbook();
	 Sheet sheet= workbook.createSheet("Sheet1");
	 WebElement country = driver.findElement(By.xpath("//select[@id='country-list']"));
	 Select sel = new Select (country);
	 List<WebElement> options = sel.getOptions();
	 for (int i = 0; i < options.size(); i++) 
	  {
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(0);
		cell.setCellValue(options.get(i).getText());
	
	  }
	 FileOutputStream out= new FileOutputStream(file);
	workbook.write(out);
	}
}

