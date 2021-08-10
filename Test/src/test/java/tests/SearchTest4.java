package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageobjects.PageObjectsPratice;
import utilites.BaseClass;

public class SearchTest4 extends BaseClass {

	WebDriver driver = initilizeDriver();
	PageObjectsPratice po = new PageObjectsPratice(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Test()
	public void a() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		driver.get(getPropertyValue("autoPracticeUrl"));
		js.executeScript("arguments[0].scrollIntoView()", po.getTable());
		int columns = po.getTableColumns(2,driver).size();
		int rows = po.getTableRows().size();
		int headings=po.getTableHeading().size();
		System.out.println(columns);
		for(int i=1; i<rows; i++)
		{
			if(i==1)
			{
				for(WebElement h:po.getTableHeading())
				{
					System.out.print(h.getText() +" ");
				}
				System.out.println("");
			}
			else {
			for(int j=0; j<columns; j++)
			{
				//po.getTableRows().get(i).getText();
				//System.out.print(po.getTableRows().get(i).getText());
				System.out.print(po.getTableColumns(i,driver).get(j).getText()+ " ");
			}
			System.out.println("");
		}}
	}
}
