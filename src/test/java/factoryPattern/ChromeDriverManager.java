package factoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements BrowserInterface {
   public ChromeOptions options;
	@Override
	public WebDriver createDriver() {
		options= new ChromeOptions();
		options.addArguments("--incognito");
		return new ChromeDriver(options);
		// TODO Auto-generated method stub
		
	}

}
