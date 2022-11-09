package pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.com.BaseClass;

public class BookHotel extends BaseClass
{
	public BookHotel()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement lasttname;
	
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='cc_num']")
	private WebElement ccnum;
	
	@FindBy(xpath="//select[@id='cc_type']")
	private WebElement cctype;
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
	private WebElement ccexpmonth;
	
	@FindBy(xpath="//select[@id='cc_exp_year']")
	private WebElement ccexpyear;
	
	@FindBy(xpath="//input[@id='cc_cvv']")
	private WebElement cccvv;
	
	@FindBy(xpath="//input[@id='book_now']")
	private WebElement booknow;


public WebElement getFirstname() {
		return firstname;
	}



	public WebElement getLasttname() {
		return lasttname;
	}



	public WebElement getAddress() {
		return address;
	}



	public WebElement getCcnum() {
		return ccnum;
	}



	public WebElement getCctype() {
		return cctype;
	}



	public WebElement getCcexpmonth() {
		return ccexpmonth;
	}



	public WebElement getCcexpyear() {
		return ccexpyear;
	}



	public WebElement getCccvv() {
		return cccvv;
	}



	public WebElement getBooknow() {
		return booknow;
	}

public void BookHotels1(String firstname, String lastname, String address, String ccnum, String cctype, String ccexpmonth , String ccexpyear, String cccvv)
{
	elementsendkeys(getFirstname(), firstname);
	elementsendkeys(getLasttname(), lastname);
	elementsendkeys(getAddress(), address);
	elementsendkeys(getCcnum(), ccnum);
	selectByVisibleText(getCctype(), cctype);
	selectByVisibleText(getCcexpmonth(), ccexpmonth);
	selectByVisibleText(getCcexpyear(), ccexpyear);
	elementsendkeys(getCccvv(), cccvv);
	elementClick(getBooknow());
	
}




}
