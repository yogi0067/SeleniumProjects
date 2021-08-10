package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilites.BaseClass;

public class BasicAuthication extends BaseClass {
	
	@Test
	public void TestBasic()
	{
		WebDriver driver=initilizeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		//driver.get("https://UserName:Password@the-internet.herokuapp.com/basic_auth");
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
