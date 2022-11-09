package pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.com.BaseClass;

public class SearchHotel extends BaseClass
{
	public SearchHotel()
	{
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//select[@id='location']")
private WebElement location;

@FindBy(xpath="//select[@id='hotels']")
private WebElement hotels;

@FindBy(xpath="//select[@id='room_type']")
private WebElement rooomtype;

@FindBy(xpath="//select[@name='room_nos']")
private WebElement rooomnos;

@FindBy(xpath="//input[@name='datepick_in']")
private WebElement cleardate;


@FindBy(xpath="//input[@name='datepick_in']")
private WebElement datepickin;
@FindBy(xpath="//input[@name='datepick_out']")
private WebElement clearout;


@FindBy(xpath="//input[@name='datepick_out']")
private WebElement datepickout;

@FindBy(xpath="//select[@id='adult_room']")
private WebElement adultroom;

@FindBy(xpath="//select[@id='child_room']")
private WebElement childroom;

@FindBy(xpath="//input[@id='Submit']")
private WebElement submit;

public WebElement getClearout() {
	return clearout;
}


public WebElement getLocation() {
	return location;
}

public WebElement getHotels() {
	return hotels;
}

public WebElement getRooomtype() {
	return rooomtype;
}

public WebElement getRooomnos() {
	return rooomnos;
}

public WebElement getCleardate() {
	return cleardate;
}

public WebElement getDatepickin() {
	return datepickin;
}

public WebElement getDatepickout() {
	return datepickout;
}

public WebElement getAdultroom() {
	return adultroom;
}

public WebElement getChildroom() {
	return childroom;
}

public WebElement getSubmit() {
	return submit;
}

public void SearchHotels(String location, String Hotels, String roomtype, String rooomnos, String datepickin, String datepickout , String adultroom, String childroom)
{
	selectByVisibleText(getLocation(), location);
	selectByVisibleText(getHotels(), Hotels);
    selectByVisibleText(getRooomtype(), roomtype);
    selectByVisibleText(getRooomnos(), rooomnos);
    clearText(getCleardate());
    elementsendkeys(getDatepickin(), datepickin);
    clearText(getClearout());
    elementsendkeys(getDatepickout(), datepickout);
    selectByVisibleText(getAdultroom(), adultroom);
    selectByVisibleText(getChildroom(), childroom);
    elementClick(getSubmit());
 
    
    
    
    
    
    
    
    
    
}
}
