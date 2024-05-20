package utilities.interactions;

import org.openqa.selenium.WebElement;

public interface Interactions {

	void click(WebElement element);
	
	void doubleclick(WebElement element);
	
	void navigate(String url);

}
