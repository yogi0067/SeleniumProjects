package utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	Properties prop=new Properties();
	 public WebDriver initilizeDriver()
	 {
		 WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 return driver;
	 }
	 public String getProperty(String value) throws IOException
	 {
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		 prop.load(fis);
		return prop.getProperty(value);
		 
	 }
	
}
