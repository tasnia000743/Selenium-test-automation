package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public enum ActionType {
		click,
		clickTillWait,
		clickJS,
		clickAction,
		sendKeys,
		sendKeysTillWait,
		sendKeysJS
	}
	
	
	public void clickOnElement(WebElement ele, ActionType type, int time) {
		switch(type) 
		{
		case click:
			ele.click();
			break;
			
		case clickTillWait:
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
			
		  case clickJS:
	            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	            jsExecutor.executeScript("arguments[0].click();", ele);
	            break;

	        case clickAction:
	            Actions actionsClick = new Actions(driver);
	            actionsClick.moveToElement(ele).click().perform();
	            break;
	         
	          default:
	        	  throw new IllegalArgumentException("Invalid type" +type);
		} }
	    
	 
	     public void enterText(WebElement ele, ActionType type, int time, String txt)  {
	    	 switch(type) {

	        case sendKeys:
	            ele.sendKeys(txt); 
	            break;

	        case sendKeysTillWait:
	            WebDriverWait waitSendKeys = new WebDriverWait(driver, Duration.ofSeconds(time));
	            waitSendKeys.until(ExpectedConditions.visibilityOf(ele)).sendKeys(txt); // Replace as needed
	            break;

	        case sendKeysJS:
	            JavascriptExecutor jsSendKeys = (JavascriptExecutor) driver;
	            jsSendKeys.executeScript("arguments[0].value=arguments[1];", ele, txt);
	            break;

	        default:
	            throw new IllegalArgumentException("Unsupported action type: " + type);
	    }
		}
		
}
