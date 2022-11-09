package testng.com;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class S2 
{
	/*@Parameters({"username","password"})
	@Test
	private void tc01(String s,String s1)
	{
		System.out.println("s");
		System.out.println("s1");
	}*/
	@Parameters("username")
	@Test
	private void tc02(String s)
	{
		System.out.println(s);
	}
	@Parameters("password")
	@Test
	private void tc03(String s)
	{
		System.out.println(s);
	
}
}
