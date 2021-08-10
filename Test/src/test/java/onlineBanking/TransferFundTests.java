package onlineBanking;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import onlineBankingPageObjects.LoginPageObject;
import onlineBankingPageObjects.OnlineLinePageObject;
import onlineBankingPageObjects.TransferFundsPageObject;
import utilites.BaseClass;

public class TransferFundTests extends BaseClass {
	WebDriver driver = initilizeDriver();
	LoginPageObject lpo = new LoginPageObject(driver);
	TransferFundsPageObject tfpo = new TransferFundsPageObject(driver);
	OnlineLinePageObject obpo = new OnlineLinePageObject(driver);
	WebDriverWait wait = new WebDriverWait(driver, 10);

	@Test
	public void AltoroMutualImageTest() throws IOException {
		driver.manage().window().maximize();
		driver.get(getPropertyValue("onlineBakingUrl"));
		Assert.assertTrue(lpo.getAltoroMutualLogo().isDisplayed());
	}

	@Test(dependsOnMethods = "AltoroMutualImageTest")
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

	@Test(dependsOnMethods = "Login")
	public void checkNavigatetoTransferFundPage() {
		lpo.getTransfer_Funds().click();
		Assert.assertTrue(tfpo.getTransferFundPage().isDisplayed());
	}

	@Test(dependsOnMethods = "checkNavigatetoTransferFundPage")
	public void transferAmountTest() {
		double amount = 10;
		Select fromAcc = new Select(tfpo.getFromAccount());
		Select toAcc = new Select(tfpo.getToAccount());
		String fromAccValue = "800002";
		String toAccValue = "800003";
		if (fromAccValue.equalsIgnoreCase(toAccValue)) {
			Assert.assertTrue(false);
		} else {
			fromAcc.selectByValue(fromAccValue);
			toAcc.selectByValue(toAccValue);
			tfpo.getTransferAmount().sendKeys(Double.toString(amount));
			tfpo.getTransferButton().click();
			String transferMessage = tfpo.getTransferMessage().getText();
			if (transferMessage.contains(Double.toString(amount) + " was successfully transferred")
					&& transferMessage.contains("from Account " + fromAccValue)
					&& transferMessage.contains("into Account " + toAccValue)) {
				// 121.0 was successfully transferred from Account 800002 into Account 800003 at
				// 8/7/21 10:31 AM.
				Assert.assertTrue(true);
			}
		}
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}
