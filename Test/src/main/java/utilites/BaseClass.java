package utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public WebDriver driver;
	public ExtentReports er;
	public static Logger logs = LogManager.getLogger(BaseClass.class.getName());

	public  WebDriver initilizeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;	
	}
	public  WebDriver initilizeDriver(ChromeOptions options) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;	
	}
	public  WebDriver initilizeDriver(DesiredCapabilities dc) throws MalformedURLException {
		
		driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"),dc );
		return driver;	
	}
	public String getPropertyValue(String value) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\think\\eclipse-workspace\\Test\\resources\\data.properties");
		Properties prop= new Properties();
		prop.load(fis);
		return prop.getProperty(value);
		
	}
	public static String takeScreenShot(WebDriver driver,String testCaseName) throws IOException
	{
		TakesScreenshot screenShot= (TakesScreenshot) driver;
		File sc= screenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sc, new File(System.getProperty("user.dir")+"\\Reports\\screenshot\\"+testCaseName+".png"));
		return System.getProperty("user.dir")+"\\Reports\\screenshot\\"+testCaseName+".png";
	}
	public ExtentReports generateReports()
	{
		String path = System.getProperty("user.dir") + "\\Reports\\htmlreport\\report.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		
		reporter.config().setDocumentTitle("Test Rrport");
		reporter.config().setReportName("Test Report");
		er= new ExtentReports();
		er.setSystemInfo("Amazon", "test");
		er.attachReporter(reporter);
		return er;
		
		
	}
	public void uploadFile(String filepath) throws IOException
	{
		
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\resources\\autoituloadfromcmd.exe"+" "+ filepath);
		//C:\Users\think\eclipse-workspace\Test\resources\autoituloadfromcmd.exe
		
		
	}

}
