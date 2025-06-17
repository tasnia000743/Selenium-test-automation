package testBase;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import utilities.CustomListener;

import com.aventstack.chaintest.plugins.ChainTestListener;
import factoryPattern.DriverFactory;


@Listeners({ChainTestListener.class, CustomListener.class})
public class BaseClass {

	static {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.setProperty("chaintest.generator.simple.output-file", 
            "reports//chaintest//simple-report-" + timeStamp + ".html");

        System.setProperty("chaintest.generator.email.output-file", 
            "reports//chaintest//email-report-" + timeStamp + ".html");
    }; // static block will load before class

  public WebDriver driver;
  public Logger logger;  //Log4j
  public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
				
		logger=LogManager.getLogger(this.getClass());  //lOG4J2
				
			switch(br.toLowerCase())
			{
			case "chrome":
				driver= new DriverFactory().getDriver(DriverFactory.BrowserType.chrome).createDriver();
				break;
				
			case "edge":
				driver= new DriverFactory().getDriver(DriverFactory.BrowserType.edge).createDriver();
				break;	
				
			case "firefox":
				driver= new DriverFactory().getDriver(DriverFactory.BrowserType.firefox).createDriver();
				break;
			
				
			default : 
				return;
			}
		
			
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL")); // reading url from properties file.
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	/*
	 * randomeString-Rnadomly generate a string value
	 */
	public String randomeString()
	{
		@SuppressWarnings("deprecation")
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
    /*
	 * randomeNumber-Rnadomly generate a number
	 */
	
	@SuppressWarnings("deprecation")
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	/*
	 * randomeAlphaNumberic-Rnadomly generate an alphanumeric value
	 */
	
	public String randomeAlphaNumberic()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
	
	
	/*
	 * scrollBottom-scroll at bottom of the page
	 */
	public void scrollBottom () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, arguments[0]);", Integer.MAX_VALUE);
	}
	
	
}
