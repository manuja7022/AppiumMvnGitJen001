package utils;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils {
	
	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		//super(driver);
		this.driver = driver;	
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"duration",2000));
	}
	
	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
						"direction", direction,
						"percent", 0.25));
	}
	public void RotatingToLandscape() throws Exception {
		// search for android mobile gestures in internet
		Activity activity = new Activity("u0 io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", 
				ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		
		DeviceRotation mobileRotate = new DeviceRotation(0, 0, 90);
		driver.rotate(mobileRotate);
	}
	
	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	
	public void scrollToEndAction() {
		// search for android mobile gestures in internet
	}
	
	public void HideKeyboard() {
		driver.hideKeyboard();
	}

}
