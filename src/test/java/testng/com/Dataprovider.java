package testng.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider 
{
	WebDriver driver;
	@BeforeMethod
	private void beforemethod()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	@Test(dataProvider="getdata")
	public void tc01(String s, String s1)
	{
		WebElement txtusername = driver.findElement(By.id("email"));
		txtusername.sendKeys(s);
	
		WebElement txtpass = driver.findElement(By.id("pass"));
		txtpass.sendKeys(s1);
	}
		@DataProvider
		private Object[][] getdata()
		{
		Object [][] data= new Object[3][2];
		data[0][0] = "A";
		data[0][1] = "B";
		// first iteration username A password B
		data[1][0] = "C";
		data[1][1] = "D";
		// second iteration username C paasword D
		data[2][0] = "E";
		data[2][1] = "F";
		// second iteration username C paasword D
		return data;
		}
	}
	

