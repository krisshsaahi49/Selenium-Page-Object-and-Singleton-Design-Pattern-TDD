package utilities.interactions;

import org.openqa.selenium.WebElement;

public interface Interactions {

	void click(WebElement element);
	
	void doubleclick(WebElement element);
	
	void navigate(String url);
	
	void sendkeys(WebElement element, String message);
	
	void scroll(WebElement element);
	
	void Wait(WebElement element);
	
	void verify(String expected, String actual);

}
