package onlineBankingPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[src*='logo.gif']")
	WebElement logo;
	public WebElement getAltoroMutualLogo()
	{
		return logo;
	}
	@FindBy(css = "#AccountLink")
	WebElement ONLINE_BANKING_LOGIN;
	public WebElement getONLINE_BANKING_LOGIN()
	{
		return ONLINE_BANKING_LOGIN;
	}
	@FindBy(css = "#LinkHeader2")
	WebElement PERSONAL;
	public WebElement getPERSONAL()
	{
		return PERSONAL;
	}
	@FindBy(css = "#LinkHeader3")
	WebElement SMALL_BUSINESS;
	public WebElement getSMALL_BUSINESS()
	{
		return SMALL_BUSINESS;
	}
	@FindBy(css = "#LinkHeader4")
	WebElement INSIDE_ALTORO_MUTUAL;
	public WebElement getINSIDE_ALTORO_MUTUAL()
	{
		return INSIDE_ALTORO_MUTUAL;
	}
	
	@FindBy(css = "#uid")
	WebElement userName;
	public WebElement getuserName()
	{
		return userName;
	}
	@FindBy(css = "#passw")
	WebElement password;
	public WebElement getPassword()
	{
		return password;
	}
	
	@FindBy(xpath = "//*[@name='btnSubmit']")
	WebElement login;
	public WebElement getLogin()
	{
		return login;
	}
	@FindBy(css = "#_ctl0__ctl0_Content_Main_message")
	WebElement validationMessage;
	public WebElement getValidationMessage()
	{
		return validationMessage;
	}
	@FindBy(css = "#MenuHyperLink3")
	WebElement transfer_Funds;
	public WebElement getTransfer_Funds()
	{
		return transfer_Funds;
	}
	
	
	
	
	
}
