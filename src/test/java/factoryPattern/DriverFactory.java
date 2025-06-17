package factoryPattern;

public class DriverFactory {
	
	public enum BrowserType{
		chrome,
		edge,
		firefox
	}
	
	public BrowserInterface getDriver(BrowserType type) {
		switch(type) {
		case chrome:
			return new ChromeDriverManager();
		case edge:
			return new EdgeDriverManager();
		case firefox:
			return new FirefoxDriverManager();
		default:
			throw new IllegalArgumentException("Invalid type" +type);
					
			
		}
	}

}
