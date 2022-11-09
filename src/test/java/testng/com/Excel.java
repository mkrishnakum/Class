package testng.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel {
	WebDriver driver;
	@BeforeClass
	private void beforemethod()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
	}
	@Test
	public void tc01(String s, String s1)
	{
		WebElement txtusername = driver.findElement(By.id("username"));
		txtusername.sendKeys(s);
	
		WebElement txtpass = driver.findElement(By.id("password"));
		txtpass.sendKeys(s1);
	}
     @DataProvider
     private Object[][] getData() throws IOException
     {
    	 return new Object [][] {{getDatafromCell(0,0),getDatafromCell(0,1)}};
     }
     public String getDatafromCell( int rownum, int cellnum) throws IOException {
    		
    		String res= "";
    		
    		File file = new File("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx");
    		FileInputStream stream = new FileInputStream(file);
    		Workbook book = new XSSFWorkbook(stream);
    		Sheet sheet = book.getSheet("Datas");
    		Row row = sheet.getRow(rownum);
    		Cell cell = row.getCell(cellnum);
    		CellType type = cell.getCellType();
    		
    		switch (type) {
    		case STRING:
    			res= cell.getStringCellValue();
    			break;
    		case NUMERIC:
    			if (DateUtil.isCellDateFormatted(cell)) {
    				Date dateCellValue = cell.getDateCellValue();
    				SimpleDateFormat dateFormat=  new SimpleDateFormat("dd/MM/yyyy");
    			res = dateFormat.format(dateCellValue);
    			    }
    			else 
    			{
    				double numericCellValue = cell.getNumericCellValue();
    				
    				long check = Math.round(numericCellValue);
    				if (numericCellValue==check) {
    					res = String.valueOf(check);
    				} 
    				else 
    				{
    					res= String.valueOf(numericCellValue);
    				}
    		}
    		default:
    			break;
    		}
    		return res;
}
}
