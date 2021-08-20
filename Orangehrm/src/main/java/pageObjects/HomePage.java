package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#menu_admin_viewAdminModule")
	WebElement admin_menu;
	public WebElement admin_menu()
	{
		return admin_menu;
	}
	
	@FindBy(css = "#menu_admin_UserManagement")
	WebElement usermanagement_menu;
	public WebElement usermanagement_menu()
	{
		return usermanagement_menu;
	}
	
	@FindBy(css = "#menu_admin_viewSystemUsers")
	WebElement users_menu;
	public WebElement users_menu()
	{
		return users_menu;
	}
	
	@FindBy(xpath = "//img[contains(@src,'logo.png')]")
	WebElement logo;
	public WebElement logo()
	{
		return logo;
	}
	
}
