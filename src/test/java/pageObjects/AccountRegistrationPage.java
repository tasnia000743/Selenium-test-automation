package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(xpath="//input[@id='input-firstname']") 
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']") 
WebElement txtLasttname;

@FindBy(xpath="//input[@id='input-email']") 
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']") 
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']") 
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']") 
WebElement txtConfirmPassword;

@FindBy(xpath="//input[@name='agree']") 
WebElement chkdPolicy;

@FindBy(xpath="//input[@value='Continue']") 
WebElement btnContinue;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;


//Action methods

public void setFirstName(String fname) {
	enterText(txtFirstname, ActionType.sendKeysTillWait, 10, fname);

}

public void setLastName(String lname) {
	enterText(txtLasttname, ActionType.sendKeysTillWait, 10, lname);

}

public void setEmail(String email) {
	enterText(txtEmail, ActionType.sendKeysTillWait, 10, email);

}

public void setTelephone(String tel) {
	enterText(txtTelephone, ActionType.sendKeysTillWait, 10, tel);

}

public void setPassword(String pwd) {
	enterText(txtPassword, ActionType.sendKeysTillWait, 10, pwd);

}

public void setConfirmPassword(String pwd) {
	enterText(txtConfirmPassword, ActionType.sendKeysTillWait, 10, pwd);

}

public void setPrivacyPolicy() {
	clickOnElement(chkdPolicy, ActionType.clickJS, 10);

}



public void clickContinue() {
	clickOnElement(btnContinue, ActionType.clickJS, 10);

	
	
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}

}
}
