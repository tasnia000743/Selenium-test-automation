package factoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager implements BrowserInterface{

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		return new FirefoxDriver();
	}


}
