package testng.com;

import org.testng.annotations.Test;

public class Testannotations 
{
	@Test(priority=5) 
	private void tc01()
	{
		System.out.println("Method1");
	}
	@Test(invocationCount=3)
	private void tc02()
	{
	    System.out.println("Method2");
    }
	@Test(enabled=false)
	private void tc03()
	{
	   System.out.println("Method3");
     }
	@Test
	private void tc04()
	{
	    System.out.println("Method4");
    }
	@Test
	private void tc05()
	{
	   System.out.println("Method5");
     }
	@Test
	private void tc06()
	{
		System.out.println("Method6");
	}
	@Test
	private void tc07()
	{
	    System.out.println("Method7");
    }
	@Test
	private void tc08()
	{
	   System.out.println("Method8");
     }
	@Test
	private void tc09()
	{
	   System.out.println("Method9");
     }
}
