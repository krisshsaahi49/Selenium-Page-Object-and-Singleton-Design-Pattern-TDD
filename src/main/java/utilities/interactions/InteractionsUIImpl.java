package utilities.interactions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Base;
import utilities.ExtentReport;
import utilities.Logs;

public class InteractionsUIImpl implements Interactions {

	WebDriverWait wait;

	Actions actions;

	JavascriptExecutor jsexec;

	public InteractionsUIImpl() {
		if (Base.getDriver() == null) {
			throw new IllegalArgumentException("Driver must be set");
		}
		this.actions = new Actions(Base.getDriver());
		this.jsexec = (JavascriptExecutor) Base.getDriver();
	}

	@Override
	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}
	}

	@Override
	public void doubleclick(WebElement element) {
		try {
			actions.doubleClick(element).build().perform();
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}
	}

	@Override
	public void navigate(String url) {
		try {
			Base.getDriver().navigate().to(url);
			Logs.debug("Launched " + url + " successfully");
			ExtentReport.info("Launched url successfully : "+url);
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}
	}

	@Override
	public void sendkeys(WebElement element, String messsage) {
		try {
			element.sendKeys(messsage);
			Logs.debug(" " + messsage + " is sent successfully");
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}

	}

	@Override
	public void scroll(WebElement element) {
		try {
			jsexec.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}
	}

	@Override
	public void Wait(WebElement element) {
		try {
			wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}

	}

	@Override
	public void verify(String expected, String actual) {
		try {
			Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());
			ExtentReport.pass("Expeced: "+expected+" matches Actual: "+actual);
		} catch (Exception e) {
			Logs.error(e.getMessage());
			;
		}
	}

}
