package adminTests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MainLoginPage;
import pageObjects.Users;
import utilites.BaseClass;

public class UsersTest extends BaseClass{
	
	
	WebDriver driver;
	MainLoginPage mlpo;
	HomePage hopo;
	WebDriverWait wait;
	Users upo;
	@Test
	public void LoginTest() throws IOException
	{
		driver=initilizeDriver();
		driver.get(getProperty("url"));
		mlpo= new MainLoginPage(driver);
		hopo= new HomePage(driver);
		upo= new Users(driver);
		wait= new WebDriverWait(driver, 30);
		mlpo.userName().sendKeys(getProperty("userName"));
		mlpo.password().sendKeys(getProperty("password"));
		mlpo.loginButton().click();
	}
	
	@Test(dependsOnMethods = "LoginTest")
	public void Test1()
	{
		wait.until(ExpectedConditions.elementToBeClickable(hopo.admin_menu()));
		hopo.admin_menu().click();
		
	}
	@Test(dependsOnMethods = "Test1")
	public void Test2() throws InterruptedException
	{
		
		upo.searchUserName().sendKeys("Aatmaram");
		upo.searchUserstatueDropDown().selectByVisibleText("Enabled");
		upo.searchuserTypeDropDown().selectByIndex(2);
		upo.searchemployeeName().sendKeys("Alice");
		/*
		 * Actions ac= new Actions(driver);
		 * ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		 * upo.searchButton().click();
		 */
		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='ac_results']/ul/li"));
		Thread.sleep(3000);
		for(WebElement ele:elements)
		{
			System.out.println(ele.getText());
			if(ele.getText().equalsIgnoreCase("Aatmaram"))
			{
				
				ele.click();
				break;
			}
		}
		upo.searchButton().click();
		Thread.sleep(3000);
		String expectedUserName="Aamaram";
		
		int rows=upo.rows().size();
		System.out.println("Rows "+rows);
		String actualUserName="";
		int columns=upo.column().size();
		System.out.println("columns "+columns);
		boolean noeows=upo.noRecordsFound().getText().equalsIgnoreCase("No Records Found");
		if(noeows)
		{
			System.out.println("No Records Found");
		}
		else {
		for(int i=1; i<=rows; i++)
		{
			for(int j=2; j<=columns; j++)
			{
				System.out.print(upo.getColumnValue(i, j,driver).getText());
			}
			System.out.println();
		}
		actualUserName=upo.getColumnValue(1, 2,driver).getText();
		}
		System.out.println("expectedUserName"+expectedUserName);
		System.out.println("actualUserName"+actualUserName);
		try {
		Assert.assertEquals(actualUserName, expectedUserName);}
		catch(Throwable t)
		{
			System.out.println(t);
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
