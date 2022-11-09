package testng.com;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng 
{
        @BeforeSuite
		private void beforesuite()
		{
			System.out.println(" Execute before test tag");
		}
		@AfterSuite
		private void aftersuite()
		{
			System.out.println(" Execute after test tag");
		}
		@BeforeTest
		private void beforetest()
		{
			System.out.println(" Execute before class inside tag");
		}
		@AfterTest
		private void aftertest()
		{
			System.out.println(" Execute after test tag");
		}
		@BeforeClass
		private void beforeclass()
		{
			System.out.println(" Execute before method inside class");
		}
		@AfterClass
		private void afterclass()
		{
			System.out.println(" Execute before method inside class");
		}
		@BeforeMethod
		private void Beforemethod()
		{
			System.out.println(" Execute before each @test");
		}
		@AfterMethod
		private void aftermethod()
		{
			System.out.println(" Execute after each @test");
		}
		@Test
		private void tc01()
		{
			System.out.println("Method1");
		}
		@Test
		private void tc02() {
			System.out.println("surya");
		}
	}

	
