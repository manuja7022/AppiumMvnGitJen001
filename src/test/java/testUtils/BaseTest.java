package testUtils;


import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects_Android.CartPage;
import pageObjects_Android.FormPage;
import pageObjects_Android.ProductCatelogue;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	public ProductCatelogue productCatelogue;
	public CartPage cartPage;
	public Properties prop;
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws Throwable {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Downloads\\DRAFT_F-W\\DRAFT_F-W\\src\\main\\java\\config\\globalData.properties");
		prop.load(fis);
		
		File file = new File(prop.getProperty("mainJSPath"));
		service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress(prop.getProperty("ipAddress")).usingPort(Integer.parseInt(prop.getProperty("portNumber"))).build();
		service.start();
		 String userName = "manug_EgH7LT";
	        String accessKey = "xwfrmTX9arqMxFtaiptB";
		
		UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("bs://c0a1f39d24c7bc0a521660839dc4c9166d12b141");
		options.setDeviceName(prop.getProperty("deviceName"));
		options.setChromedriverExecutable(prop.getProperty("chromeDriverPath"));
		options.setApp(prop.getProperty("apkFilePath"));
		driver = new AndroidDriver(new URI(prop.getProperty("androidDriverURI")).toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		formPage = new FormPage(driver);
		productCatelogue = new ProductCatelogue(driver);
		cartPage = new CartPage(driver);
		
		
		
		
	}
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
