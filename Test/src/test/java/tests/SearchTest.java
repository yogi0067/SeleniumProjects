package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.runners.ParentRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageobjects.PageObjectsPratice;
import utilites.BaseClass;

public class SearchTest extends BaseClass {

	WebDriver driver = initilizeDriver();
	PageObjectsPratice po = new PageObjectsPratice(driver);
	WebDriverWait wait= new WebDriverWait(driver, 10);

	@Test(priority = 1)
	public void test_1() throws InterruptedException, IOException {

		driver.manage().window().maximize();
		driver.get(getPropertyValue("autoPracticeUrl"));
		po.searchBox().sendKeys("FIS");
		po.searchButton().click();
		List<WebElement> list = po.listOfSearchResults();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.isEmpty());
		Iterator<WebElement> itr = list.iterator();

		while (itr.hasNext()) {
			WebElement ele = itr.next();
			System.out.println(ele.getText());
			if (ele.getText().equalsIgnoreCase("FIS")) {
				ele.click();
				break;
			}
//			
		}
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String s : windows) {
			driver.switchTo().window(s);
			if (driver.getTitle().contains("FIS")) {
				System.out.println("Test Passed");
				Assert.assertTrue("Passed", true);
				break;
			}
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}
	@Test(priority = 2)
	public void test_2()
	{
		System.out.println(driver.getTitle());
		wait.until(ExpectedConditions.visibilityOf(po.copyTextButton()));
		Actions action= new Actions(driver);
		
		action.moveToElement(po.copyTextButton()).doubleClick().build().perform();
		wait.until(ExpectedConditions.visibilityOf(po.getField1()));
		String expectedValue=po.getField1().getAttribute("value");
		String actualValue=po.getField2().getAttribute("value");
		
		Assert.assertEquals(actualValue,expectedValue);
	}
	@Test(priority = 3)
	public void test_3()
	{
		po.getAlertButton().click();
		driver.switchTo().alert().accept();
		String expectedValue="You pressed OK!";
		String actualValue=po.getAlertButtonOutput().getText();
		System.out.println(actualValue);
		Assert.assertEquals(actualValue,expectedValue);
		
	}
	@Test(priority = 4)
	public void test_4()
	{
		Actions action= new Actions(driver);
		action.dragAndDrop(po.getDraggable(), po.getDroppable()).build().perform();
		System.out.println();
		String expectedValue="Dropped";
		String actualValue=po.getDroppable().getText();
		System.out.println(actualValue);
		Assert.assertEquals(actualValue,expectedValue);
	}
	

}
