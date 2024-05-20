package pages.portfolio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.interactions.Interactions;
import utilities.interactions.InteractionsUIImpl;

public class Homepage {

	Interactions interactions;

	@FindBy(tagName = "h1")
	public WebElement Homepage_Hero;

	@FindBy(xpath = "//a[contains(text(),'Hire Me')]")
	public WebElement Homepage_HireMe;
	
	public void hireme() {
		interactions.click(Homepage_HireMe);
	}
	
	public void launch(String url) {
		interactions.navigate(url);
	}

	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		interactions = new InteractionsUIImpl();
	}
}
