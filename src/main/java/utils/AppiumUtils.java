package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;


public class AppiumUtils {
	
	
	
	//THE BELOW METHODS ARE COMMON FOR BOTH IOS AND ANDROID
	
	public void additionOfTwoNumbers(int a, int b) {
		int c = a+b;
		System.out.println(c);
	}
	
	public void waitForElementToBeDisplayed(AppiumDriver driver, WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditons)
		wait.until(ExpectedConditions.visibilityOf(we));
		
	}
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws Exception {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Users\\User\\Downloads\\DRAFT_F-W\\DRAFT_F-W\\Screenshots\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
	
}
