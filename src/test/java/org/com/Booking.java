package org.com;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Booking extends Baseclass 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
        getDriver();
		enterApplnUrl("https://adactinhotelapp.com/");
		maximizewindow();
         Thread.sleep(20);
		WebElement txtusername = findLocatorByID("username");
		String name = getDataformCell("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx", "datas", 0, 1);
		elementsendkeys(txtusername, name);

		WebElement txtpass = findLocatorByID("password");
		String name1 = getDataformCell("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx", "datas", 1, 1);
		elementsendkeys(txtpass, name1);

		WebElement btnlogin = findLocatorByID("login");
		btnlogin.click();

		WebElement loc = findLocatorByXpath("//select[@id='location']");
		String dataformCell = getDataformCell("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx", "datas", 5, 2);
		elementsendkeys(loc, dataformCell);

		WebElement hot = findLocatorByXpath("//select[@id='hotels']");
		String dataformCell1 = getDataformCell("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx", "datas", 2, 3);
		elementsendkeys(hot, dataformCell1);
		
		WebElement rt = findLocatorByXpath("//select[@id='room_type']");
		String dataformCell2 = getDataformCell("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx", "datas", 4, 4);
		elementsendkeys(rt, dataformCell2);
		 //Thread.sleep(2000);
		WebElement room = findLocatorByXpath("//select[@name='room_nos']");
		String dataformCell3 = getDataformCell("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx", "datas", 5, 5);
		elementsendkeys(room, dataformCell3);
        
		WebElement date = findLocatorByXpath("//input[@name='datepick_in']");
		String dataformCell4 = getDataformCell("D:\\Selenium Automation\\Class\\Excel\\Data.xlsx", "datas", 3, 6);
		elementsendkeys(date, dataformCell4);
	}

	 
}
