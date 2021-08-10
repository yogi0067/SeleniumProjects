package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utilites.BaseClass;

public class FirstTest extends BaseClass{

	WebDriver driver;
	@Test
	public void openMainPage() throws IOException, InterruptedException
	{
		driver=initilizeDriver();
		driver.get(getPropertyValue("url"));
		driver.manage().window().maximize();	
		
	}
	@Test()
	public void searchSomething()
	{
		//driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Head Phone");
		WebElement ele= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		System.out.println(ele.getAttribute("type"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='Head Phone'", ele);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		
		js.executeScript("window.scrollBy(0,350)", "");
	}
	@Test(dependsOnMethods = {"openMainPage"},enabled=false)
	public void checkAccountTabOptions()
	{
		////*[@id='nav-link-accountList-nav-line-1']
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"))).build().perform();
		
		
		
		////*[@id='nav-al-wishlist'] //*[@class='nav-text']
		
		////*[@id='nav-al-your-account'] //*[@class='nav-text']
		
		//Your Recommendations
		List<WebElement> wislist= driver.findElements(By.xpath("//*[@id='nav-al-wishlist'] //*[@class='nav-text']"));
		
		List<WebElement> youraccount= driver.findElements(By.xpath("//*[@id='nav-al-your-account']//*[@class='nav-text']"));
		//System.out.println(youraccount);
		Iterator<WebElement> it =youraccount.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getText());
			WebElement temp=it.next();
			if(temp.getText().equalsIgnoreCase("Your Recommendations"))
			{
				temp.click();
				break;
			}
		}
		
		
	}
	
	
}
