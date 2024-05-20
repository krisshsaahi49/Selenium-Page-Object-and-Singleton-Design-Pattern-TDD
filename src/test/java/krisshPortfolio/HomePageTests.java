package krisshPortfolio;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.portfolio.Homepage;
import utilities.Base;

public class HomePageTests {
	
	public String PORTFOLIO = "https://krisshsaahi.dev";
	Homepage homepage;

	@BeforeTest
	public void init() {
		Base.start();
		homepage = new Homepage(Base.getDriver());
	}
	
	@Test(groups = {"regression"})
	public void test1() throws InterruptedException {
		homepage.launch(PORTFOLIO);
		homepage.hireme();
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void teardown() {
		Base.end();
	}
}
