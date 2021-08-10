package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InterfaceLog {
	WebDriver driver;

	public InterfaceLog(WebDriver driver)	
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@name=\"username\"]")
	WebElement userName;
	public WebElement userName()
	{
		return userName;
	}
	@FindBy(xpath = "//*[@name=\"password\"]")
	WebElement password;
	public WebElement password()
	{
		return password;
	}
	
}
