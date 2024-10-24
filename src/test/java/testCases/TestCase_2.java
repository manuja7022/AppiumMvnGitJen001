//package testCases;
//
//import java.io.FileInputStream;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.google.common.collect.ImmutableMap;
//
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.Activity;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;
//import pageObjects_Android.FormPage;
//import pageObjects_Android.ProductCatelogue;
//import testUtils.BaseTest;
//
//public class TestCase_2  extends BaseTest{
//	
//
//	@AfterMethod(alwaysRun=true)
//	public void reSetup() throws Throwable {
//		tearDown();
//		ConfigureAppium();
//	}
//	
//	@Test(dataProvider = "getData")
//	public void FillForm(HashMap<String,String> map) throws Throwable {
//		
//		System.out.println(map);
//		System.out.println("-----"+map.get("Name")+"-----"+map.get("Gender")+"-----"+map.get("Country"));
//	
//		formPage.setNameField(map.get("Name"));
//		formPage.setGender(map.get("Gender"));
//		formPage.setCountrySelection(map.get("Country"));
//		formPage.submitForm();
//		 
//		productCatelogue.addItemToCartByIndex(0);
//		productCatelogue.addItemToCartByIndex(0);
//		productCatelogue.goToCartPage();
//		
//		cartPage.getProductSum();
//		cartPage.getTotalAmountDisplayed();
//		cartPage.acceptTermsConditions();
//		cartPage.submitOrder();
//		
//	}
//	
//	@DataProvider
//	public Object[][] getData() throws Exception {
//		String path = prop.getProperty("testDataPath");
//		String sheetName = "FormData";
//		
//		HashMap<String,String> map;
//		Object[][] obj = new Object[3][1];
//		
//		FileInputStream fis = new FileInputStream(path);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheet(sheetName);
//		XSSFRow row = null;
//		XSSFCell cell = null;
//		int rowCount = sheet.getLastRowNum()+1;
//		int colCount = sheet.getRow(0).getLastCellNum();
//		
//		for(int i=1;i<rowCount;i++)
//		{
//			map = new HashMap<String,String>();
//			for(int j=0;j<colCount;j++) {
//				String key = sheet.getRow(0).getCell(j).getStringCellValue();
//				String value = sheet.getRow(i).getCell(j).toString();
//				map.put(key, value);
//			}
//			obj[i-1][0] = map;
//		}
//		
//		return obj;
//	}
//
//
//	
//	
//	
//}
