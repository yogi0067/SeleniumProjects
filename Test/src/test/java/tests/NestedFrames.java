package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilites.BaseClass;

public class NestedFrames extends BaseClass {
	WebDriver driver;
	
	
	@Test
	public void nestedFrameTest()
	{
		driver=initilizeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame(0);
		WebElement leftFrame=driver.findElement(By.cssSelector("[name='frame-left']"));
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.tagName("body")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.tagName("body")).getText());
		
		
	}
	
	
	
	

}
