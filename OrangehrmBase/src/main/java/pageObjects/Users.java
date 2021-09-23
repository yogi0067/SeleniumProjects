package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Users {
	WebDriver driver;

	public Users(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#searchSystemUser_userName")
	WebElement searchUserName;

	public WebElement searchUserName() {
		return searchUserName;
	}

	@FindBy(css = "#searchSystemUser_userType")
	WebElement searchuserTypeDropDown;

	public Select searchuserTypeDropDown() {
		Select s = new Select(searchuserTypeDropDown);
		return s;

	}

	@FindBy(css = "#searchSystemUser_employeeName_empName")
	WebElement searchemployeeName;

	public WebElement searchemployeeName() {
		return searchemployeeName;
	}

	@FindBy(css = "#searchSystemUser_status")
	WebElement searchUserstatueDropDown;

	public Select searchUserstatueDropDown() {
		Select s = new Select(searchUserstatueDropDown);
		return s;

	}

	@FindBy(css = "#searchBtn")
	WebElement searchButton;

	public WebElement searchButton() {
		return searchButton;
	}

	@FindBy(xpath = "//*[@id='resultTable']/tbody/tr")
	List<WebElement> rows;

	public List<WebElement> rows() {
		return rows;
	}

	@FindBy(xpath = "//*[@id='resultTable']/thead/tr/th")
	List<WebElement> column;

	public List<WebElement> column() {
		return column;
	}

	@FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td")
	WebElement noRecordsFound;

	public WebElement noRecordsFound() {
		return noRecordsFound;
	}

	public WebElement getColumnValue(int i, int j, WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[" + j + "]"));
	}

	@FindBy(xpath = "//*[@id='btnAdd']")
	WebElement addButton;

	public WebElement addButton() {
		return addButton;
	}

	@FindBy(xpath = "//*[@id='btnDelete']")
	WebElement deleteButton;

	public WebElement deleteButton() {
		return deleteButton;
	}

}
