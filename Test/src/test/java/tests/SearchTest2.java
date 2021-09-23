package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageobjects.PageObjectsPratice;
import utilites.BaseClass;

public class SearchTest2 extends BaseClass {

	WebDriver driver = initilizeDriver();
	PageObjectsPratice po = new PageObjectsPratice(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Test()
	public void a() throws IOException {
		driver.manage().window().maximize();
		driver.get(getPropertyValue("autoPracticeUrl"));
		js.executeScript("arguments[0].scrollIntoView()", po.getSlider());
		js.executeScript("arguments[0].style='left: 50%;'", po.getSlider());
		
	}
	@Test
	public void b() throws IOException, InterruptedException {
		Thread.sleep(2000);
		//Method 1
		js.executeScript("arguments[0].style='width: 300px; height: 200px;'", po.getResizable());
		Thread.sleep(2000);
		//Method2
		js.executeScript("document.getElementById('resizable').style='width: 100px; height: 100px;'");
	}

}
