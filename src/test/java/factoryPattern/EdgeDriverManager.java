package factoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager implements BrowserInterface{

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		return new EdgeDriver();
	}
	

}
