package onlineBankingPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsPageObject {
	
	WebDriver driver;
	public TransferFundsPageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[text()=\"Transfer Funds\"]")
	WebElement getTransferFundPage;
	public WebElement getTransferFundPage()
	{
		return getTransferFundPage;
	}
	@FindBy(css = "#fromAccount")
	WebElement fromAccount;
	public WebElement getFromAccount()
	{
		return fromAccount;
	}
	@FindBy(css = "#toAccount")
	WebElement toAccount;
	public WebElement getToAccount()
	{
		return toAccount;
	}
	@FindBy(css = "#transferAmount")
	WebElement transferAmount;
	public WebElement getTransferAmount()
	{
		return transferAmount;
	}
	@FindBy(css = "#transfer")
	WebElement transferButton;
	public WebElement getTransferButton()
	{
		return transferButton;
	}
	@FindBy(css = "#_ctl0__ctl0_Content_Main_postResp")
	WebElement transferMessage;
	public WebElement getTransferMessage()
	{
		return transferMessage;
	}
	
	
}
