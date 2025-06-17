package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;

    //Action methods
	
	public void setEmail(String email) {
		enterText(txtEmailAddress, ActionType.sendKeysTillWait, 10, email);
	}

	public void setPassword(String pwd) {
		enterText(txtPassword, ActionType.sendKeysTillWait, 10, pwd);
	}

	public void clickLogin() {
		clickOnElement(btnLogin, ActionType.clickJS, 10);
	}

	
	
	
}
