package tests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilites.BaseClass;

public class DownloadFileConcept extends BaseClass{
	WebDriver driver;
	File folder;
	String fileName="";
	
	@BeforeMethod
	public void beforeMethod()
	{
		folder = new File("C:\\Users\\think\\Downloads");
		System.out.println(folder.getAbsolutePath());
		Map <String, Object> prefs= new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory",folder.getAbsolutePath());
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver=initilizeDriver(options);
		
	}
	@Test
	public void test() throws InterruptedException
	{
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(3000);
		File[] files = folder.listFiles();
		for(File file:files)
		{
			fileName=file.getName();
			if(fileName.equalsIgnoreCase("some-file.txt"))
			{
				System.out.println(file.getName());
				Assert.assertTrue(true);
				
				break;
			}
		}	
		if(!(fileName.equalsIgnoreCase("some-file.txt")))
		{
					Assert.assertTrue(false);
			
		}
	}
	@AfterMethod
	public void afterMethod()
	{
		File[] files = folder.listFiles();
		for(File file:files)
		{
			
			if(file.getName().equalsIgnoreCase("some-file.txt"))
			{	
				file.delete();
				break;
			}
		}
		driver.quit();
	}
	
}
