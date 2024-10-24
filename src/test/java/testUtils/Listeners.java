package testUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import utils.AppiumUtils;

public class Listeners extends AppiumUtils implements ITestListener {
	
	AppiumDriver driver;
	ExtentTest logger;
	ExtentReports extent = ExtentManager.getExtentReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		logger = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.pass("Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		logger.fail(result.getThrowable());
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		catch(Exception e) {
			
		}
		try {
			logger.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
		}
		catch(Exception e) {
			
		}
	}
	
	@Override
	public void onFinish(ITestContext result) {
		extent.flush();
	}

}
