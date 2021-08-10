package onlineBanking;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import onlineBankingPageObjects.LoginPageObject;
import utilites.BaseClass;

public class LoginPageTestUsingDocker extends BaseClass {

	
	WebDriver driver;// = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"),dc );
	
	LoginPageObject lpo;// = new LoginPageObject(driver);
	WebDriverWait wait;// = new WebDriverWait(driver, 10);

	@Test
	public void AltoroMutualImageTest() throws IOException {
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName(BrowserType.FIREFOX);
		driver=initilizeDriver(dc);
		
		lpo = new LoginPageObject(driver);
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.get(getPropertyValue("onlineBakingUrl"));
		Assert.assertTrue(lpo.getAltoroMutualLogo().isDisplayed());
	}

	@Test
	public void CheckTab_ONLINE_BANKING_LOGIN() {
		Assert.assertTrue(lpo.getONLINE_BANKING_LOGIN().isDisplayed());
	}

	@Test
	public void CheckTab_PERSONAL() {
		Assert.assertTrue(lpo.getPERSONAL().isDisplayed());
	}

	@Test
	public void CheckTab_SMALL_BUSINESS() {
		Assert.assertTrue(lpo.getSMALL_BUSINESS().isDisplayed());
	}

	@Test
	public void CheckTab_INSIDE_ALTORO_MUTUAL() {
		Assert.assertTrue(lpo.getINSIDE_ALTORO_MUTUAL().isDisplayed());
	}

	@Test
	public void wrongLogin() {
		String expectedResults = "Login Failed: We're sorry, but this username or password was not found in our system. Please try again.";

		try {
			lpo.getuserName().sendKeys(getPropertyValue("incorrectbankingUserName"));
			lpo.getPassword().sendKeys(getPropertyValue("incorrectbankingPassword"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lpo.getLogin().click();
		wait.until(ExpectedConditions.visibilityOf(lpo.getValidationMessage()));
		String actualResults = lpo.getValidationMessage().getText();
		Assert.assertEquals(actualResults, expectedResults);
		//					-$65, "-$"+expectedResults

	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
