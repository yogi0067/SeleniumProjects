package onlineBanking;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import onlineBankingPageObjects.LoginPageObject;
import onlineBankingPageObjects.OnlineLinePageObject;
import utilites.BaseClass;

public class OnlineBankingTestUsingDocker extends BaseClass {

	WebDriver driver;// = initilizeDriver();
	LoginPageObject lpo;// = new LoginPageObject(driver);
	OnlineLinePageObject obpo;// = new OnlineLinePageObject(driver);
	WebDriverWait wait;// = new WebDriverWait(driver, 10);

	@Test
	public void AltoroMutualImageTest() throws IOException {
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName(BrowserType.CHROME);
		driver=initilizeDriver(dc);
		lpo = new LoginPageObject(driver);
		obpo = new OnlineLinePageObject(driver);
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.get(getPropertyValue("onlineBakingUrl"));
		Assert.assertTrue(lpo.getAltoroMutualLogo().isDisplayed());
	}

	@Test
	public void Login() {
		// String expectedResults = "Login Failed: We're sorry, but this username or
		// password was not found in our system. Please try again.";

		try {
			lpo.getuserName().sendKeys(getPropertyValue("bankingUserName"));
			lpo.getPassword().sendKeys(getPropertyValue("bankingPassword"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lpo.getLogin().click();
		wait.until(ExpectedConditions.visibilityOf(obpo.getView_Account_Summary()));
		Assert.assertTrue(obpo.getView_Account_Summary().isDisplayed());
	}

	@Test
	public void clickGoAccTest() {
		  WebElement list = obpo.getListAccountsDropDown();	
		  Select dropdown= new Select(list);
		  String visibleText="4539082039396288 Credit Card";
		  dropdown.selectByVisibleText(visibleText);
		  obpo.getGoButton().click();
		  Assert.assertTrue(obpo.getAccountHistory().isDisplayed());
	}
	@Test(dependsOnMethods = {"clickGoAccTest"})
	public void checkAccNumber()
	{
		String exptectedResults="4539082039396288 Credit Card";
		String actualResults=obpo.getAccountHistory().getText();
		System.out.println(actualResults);
		
		Assert.assertTrue(actualResults.contains(exptectedResults));
		
	}
	@Test(dependsOnMethods = {"checkAccNumber"})
	public void checkDate()
	{
		
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj=DateTimeFormatter.ofPattern("M/d/yy");
		System.out.println("After formatting: " + myDateObj.format(myFormatObj));
		String date=obpo.getDateTableColumn().getText();
		System.out.println(date);
		Assert.assertTrue(date.contains(myDateObj.format(myFormatObj)));
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
