package pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.com.BaseClass;

public class Loginpage extends BaseClass
{
	public Loginpage()
	{
	PageFactory.initElements(driver,this);
}
@FindBy(id ="username")
private WebElement txtusername;

@FindBy(id ="password")
private WebElement txtpass;

@FindBy(id ="login")
private WebElement btnlogin;

public WebElement getTxtusername() {
	return txtusername;
}

public WebElement getTxtpass() {
	return txtpass;
}

public WebElement getBtnlogin() {
	return btnlogin;
}

public void Loginpage (String Username, String password)
{
	elementsendkeys(getTxtusername(), Username);
	elementsendkeys(getTxtpass(), password);
	elementClick(btnlogin);
}
}
