package pages.portfolio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Base;
import utilities.interactions.Interactions;
import utilities.interactions.InteractionsUIImpl;

public class Homepage {

	Interactions interactions;

	@FindBy(tagName = "h1")
	public WebElement Homepage_Hero;

	@FindBy(xpath = "//a[contains(text(),'Hire Me')]")
	public WebElement Homepage_HireMe;
	
	@FindBy(css = "input#email")
	public WebElement Homepage_email;
	
	@FindBy(css = "input#subject")
	public WebElement Homepage_subject;
	
	@FindBy(css = "textarea#message")
	public WebElement Homepage_message;
	
	@FindBy(css = "button[type*=submit]")
	public WebElement Homepage_sendmessage;
	
	@FindBy(xpath = "//p[contains(text(),'Email sent successfully!')]")
	public WebElement Homepage_confirmationmsg;
	public void hireme() {
		interactions.click(Homepage_HireMe);
	}
	
	public void launch(String url) {
		interactions.navigate(url);
		interactions.verify(Base.getDriver().getCurrentUrl(), url);
	}

	public void sendemail(String email, String subject, String message ) {
		interactions.Wait(Homepage_email);
		interactions.scroll(Homepage_email);
		interactions.sendkeys(Homepage_email, email);
		interactions.sendkeys(Homepage_subject, subject);
		interactions.sendkeys(Homepage_message, message);
		interactions.click(Homepage_sendmessage);
		interactions.verify(Homepage_confirmationmsg.getText().toString(), "Email sent successfully!");
		
	}
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		interactions = new InteractionsUIImpl();
	}
}
