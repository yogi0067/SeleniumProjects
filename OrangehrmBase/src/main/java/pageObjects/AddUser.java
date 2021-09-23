package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUser {
	WebDriver driver;
	public AddUser(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#systemUser_userName")
	WebElement systemUser_userName;
	public WebElement systemUser_userName()
	{
		return systemUser_userName;
	}
	@FindBy(css = "#systemUser_userType")
	WebElement systemUser_userType;
	public Select systemUser_userType()
	{
		Select s = new Select(systemUser_userType);
		return s;
		
	}
	@FindBy(css = "#systemUser_employeeName_empName")
	WebElement systemUser_employeeName_empName;
	public WebElement systemUser_employeeName_empName()
	{
		return systemUser_employeeName_empName;
	}
	@FindBy(css = "#systemUser_status")
	WebElement systemUser_status;
	public Select systemUser_status()
	{
		Select s = new Select(systemUser_status);
		return s;
		
	}
	@FindBy(css = "#systemUser_password")
	WebElement systemUser_password;
	public WebElement systemUser_password()
	{
		return systemUser_password;
	}
	@FindBy(css = "#systemUser_confirmPassword")
	WebElement systemUser_confirmPassword;
	public WebElement systemUser_confirmPassword()
	{
		return systemUser_confirmPassword;
	}
	@FindBy(css = "#btnSave")
	WebElement btnSave;
	public WebElement saveButton()
	{
		return btnSave;
	}
	@FindBy(css = "#btnCancel")
	WebElement btnCancel;
	public WebElement cancelButton()
	{
		return btnCancel;
	}
	@FindBy(xpath = "//span[@for='systemUser_userName']")
	WebElement userValidation;
	public WebElement userNameValidation()
	{
		return userValidation;
	}


}
