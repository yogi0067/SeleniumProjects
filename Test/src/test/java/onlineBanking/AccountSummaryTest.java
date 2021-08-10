package onlineBanking;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class AccountSummaryTest extends BaseClass {
	WebDriver driver = initilizeDriver();
	LoginPageObject lpo = new LoginPageObject(driver);
	TransferFundsPageObject tfpo = new TransferFundsPageObject(driver);
	OnlineLinePageObject obpo = new OnlineLinePageObject(driver);
	WebDriverWait wait = new WebDriverWait(driver, 10);
	String fromAccValue = "";
	double amount ;
	String toAccValue;

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
		 amount = 10;
		Select fromAcc = new Select(tfpo.getFromAccount());
		Select toAcc = new Select(tfpo.getToAccount());
		fromAccValue = "800002";
		 toAccValue = "800003";
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

	@Test(dependsOnMethods = "transferAmountTest")
	public void clickGoAccTest() {
		obpo.getView_Account_Summary().click();
		WebElement list = obpo.getListAccountsDropDown();
		Select dropdown = new Select(list);
		// String visibleText="4539082039396288 Credit Card";
		dropdown.selectByValue(fromAccValue);
		obpo.getGoButton().click();
		Assert.assertTrue(obpo.getAccountHistory().isDisplayed());
	}

	@Test(dependsOnMethods = "clickGoAccTest")
	public void fromAccountAmountWithdrawalTest() {
		
		List<WebElement> columns = obpo.getRecentTransaction();
		//System.out.println(columns.get(0).getText());
		String transactionType=columns.get(1).getText();
		String returnAmount=columns.get(2).getText();
		String exptected="-$"+amount+"0";
		System.out.println(exptected.equalsIgnoreCase(returnAmount));
		
		Assert.assertEquals(transactionType, "Withdrawal");
		Assert.assertEquals(returnAmount, exptected);
		
		
	}
	
	@Test(dependsOnMethods = "fromAccountAmountWithdrawalTest")
	public void fromAccountAmountDepositTest() {
		
		WebElement list = obpo.getListAccountsDropDown();
		Select dropdown = new Select(list);
		// String visibleText="4539082039396288 Credit Card";
		dropdown.selectByValue(toAccValue);
		obpo.getGoButton().click();
		
		List<WebElement> columns = obpo.getRecentTransaction();
		//System.out.println(columns.get(0).getText());
		String transactionType=columns.get(1).getText();
		String returnAmount=columns.get(2).getText();
		String exptected="$"+amount+"0";
		System.out.println(exptected.equalsIgnoreCase(returnAmount));
		
		Assert.assertEquals(transactionType, "Deposit");
		Assert.assertEquals(returnAmount, exptected);

	}
	@Test
	public void zfailed()
	{
		Assert.assertTrue(false,"Fail and screenshot tested");
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}

}
