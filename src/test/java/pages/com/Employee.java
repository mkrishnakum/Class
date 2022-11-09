package pages.com;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import base.com.BaseClass;

public class Employee extends BaseClass
{
@BeforeClass
public static void beforeclass()
{
     getDriver();
     enterApplnUrl("https://adactinhotelapp.com/");
     maximizewindow();
}
/*@AfterClass
public static void afterclass()
{
	quitwindow();
}*/
@Test
	public void cancelHotel() throws IOException
	{
		Loginpage login = new Loginpage();
		login.Loginpage(getDatafromCell("Datas", 0, 0), getDatafromCell("Datas", 0, 1));
		
		SearchHotel searchHotelpage = new SearchHotel();
		searchHotelpage.SearchHotels(getDatafromCell("Datas", 1, 2), getDatafromCell("Datas", 1, 3), getDatafromCell("Datas", 2, 4), getDatafromCell("Datas", 2, 5), getDatafromCell("Datas", 1, 6), getDatafromCell("Datas", 1, 7), getDatafromCell("Datas", 1, 8), getDatafromCell("Datas", 1, 9));
	    
		Selecthotel selecthHotelpage = new Selecthotel();
		selecthHotelpage.Selecthotel1();
		
		BookHotel hotel = new BookHotel();
		hotel.BookHotels1((getDatafromCell("Datas", 1, 10)), (getDatafromCell("Datas", 1, 11)), (getDatafromCell("Datas", 1, 12)), (getDatafromCell("Datas", 1, 13)), (getDatafromCell("Datas", 1, 14)), (getDatafromCell("Datas", 1, 15)), (getDatafromCell("Datas", 1, 16)), (getDatafromCell("Datas", 1, 17)));
	
		CancelHotel hotel1 = new CancelHotel();
		hotel1.cancelpage(getDatafromCell("Datas", 2, 20));
     }
  }
