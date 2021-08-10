package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilites.BaseClass;

public class Listeners  extends BaseClass implements ITestListener
{
	ExtentTest test;
	ExtentReports et=generateReports();

	@Override
	public void onTestStart(ITestResult result) {
		test=et.createTest(result.getMethod().getMethodName());
		/*
		 * System.out.println("Test"); System.out.println(test.getStatus());
		 */
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		logs.info(result.getMethod().getMethodName()+" is Passed");
		
		/*
		 * try { //Below Statement return Driver object from the test which is failed
		 * driver=(WebDriver)
		 * result.getTestClass().getRealClass().getField("driver").get(result.
		 * getInstance()); } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * String testCaseName= result.getMethod().getMethodName(); try {
		 * test.addScreenCaptureFromPath(takeScreenShot(driver, testCaseName)); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			//Below Statement return Driver object from the test which is failed
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String testCaseName= result.getMethod().getMethodName();
		try {
			test.addScreenCaptureFromPath(takeScreenShot(driver, testCaseName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logs.error(result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		et.flush();
	}
	
}