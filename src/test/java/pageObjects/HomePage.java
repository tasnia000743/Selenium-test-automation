package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//span[normalize-space()='My Account']") 
WebElement lnkMyaccount;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
WebElement lnkRegister;

@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")   // Login link added in step5
WebElement linkLogin;

//Action methods

public void clickMyAccount()
{
	clickOnElement(lnkMyaccount, ActionType.clickJS, 10);
}

public void clickRegister()
{
	clickOnElement(lnkRegister, ActionType.clickJS, 10);
}

public void clickLogin()
{
	clickOnElement(linkLogin, ActionType.clickJS, 10);
}

}
