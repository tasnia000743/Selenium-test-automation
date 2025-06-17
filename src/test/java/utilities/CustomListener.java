package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.chaintest.plugins.ChainTestListener;
import factoryPattern.DriverFactory;

public class CustomListener implements ITestListener {
	TakesScreenshot ts;
	WebDriver driver;
	@Override
	public void onTestFailure(ITestResult result) {
		driver= new DriverFactory().getDriver(DriverFactory.BrowserType.chrome).createDriver();
		ts= (TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		ChainTestListener.embed(f, "image/png");
          
	}
	
	

}
