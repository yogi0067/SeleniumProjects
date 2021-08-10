package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsPratice {
	WebDriver driver;
	
	public PageObjectsPratice(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath = "//*[@id='Wikipedia1_wikipedia-search-input']")
	WebElement searchBox;
	public WebElement searchBox()
	{
		return searchBox;
	}
	
	@FindBy(xpath = "//*[@class='wikipedia-search-button']")
	WebElement searchButton;
	public WebElement searchButton()
	{
		return searchButton;
	}
	
	@FindBy(xpath = "//*[@id='wikipedia-search-result-link']/a")
	List <WebElement> listOfSearchResults;
	public List<WebElement> listOfSearchResults()
	{
		return listOfSearchResults;
	}
	@FindBy(xpath = "//*[@ondblclick='myFunction1()']")
	WebElement copyTextButton;
	public WebElement copyTextButton()
	{
		return copyTextButton;
	}
	@FindBy(xpath =  "//*[@id = 'field1']")
	WebElement field1;
	public WebElement getField1()
	{
		return field1;
	}
	@FindBy(css =  "#field2")
	WebElement field2;
	public WebElement getField2()
	{
		return field2;
	}
	@FindBy(xpath =  "//*[@onclick='myFunction()']")
	WebElement alertButton;
	public WebElement getAlertButton()
	{
		return alertButton;
	}
	@FindBy(xpath =  "//*[@id='demo']")
	WebElement alertButtonOutput;
	public WebElement getAlertButtonOutput()
	{
		return alertButtonOutput;
	}
	@FindBy(css =  "#draggable")
	WebElement draggable;
	public WebElement getDraggable()
	{
		return draggable;
	}
	@FindBy(css =  "#droppable")
	WebElement droppable;
	public WebElement getDroppable()
	{
		return droppable;
	}
	@FindBy(xpath = "//*[@id='slider']/span")
	WebElement slider;
	public WebElement getSlider()
	{
		return slider;
	}
	@FindBy(css =  "#resizable")
	WebElement resizable;
	public WebElement getResizable()
	{
		return resizable;
	}
	@FindBy(css =  "#datepicker")
	WebElement dateField;
	public WebElement getDateField()
	{
		return dateField;
	}
	@FindBy(xpath =  "//*[@class='ui-state-default']")
	List <WebElement> datepicker;
	public List <WebElement> getDatepicker()
	{
		return datepicker;
	}
	@FindBy(xpath = "//*[@class='ui-datepicker-month']")
	WebElement month;
	public WebElement getMonth()
	{
		return month;
	}
	@FindBy(xpath = "//*[@class='ui-datepicker-year']")
	WebElement year;
	public WebElement getYear()
	{
		return year;
	}
	@FindBy(xpath = "//*[@title='Prev']")
	WebElement prev;
	public WebElement getPrev()
	{
		return prev;
	}
	@FindBy(xpath = "//*[@data-handler='next']/span")
	WebElement next;
	public WebElement getNext()
	{
		return next;
	}
	@FindBy(xpath = "//*[@name='BookTable']")
	WebElement table;
	public WebElement getTable()
	{
		return table;
	}
	@FindBy(xpath = "//*[@name='BookTable']/tbody/tr/th")
	List <WebElement> tableHeading;
	public List<WebElement> getTableHeading()
	{
		return tableHeading;
	}
	@FindBy(xpath = "//*[@name='BookTable']/tbody/tr")
	List <WebElement> tableRows;
	public List<WebElement> getTableRows()
	{
		return tableRows;
	}
	
	
	public List<WebElement> getTableColumns(int i,WebDriver driver)
	{
		return driver.findElements(By.xpath("//*[@name='BookTable']/tbody/tr["+i+"]/td"));
	}
	

}
