package org.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass 
    {
    static WebDriver driver;
public static void getDriver()
    {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver(); 
    }
public static void enterApplnUrl(String Url)
    {
	  driver.get(Url);
    }
public static void maximizewindow()
   {
	driver.manage().window().maximize();
    }
public static void elementSendkeysJs(WebElement element,String data)
   {
	JavascriptExecutor executor=(JavascriptExecutor) driver;
	executor.executeScript("arguments[0].setAttribute('value','"+data+"')",element);
   }
public static void elementClick(WebElement element)
   {
	element.click();
   }
public static WebElement findLocatorByID(String attributeValue)
   {
	WebElement element = driver.findElement(By.id(attributeValue));
	return element;
   }
public static WebElement findLocatorByName(String attributeValue)
   {
	WebElement element = driver.findElement(By.name(attributeValue));
	return element;
   }
public static WebElement findLocatorByClassName(String attributeValue)
   {
	WebElement element = driver.findElement(By.className(attributeValue));
	return element;
   }
public static WebElement findLocatorByXpath(String attributeValue)
    {
	WebElement element = driver.findElement(By.xpath(attributeValue));
	return element;
    }
public static String getAppTitle()
    {
	String title = driver.getTitle();
	return title;
	}
public static String getApplnUrl(String string)
    {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
	}
public static void closewindow()
    {
	driver.close();
    }
public static void quitwindow()
   {
	driver.quit();
   }
public static String elementGetText(WebElement element)
   {
	String text = element .getText();
	return text;
   }
public static String elementGetAttributeValue(WebElement element)
   {
	String attribute = element.getAttribute("value");
	return attribute;
   }
public static String elementGetAttributeValue(WebElement element,String attributeName)
   {
	String attribute = element.getAttribute(attributeName);
	return attribute;
   }
public static void selectByVisibleText(WebElement element,String text) 
   {
	Select select = new Select(element);
	select.selectByVisibleText(text);
   }
public static void SelectByAttribute(WebElement element,String value) 
   {
	Select select = new Select(element);
	select.selectByValue(value);
   }
public static void SelectByIndex(WebElement element,int index) 
   {
	Select select = new Select(element);
	select.selectByIndex(index);
   }
public static void doubleClick(WebElement element)
  {
	Actions actions = new Actions (driver);
    actions.doubleClick(element).perform();
  }
public static void switchtochildwindow()
{
String handle = driver.getWindowHandle();
	Set <String> handles = driver.getWindowHandles();
	{
		for(String x:handles)
		{
			if(handle.equals(x))
			{
				driver.switchTo().window(x);
			}
		}
	}
}

public static void rightClick(WebElement element)
 {
	Actions actions = new Actions (driver);
    actions.contextClick(element).perform();
 }
public static void dragandDrop(WebElement source, WebElement destination)
  {
	Actions actions = new Actions (driver);
    actions.dragAndDrop(source, destination).perform();
   } 
public static void enterValuetoTextbox(WebElement element,String text)
   {
	element.sendKeys(text,Keys.ENTER);
   }
public static void mouseMovetoElement(WebElement element)
{
	Actions actions = new Actions (driver);
   actions.moveToElement(element).perform();

}
public static void Takescreenshot()
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	ts.getScreenshotAs(OutputType.FILE);
}
public static void cleartextbox(WebElement element)
{
	element.clear();
}
public static void getAllwindowsId()
{
	Set<String> handles = driver.getWindowHandles();
}
public static void getparentwindow() 
{
	String string = driver.getWindowHandle();
}
public static void deselectAll(WebElement element)
{
	Select select = new Select(element);
	select.deselectAll();
   }
public static void deselectbyvisibletext(WebElement element,String text) 
{
	Select select = new Select(element);
	select.selectByValue(text);
}
public static void deselectbyvalue(WebElement element,String value) 
  {
	Select select = new Select(element);
	select.selectByValue(value);
  }
public static void deselectByIndex(WebElement element,int index) 
  {
	Select select = new Select(element);
	select.selectByIndex(index);
}
public static void implicitwait(long second)
{
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
}

public static String getdatafromcell(String Sheetname,int rownum,int cellnum)
{
	return Sheetname;
	
}
public static void implicitWait(long arg0) 
{
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(arg0));
}
public static void elementsendkeys(WebElement element,String data) {
	element.sendKeys(data);
}
public static String getDataformCell(String path,String sheetName, int rownum, int cellnum) throws IOException {
	
	String res= "";
	
	File file = new File(path);
	FileInputStream stream = new FileInputStream(file);
	Workbook book = new XSSFWorkbook(stream);
	Sheet sheet = book.getSheet(sheetName);
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
		else {
			double numericCellValue = cell.getNumericCellValue();
			
			long check = Math.round(numericCellValue);
			if (numericCellValue==check) {
				res = String.valueOf(check);
			} else {
				res= String.valueOf(numericCellValue);
			}
	}
	default:
		break;
	}
	return res;
}
}
