package utilities;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest extentTest;
	

	public static void start() {
		try {
			extent = new ExtentReports();
			spark = new ExtentSparkReporter("target/extent-reports/report.html");
			extent.attachReporter(spark);
			extentTest = extent.createTest(Test.class.getName());
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}
	}
	
	public static void pass(String msg) {
		extentTest.log(Status.PASS, msg);
	}
	
	public static void fail(String msg) {
		extentTest.log(Status.FAIL, msg);
	}
	
	public static void info(String msg) {
		extentTest.log(Status.INFO, msg);
	}
	
	public static void warning(String msg) {
		extentTest.log(Status.WARNING, msg);
	}
	
	public static void skip(String msg) {
		extentTest.log(Status.SKIP, msg);
	}
	
	public static void end() {
		try {
			extent.flush();
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}
	}
}

