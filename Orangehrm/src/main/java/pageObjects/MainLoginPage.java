package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainLoginPage {
	WebDriver driver;
	public MainLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#txtUsername")
	WebElement userName;
	public WebElement userName()
	{
		return userName;
	}
	@FindBy(css = "#txtPassword")
	WebElement password;
	public WebElement password()
	{
		return password;
	}
	@FindBy(css = "#btnLogin")
	WebElement loginButton;
	public WebElement loginButton()
	{
		return loginButton;
	}
	
	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPassword;
	public WebElement forgotPassword()
	{
		return forgotPassword;
	}
	
	@FindBy(css = "#securityAuthentication_userName")
	WebElement forgoruserName;
	public WebElement forgoruserName()
	{
		return forgoruserName;
	}
	@FindBy(css = "#btnSearchValues")
	WebElement resetPasswordButton;
	public WebElement resetPasswordButton()
	{
		return resetPasswordButton;
	}
	@FindBy(xpath = "//*[@class='message warning fadable']")
	WebElement confirmationmessage;
	public WebElement confirmationmessage()
	{
		return confirmationmessage;
	}
	@FindBy(css = "#btnCancel")
	WebElement btnCancel;
	public WebElement btnCancel()
	{
		return btnCancel;
	}
	
}
