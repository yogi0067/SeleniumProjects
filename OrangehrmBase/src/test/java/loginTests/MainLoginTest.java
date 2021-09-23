package loginTests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MainLoginPage;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utilites.BaseClass;
import utilites.ExcelOperations;

public class MainLoginTest extends BaseClass {
	WebDriver driver;
	MainLoginPage mlpo;
	HomePage hppo;
	XSSFWorkbook excelfile;
	XSSFSheet sheet;
	XSSFRow rows;
	XSSFCell cell;
	int row = 1;
	int col = 4;
	String excelFilepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\TestData.xlsx";
	String excelForgotPassordFilepath=System.getProperty("user.dir") + "\\src\\main\\java\\resources\\TestDataForForgotPassword.xlsx";
	WebDriverWait wait;

	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initilizeDriver();
		
		driver.get(getProperty("url"));
		mlpo = new MainLoginPage(driver);
		hppo= new HomePage(driver);
		wait= new WebDriverWait(driver, 20);
	}
	
	@Test(dataProvider = "getForGotPasswordTestData",enabled = false)
	public void CheckforgotPassword(String userName, String Password,String forgotUserName) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(mlpo.forgotPassword()));
		mlpo.userName().sendKeys(userName);
		mlpo.password().sendKeys(Password);
		mlpo.forgotPassword().click();
		Thread.sleep(2000);
		mlpo.forgoruserName().sendKeys(forgotUserName);
		mlpo.resetPasswordButton().click();		
		System.out.println(mlpo.confirmationmessage().getText());
		Thread.sleep(2000);
		mlpo.btnCancel().click();
		
	}
	@Test(dataProvider = "getData")
	public void LoginTest(String userName, String password, String testCaseName, String expectedResults)
			throws IOException, InterruptedException {
		
		ExcelOperations excelobj = new ExcelOperations();
		
		
		mlpo.userName().sendKeys(userName);
		mlpo.password().sendKeys(password);
		mlpo.loginButton().click();
		Thread.sleep(2000);
		Boolean flag = false;
		try {
			flag = driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		if (flag) {

			excelobj.setCellValue(excelFilepath, "Sheet1", row, col, "Login Fail");
		} else {
			if (driver.findElement(By.cssSelector("#welcome")).getText().contains("Welcome")) {
				excelobj.setCellValue(excelFilepath, "Sheet1", row, col, "Login Pass");
			}
		}
	}
	@Test(dependsOnMethods="LoginTest")
	public void checkImage() throws InterruptedException
	{
		String imageUrl=hppo.logo().getAttribute("src");
		BufferedImage saveImgae = null;
		try {
			saveImgae = ImageIO.read(new URL(imageUrl));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println(e1);
			System.out.println("1");
		}
		try {
			ImageIO.write(saveImgae, "png", new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\actual.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
			System.out.println("2");
		}
		ImageDiffer differ= new ImageDiffer();
		BufferedImage expectedimage=null;
		try {
			expectedimage = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\textbox.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
			System.out.println("3");
		}
		Thread.sleep(3000);
		BufferedImage actualImage = null;
		try {
			actualImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\actual.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
			System.out.println("4");
		}
		Thread.sleep(3000);
		ImageDiff diff= differ.makeDiff(expectedimage, actualImage);
		System.out.println(diff.hasDiff());
		Assert.assertFalse(diff.hasDiff(),"Images are Not Same");
		System.out.println("check");
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		ExcelOperations excelobj = new ExcelOperations();
		int row = excelobj.getRowCount(excelFilepath, "Sheet1");
		int column = excelobj.getColumnCount(excelFilepath, "Sheet1");
		Object[][] data = new Object[row - 1][column - 1];
		FileInputStream fis = new FileInputStream(excelFilepath);
		excelfile = new XSSFWorkbook(fis);
		sheet = excelfile.getSheet("Sheet1");
		System.out.println(row);
		System.out.println(column);
		for (int i = 1; i < row; i++) {
			rows = sheet.getRow(i);
			for (int j = 0; j < column - 1; j++) {
				cell = rows.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		return data;

	}
	@DataProvider
	public Object[][] getForGotPasswordTestData() throws IOException {
		ExcelOperations excelobj = new ExcelOperations();
		int row = excelobj.getRowCount(excelForgotPassordFilepath, "Sheet1");
		int column = excelobj.getColumnCount(excelForgotPassordFilepath, "Sheet1");
		Object[][] data = new Object[row - 1][column];
		FileInputStream fis = new FileInputStream(excelForgotPassordFilepath);
		excelfile = new XSSFWorkbook(fis);
		sheet = excelfile.getSheet("Sheet1");
		System.out.println(row);
		System.out.println(column);
		for (int i = 1; i < row; i++) {
			rows = sheet.getRow(i);
			for (int j = 0; j < column; j++) {
				cell = rows.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
				System.out.println(data[i - 1][j] );
			}
		}
		return data;

	}
	
	
	
}
