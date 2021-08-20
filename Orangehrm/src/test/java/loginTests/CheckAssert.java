package loginTests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilites.BaseClass;

public class CheckAssert extends BaseClass {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initilizeDriver();
		
		driver.get(getProperty("url"));
		
	}
	@Test
	public void checkLinksOfSocialMedia()
	{
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String mainWindow= itr.next();
		String childWindow= itr.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.orangehrm.com/");
		driver.close();
		
		
		
		
		
		
	}
}
