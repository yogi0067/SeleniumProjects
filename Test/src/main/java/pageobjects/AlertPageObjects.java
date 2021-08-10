package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPageObjects {
	WebDriver driver;
	
	
	public AlertPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@onclick='jsAlert()']")
	WebElement jsAlert;
	public WebElement getJsAlert()
	{
		return jsAlert;
	}
	@FindBy(xpath = "//*[@onclick='jsConfirm()']")
	WebElement jsConfirm;
	public WebElement getJsConfirm()
	{
		return jsConfirm;
	}
	@FindBy(css = "#result")
	WebElement result;
	public WebElement getResult()
	{
		return result;
	}
	@FindBy(xpath = "//*[@onclick='jsPrompt()']")
	WebElement jsPrompt;
	public WebElement getJsPrompt()
	{
		return jsPrompt;
	}
}
