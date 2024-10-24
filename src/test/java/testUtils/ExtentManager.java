package testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	static ExtentReports extent;
	
	public static ExtentReports getExtentReportObject() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("PRACTICE EXT3NT REPORT");
		reporter.config().setDocumentTitle("TEST RESULTS");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Engineer", "Manuja");
		
		return extent;
		
	}

}
