
package utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentDemo {
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;

	@BeforeTest
	public void starttest() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/extent-reports/Spark.html");
		extent.attachReporter(spark);
		test = extent.createTest(getClass().getName());
	}

	@Test
	public void test1() {
		test.log(Status.PASS, "test 1");
	}
	
	@Test
	public void test2() {
		test.log(Status.FAIL, "test 2");
	}
	
	@Test
	public void test3() {
		test.log(Status.PASS, "test 3");
	}

	@AfterTest
	public void endtest() {
		extent.flush();
	}
}