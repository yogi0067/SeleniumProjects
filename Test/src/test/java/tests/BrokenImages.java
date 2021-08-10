package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilites.BaseClass;

public class BrokenImages extends BaseClass {

	
	
	@Test
	public void getBrokerImagesMethod1()
	{
		WebDriver driver=initilizeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		for(WebElement img:images)
		{
			if(img.getAttribute("naturalWidth").equals("0"))
			{
				System.out.println(img.getAttribute("src") +"is broken");
			}
			else
			{
				System.out.println(img.getAttribute("src") +"is not broken");
			}
		}
		
		
	}
	
	@Test
	public void getBrokerImagesMethod2()
	{
		//Using Rest Assured to check status code
		WebDriver driver=initilizeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		for(WebElement img:images)
		{
			Response response=RestAssured.given().contentType("application/json").get(img.getAttribute("src"));
			
			if(img.getAttribute("naturalWidth").equals("0"))
			{
				System.out.println(response.getStatusCode());
				System.out.println(img.getAttribute("src") +"is broken");
			}
			else
			{System.out.println(response.getStatusCode());
				System.out.println(img.getAttribute("src") +"is not broken");
			}
		}
		
		
	}
	
	
}
