package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utilites.BaseClass;

public class FileUploadWithSkuli extends BaseClass {

	@Test
	public void test() throws InterruptedException {
		WebDriver driver = initilizeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
		WebElement ele = driver.findElement(By.xpath("//*[@name=\"file\"]"));
		Actions action = new Actions(driver);
		action.click(ele).build().perform();
		Thread.sleep(3000);
		try {
			//Runtime.getRuntime().exec("C:\\Users\\think\\Downloads\\a.exe");
			//Runtime.getRuntime().exec("C:\\Users\\think\\Downloads\\autoituloadfromcmd.exe"+" "+"C:\\Users\\think\\Documents\\Book1.xlsx");
			uploadFile("D:\\acc.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
