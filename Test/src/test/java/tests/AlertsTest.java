package tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pageobjects.AlertPageObjects;
import utilites.BaseClass;

public class AlertsTest extends BaseClass {
	WebDriver driver=initilizeDriver();
	AlertPageObjects apo= new AlertPageObjects(driver);
	Alert jsAlert;
	@Test
	public void jsAlertTest()
	{
		try {
			driver.get(getPropertyValue("alertUrl"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		apo.getJsAlert().click();
		 jsAlert = driver.switchTo().alert();
		jsAlert.accept();
		System.out.println(apo.getResult().getText());
	}
	@Test
	public void jsConfirmTest_OK()
	{
		apo.getJsConfirm().click();
		jsAlert=driver.switchTo().alert();
		jsAlert.accept();
		System.out.println(apo.getResult().getText());
		
	}
	@Test
	public void jsConfirmTest_Cancel()
	{
		apo.getJsConfirm().click();
		jsAlert=driver.switchTo().alert();
		jsAlert.dismiss();
		System.out.println(apo.getResult().getText());
		
	}
	
	@Test
	public void jsPromptTest_Cancel_withdata()
	{
		apo.getJsPrompt().click();
		jsAlert=driver.switchTo().alert();
		jsAlert.sendKeys("abc");
		jsAlert.dismiss();
		System.out.println(apo.getResult().getText());
		
	}
	@Test
	public void jsPromptTest_Cancel()
	{
		apo.getJsPrompt().click();
		jsAlert=driver.switchTo().alert();
		jsAlert.dismiss();
		System.out.println(apo.getResult().getText());
		
	}
	@Test
	public void jsPromptTest_ok_withoutdata()
	{
		apo.getJsPrompt().click();
		jsAlert=driver.switchTo().alert();
		jsAlert.accept();
		System.out.println(apo.getResult().getText());
		
	}
	@Test
	public void jsPromptTest_ok_withdata()
	{
		apo.getJsPrompt().click();
		jsAlert=driver.switchTo().alert();
		jsAlert.sendKeys("abc");
		jsAlert.accept();
		System.out.println(apo.getResult().getText());
		//driver.close();
		
	}
	@Test
	public void testslider()
	{
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
		int x=driver.findElement(By.xpath("//*[@type='range']")).getLocation().getX();
		int y=driver.findElement(By.xpath("//*[@type='range']")).getLocation().getY();
		Dimension sliderSize=driver.findElement(By.xpath("//*[@type='range']")).getSize();
		int sliderWidth = sliderSize.getWidth();
		System.out.println("sliderSize"+ sliderSize +"y"+y);
		Actions action= new Actions(driver);
		action.dragAndDropBy(driver.findElement(By.xpath("//*[@type='range']")), 32, 0).build().perform();
		action.sendKeys(driver.findElement(By.xpath("//*[@type='range']")),Keys.ARROW_LEFT,Keys.LEFT).build().perform();
		
		
		
		
		
	}
	
	
	

}
