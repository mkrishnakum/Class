package base.com;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Base1 
{
public static void main(String[] args) throws IOException, InterruptedException 
{
	Base1 employee = new Base1();
	employee.bookings();
}
public void bookings() throws IOException, InterruptedException
{
	BaseClass base = new BaseClass() ;
	base.getDriver();
	base.enterApplnUrl("https://adactinhotelapp.com/");
	base.maximizewindow();
	
	WebElement txtusername = base.findLocatorByID("username");
	String name = base.getDatafromCell("Datas", 0, 0);
	base.elementsendkeys(txtusername,name);
	
	WebElement txtpassword = base.findLocatorByID("password");
	String pass = base.getDatafromCell("Datas", 0, 1);
	base.elementsendkeys(txtpassword,pass);
	
	WebElement btnlogin = base.findLocatorByID("login");
	base.elementClick(btnlogin);

	
	WebElement loc = base.findLocatorByXpath("//select[@id='location']");
	base.selectByVisibleText(loc, base.getDatafromCell("Datas", 5, 2));
	
	WebElement hot = base.findLocatorByXpath("//select[@id='hotels']");
	base.selectByVisibleText(hot, base.getDatafromCell("Datas", 2, 3));
	
	WebElement sel3 = base.findLocatorByXpath("//select[@id='room_type']");
	base.selectByVisibleText(sel3, base.getDatafromCell("Datas", 2, 4));
	
    WebElement sel4 = base.findLocatorByXpath("//select[@id='room_nos']");
	base.selectByVisibleText(sel4, base.getDatafromCell("Datas", 2,5));
	
	WebElement sel5 = base.findLocatorByXpath("//input[@name='datepick_in']");
	base.elementsendkeys(sel5, base.getDatafromCell("Datas", 1, 6));
	
	WebElement date = base.findLocatorByXpath("//input[@name='datepick_out']");
	base.elementsendkeys(date, base.getDatafromCell("Datas", 1, 7));
	
	WebElement adult = base.findLocatorByXpath("//select[@id='adult_room']");
	base.elementsendkeys(adult, base.getDatafromCell("Datas", 1, 8));
	
	WebElement child = base.findLocatorByXpath("//select[@id='child_room']");
	base.elementsendkeys(child, base.getDatafromCell("Datas", 1, 9));
	
	WebElement submit = base.findLocatorByXpath("//input[@id='Submit']");
	base.elementClick(submit);
	
	WebElement radi = base.findLocatorByXpath("//input[@id='radiobutton_0']");
	base.elementClick(radi); 
	
	WebElement conti = base.findLocatorByXpath("//input[@id='continue']");
	base.elementClick(conti);
	
	WebElement first = base.findLocatorByXpath("//input[@id='first_name']");
	base.elementsendkeys(first, base.getDatafromCell("Datas", 1, 10));
	
	WebElement last = base.findLocatorByXpath("//input[@id='last_name']");
	base.elementsendkeys(last, base.getDatafromCell("Datas", 1, 11));
	
	WebElement add = base.findLocatorByXpath("//textarea[@id='address']");
	base.elementsendkeys(add, base.getDatafromCell("Datas", 1, 12));
	
	WebElement cc = base.findLocatorByXpath("//input[@id='cc_num']");
	base.elementsendkeys(cc, base.getDatafromCell("Datas", 1, 13));
	
	WebElement type = base.findLocatorByXpath("//select[@id='cc_type']");
	base.selectByVisibleText(type, base.getDatafromCell("Datas", 1, 14));
	
	WebElement month = base.findLocatorByXpath("//select[@id='cc_exp_month']");
	base.selectByVisibleText(month, base.getDatafromCell("Datas", 1,15));
	
	WebElement year = base.findLocatorByXpath("//select[@id='cc_exp_year']");
	base.selectByVisibleText(year, base.getDatafromCell("Datas", 1,16));
	
	 
	WebElement cvv = base.findLocatorByXpath("//input[@id='cc_cvv']");
	base.elementsendkeys(cvv, base.getDatafromCell("Datas", 1, 17));
	
	WebElement book = base.findLocatorByXpath("//input[@id='book_now']");
	base.elementClick(book);
	
	Thread.sleep(5000);
	
	WebElement order = base.findLocatorByXpath("//input[@id='my_itinerary']");
	base.elementClick(order);
	
	WebElement orderId = base.findLocatorByXpath("//input[@id='order_id_742837']");
    String value = base.elementGetAttributeValue(orderId);
	base.insertDataInCell("Datas", 2, 20, value);
	System.out.println(value);
	
	
	}
}

