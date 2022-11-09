package pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.com.BaseClass;

public class CancelHotel extends BaseClass
{
	public CancelHotel()
	{
		PageFactory.initElements(driver,this);
	}
	
	        @FindBy(xpath = "//a[text()='Booked Itinerary']")
	        private WebElement bookinit;
	
			
			@FindBy(xpath= "//input[@id='order_id_text']")
			private WebElement searchid;
			
			@FindBy(xpath= "(//input[@type='submit'])[1]")
		    private WebElement searchbutton;
			
			@FindBy(xpath= "//input[@value='Cancel 743V0Q720X']")
		    private WebElement cancelid;
			
	

public WebElement getBookinit() {
				return bookinit;
}



			public WebElement getSearchid() {
				return searchid;
			}



			public WebElement getSearchbutton() {
				return searchbutton;
			}



			public WebElement getCancelid() {
				return cancelid;
			}



public void cancelpage ( String orderid)
	{
		
		elementClick(getBookinit());
		elementsendkeys(getSearchid(), orderid);
		elementClick(getSearchbutton());
		elementClick(getCancelid());
		alertok();
		
		
	}

	
		
		
		
		
		
		
		
		
		
		
}

