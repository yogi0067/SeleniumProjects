package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.PageObjectsPratice;
import utilites.BaseClass;

public class SearchTest3 extends BaseClass {

	WebDriver driver = initilizeDriver();
	PageObjectsPratice po = new PageObjectsPratice(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Test(dataProvider = "getdate")
	public void a(String month,String Year,String date) throws IOException, InterruptedException {
		driver.manage().window().maximize();
		driver.get(getPropertyValue("autoPracticeUrl"));
		po.getDateField().click();

		String getMonth = po.getMonth().getText();
		String getYear = po.getYear().getText();
		System.out.println(getMonth + " " + getYear);
		while (!(getMonth.equalsIgnoreCase(month) && getYear.equalsIgnoreCase(Year))) {
			po.getNext().click();
			Thread.sleep(2000);
			getMonth = po.getMonth().getText();
			getYear = po.getYear().getText();

		}
		List<WebElement> dates = po.getDatepicker();
		for (WebElement ele : dates) {
			System.out.println(ele.getText());
			if (ele.getText().equalsIgnoreCase(date)) {
				ele.click();
				break;
			}
		}
		
		String actualValue = po.getDateField().getAttribute("value");
		
		System.out.println(actualValue);
		
	}
	@DataProvider
	public Object[][] getdate()
	{
		
		Object object[][]= {{"November","2021","15"}};
		return object;
		
	}
}
