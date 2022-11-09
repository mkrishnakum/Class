package testng.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Para
{
	String m= "";
	WebDriver driver;
	@BeforeClass
	private void beforemethod()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
	}
	@Parameters({"username","password"})
	@Test
	public void tc01(String s, String s1)
	{
		WebElement txtusername = driver.findElement(By.id("username"));
		txtusername.sendKeys(s);
	
		WebElement txtpass = driver.findElement(By.id("password"));
		txtpass.sendKeys(s1);
		WebElement findElement = driver.findElement(By.xpath("//input[@id='login']"));
		findElement.click();
  }
	@Parameters({"Location","Hotel","Roomtype","Number of rooms","Check in date","Check out date","Adults per room","Children per room"})
	@Test
	public void tc02(String A,String B,String C,String D,String E,String F, String G, String H)
  {
		WebElement loc = driver.findElement(By.xpath("//select[@id='location']"));
		Select sel = new Select(loc);
		sel.selectByVisibleText(A);
		
		WebElement hot = driver.findElement(By.xpath("//select[@id='hotels']"));
		Select sel1 = new Select(hot);
		sel1.selectByVisibleText(B);
		
		WebElement rt = driver.findElement(By.xpath("//select[@id='room_type']"));
		Select sel2 = new Select(rt);
		sel2.selectByVisibleText(C);
		
	    WebElement rn = driver.findElement(By.xpath("//select[@id='room_nos']"));
	    Select sel3 = new Select(rn);
		sel3.selectByVisibleText(D);
		
		WebElement din = driver.findElement(By.xpath("//input[@name='datepick_in']"));
		din.sendKeys(E);
        
		WebElement dout = driver.findElement(By.xpath("//input[@name='datepick_out']"));
		dout.sendKeys(F);
		
		WebElement adult = driver.findElement(By.xpath("//select[@id='adult_room']"));
		adult.sendKeys(G);
		
		WebElement child = driver.findElement(By.xpath("//select[@id='child_room']"));
		child.sendKeys(H);
		
		WebElement submit = driver.findElement(By.xpath("//input[@id='Submit']"));
		submit.click();
       }
		@Parameters({"First name","Lastname","Billing address","Credit Card No","Credit Card Type","Month","year","CVV Number"})
        @Test
		
		public void tc03(String A1,String B1,String C1,String D1,String E1,String F1, String G1, String H1) throws InterruptedException
		{
		WebElement radi = driver.findElement(By.xpath("//input[@id='radiobutton_0']"));
		radi.click(); 
		
		WebElement conti = driver.findElement(By.xpath("//input[@id='continue']"));
		conti.click();
		
		WebElement first = driver.findElement(By.xpath("//input[@id='first_name']"));
		first.sendKeys(A1);
		
		WebElement last = driver.findElement(By.xpath("//input[@id='last_name']"));
		last.sendKeys(B1);
		
		WebElement add = driver.findElement(By.xpath("//textarea[@id='address']"));
		add.sendKeys(C1);
		
		WebElement cc = driver.findElement(By.xpath("//input[@id='cc_num']"));
		cc.sendKeys(D1);
		
		WebElement type = driver.findElement(By.xpath("//select[@id='cc_type']"));
		Select sel4 = new Select(type);
		sel4.selectByVisibleText(E1);
		
		WebElement month = driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
		Select sel5 = new Select(month);
		sel5.selectByValue(F1);
		
		WebElement year = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		Select sel6 = new Select(year);
		sel6.selectByVisibleText(G1);
		
		 
		WebElement cvv = driver.findElement(By.xpath("//input[@id='cc_cvv']"));
		cvv.sendKeys(H1);
		
		WebElement book = driver.findElement(By.xpath("//input[@id='book_now']"));
		book.click();
		
		Thread.sleep(5000);
		
		WebElement order = driver.findElement(By.xpath("//input[@id='my_itinerary']"));
		order.click();
		WebElement element = driver.findElement(By.xpath("//input[@id='order_id_742969']"));
		String m = element.getAttribute("value");
		System.out.println(m);
		
	
		
		}
		@Test
		public void tco4() throws IOException {
			File file =new File("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx");
			FileInputStream fileInputStream = new  FileInputStream(file);
			Workbook workbook= new XSSFWorkbook(fileInputStream);
			Sheet sheet= workbook.getSheet("Datas");
			Row row=sheet.getRow(1);
			Cell cell= row.createCell(25);
			cell.setCellValue(m);
			FileOutputStream out=new FileOutputStream(file);
			workbook.write(out);
		}
		 
}
