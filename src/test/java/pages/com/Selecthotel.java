package pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.com.BaseClass;

public class Selecthotel extends BaseClass
{
	public Selecthotel()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='radiobutton_0']")
	private WebElement radiobutton;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continu;

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getContinu() {
		return continu;
	}
	
	public void Selecthotel1()
	{
		elementClick(getRadiobutton());
		elementClick(getContinu());
	
	}
}
