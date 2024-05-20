package utilities.interactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.Base;
import utilities.Logs;

public class InteractionsUIImpl implements Interactions {
	
	Actions actions = new Actions(Base.getDriver());

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
			Logs.debug("Launched "+url+" successfully");
		} catch (Exception e) {
			Logs.error(e.getMessage());
		}
	}

}
