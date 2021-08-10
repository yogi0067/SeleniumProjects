package onlineBankingPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineLinePageObject {
	WebDriver driver;
	
	public OnlineLinePageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#MenuHyperLink1")
	WebElement view_Account_Summary;
	public WebElement getView_Account_Summary()
	{
		return view_Account_Summary;
	}
	
	@FindBy(css = "#listAccounts")
	WebElement listAccounts;
	public WebElement getListAccountsDropDown()
	{
		return listAccounts;
	}
	
	@FindBy(css = "#btnGetAccount")
	WebElement btnGetAccount;
	public WebElement getGoButton()
	{
		return btnGetAccount;
	}
	
	@FindBy(xpath = "//*[@class='fl']/h1")
	WebElement accountHistory;
	public WebElement getAccountHistory()
	{
		return accountHistory;
	}
	
	@FindBy(xpath = "//*[@class='fl']/table/tbody/tr/td/table/tbody/tr[3]/td[1]")
	WebElement dateTableColumn;
	public WebElement getDateTableColumn()
	{
		return dateTableColumn;
	}
	
	@FindBy(xpath = "//*[@id=\"recent\"]/table/tbody/tr[1]/td")
	List <WebElement> recentTransaction;
	public List <WebElement> getRecentTransaction()
	{
		return recentTransaction;
	}
	
	
}
