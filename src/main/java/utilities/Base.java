package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends Logs {

	private static WebDriver driver;
	static String browser = "GC";

	private Base() {

	}

	// return driver instance
	public static WebDriver getDriver() {
		return driver;
	}

	public static void start() {
		try {
			ExtentReport.start();
			if (driver == null) {
				switch (browser) {
				case "GC":
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--headless");
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(options);
					break;
				case "SF":
					WebDriverManager.safaridriver().setup();
					driver = new SafariDriver();
					break;
				default:
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				}
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			Logs.debug("Driver initialised successfully");
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}
	}

	public static void end() {
		try {
			if (driver != null) {
				driver.quit();
				driver = null;
				Logs.debug("Driver closed successfully");
				ExtentReport.end();
			}
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}
	}
}
