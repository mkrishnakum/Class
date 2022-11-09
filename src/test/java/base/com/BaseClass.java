package base.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
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

	public class BaseClass 
    {
     public static WebDriver driver;
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
public void elementSendkeysJs(WebElement element,String data)
   {
	JavascriptExecutor executor=(JavascriptExecutor) driver;
	executor.executeScript("arguments[0].setAttribute('value','"+data+"')",element);
   }
public void elementClick(WebElement element)
   {
	element.click();
   }
public WebElement findLocatorByID(String attributeValue)
   {
	WebElement element = driver.findElement(By.id(attributeValue));
	return element;
   }
public WebElement findLocatorByName(String attributeValue)
   {
	WebElement element = driver.findElement(By.name(attributeValue));
	return element;
   }
public WebElement findLocatorByClassName(String attributeValue)
   {
	WebElement element = driver.findElement(By.className(attributeValue));
	return element;
   }
public WebElement findLocatorByXpath(String attributeValue)
    {
	WebElement element = driver.findElement(By.xpath(attributeValue));
	return element;
    }
public String getAppTitle()
    {
	String title = driver.getTitle();
	return title;
	}
public String getApplnUrl(String string)
    {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
	}
public void closewindow()
    {
	driver.close();
    }
public static void quitwindow()
   {
	driver.quit();
   }
public String elementGetText(WebElement element)
   {
	String text = element .getText();
	return text;
   }
public String elementGetAttributeValue(WebElement element)
   {
	String attribute = element.getAttribute("value");
	return attribute;
   }
public String elementGetAttributeValue(WebElement element,String attributeName)
   {
	String attribute = element.getAttribute(attributeName);
	return attribute;
   }
public void selectByVisibleText(WebElement element,String hotels) 
   {
	Select select = new Select(element);
	select.selectByVisibleText(hotels);
   }
public static void clearText(WebElement element) {
element.clear();
}
public void SelectByAttribute(WebElement element,String value) 
   {
	Select select = new Select(element);
	select.selectByValue(value);
   }
public void SelectByIndex(WebElement element,int index) 
   {
	Select select = new Select(element);
	select.selectByIndex(index);
   }
public void doubleClick(WebElement element)
  {
	Actions actions = new Actions (driver);
    actions.doubleClick(element).perform();
  }
public void switchtochildwindow()
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

public void rightClick(WebElement element)
 {
	Actions actions = new Actions (driver);
    actions.contextClick(element).perform();
 }
public void dragandDrop(WebElement source, WebElement destination)
  {
	Actions actions = new Actions (driver);
    actions.dragAndDrop(source, destination).perform();
   } 
public void enterValuetoTextbox(WebElement element, String text)
   {
	element.sendKeys(text,Keys.ENTER);
   }
public void mouseMovetoElement(WebElement element)
{
	Actions actions = new Actions (driver);
   actions.moveToElement(element).perform();

}
public void Takescreenshot()
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	ts.getScreenshotAs(OutputType.FILE);
}
public void cleartextbox(WebElement element)
{
	element.clear();
}
public void getAllwindowsId()
{
	Set<String> handles = driver.getWindowHandles();
}
public void getparentwindow() 
{
	String string = driver.getWindowHandle();
}
public void deselectAll(WebElement element)
{
	Select select = new Select(element);
	select.deselectAll();
   }
public void deselectbyvisibletext(WebElement element,String text) 
{
	Select select = new Select(element);
	select.selectByValue(text);
}
public void deselectbyvalue(WebElement element,String value) 
  {
	Select select = new Select(element);
	select.selectByValue(value);
  }
public void deselectByIndex(WebElement element,int index) 
  {
	Select select = new Select(element);
	select.selectByIndex(index);
}
public void implicitwait(long second)
{
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
}

public String getdatafromcell(String Sheetname,int rownum,int cellnum)
{
	return Sheetname;
	
}
public void implicitWait(long arg0) 
{
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(arg0));
}
public void elementsendkeys(WebElement element,String n) {
	element.sendKeys(n);
}
public String getDatafromCell(String sheetName, int rownum, int cellnum) throws IOException {
	
	String res= "";
	
	File file = new File("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx");
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
@SuppressWarnings("deprecation")
public void implicitWait() 
{
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}
public String elementGetttributeValue(WebElement element) 
{
	String attribute = element.getAttribute("value");
   return attribute;
}
public void insertDataInCell(String sheetName, int rowNum, int cellNum,String data) throws IOException {
	File file =new File("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx");
	FileInputStream fileInputStream = new  FileInputStream(file);
	Workbook workbook= new XSSFWorkbook(fileInputStream);
	Sheet sheet=workbook.getSheet(sheetName);
	Row row=sheet.getRow(rowNum);
	Cell cell= row.createCell(cellNum);
	cell.setCellValue(data);
	FileOutputStream out=new FileOutputStream(file);
	workbook.write(out);
}
 public void alertok()
 {
	 Alert alert = driver.switchTo().alert();
	 alert.accept();		 
 }

}   

