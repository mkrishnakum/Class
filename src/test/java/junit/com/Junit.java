package junit.com;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Junit 
{

static WebDriver driver;
@BeforeClass
public static void beforeclass()
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
}
@BeforeClass
public static void before()
{
	TakesScreenshot ts = (TakesScreenshot)driver;
    File ScreenshotAs = ts.getScreenshotAs(OutputType.FILE);
    System.out.println(ScreenshotAs);
}
@Test
public void test()
{
	WebElement txtusername =driver.findElement(By.id("username"));
	txtusername.sendKeys("krishnamk");
	
	WebElement txtpassword =driver.findElement(By.id("password"));
	txtpassword.sendKeys("KRISHNA123");
	
	WebElement btnlogin =driver.findElement(By.name("login"));
	btnlogin.click();
}
@After
public void after()
{
	TakesScreenshot ts = (TakesScreenshot)driver;
    File ScreenshotAs = ts.getScreenshotAs(OutputType.FILE);
    System.out.println(ScreenshotAs);
}
@AfterClass
public static void After()
{
	driver.quit();
}
	}


