package testng.com;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Class
{
WebDriver driver;
@BeforeClass
private void beforeclass()
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
}
@BeforeMethod
private void beforemethod()
{
	Date date = new Date();
	System.out.println(date);
}
@Parameters("username")
@Test
public void tc01(@Optional("surya") String s)
{
	WebElement txtusername = driver.findElement(By.id("email"));
	txtusername.sendKeys(s);
}
@Parameters("password")
@Test
public void tc02(String s1)
{
	WebElement txtpass = driver.findElement(By.id("pass"));
	txtpass.sendKeys(s1);
}
}
