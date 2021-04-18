package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import pageObjects.LoginPage;

public class Steps {

	public WebDriver driver; // declare Webdriver
	// Create LoginPage object so that we can access LoginPage methods
	public LoginPage lp;

	@Given("^User Launch Chrome browser$")
	public void user_launch_chrome_browser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");

		// Initiate driver
		driver = new ChromeDriver();
		// Instantiate LoginPage object and pass the driver as parameter
		driver.manage().window().maximize();
		lp = new LoginPage(driver);

	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String Email, String Password) {
		lp.setusername(Email);
		lp.setPassword(Password);
	}

	@When("^Click on Login$")
	public void click_on_Login() throws Throwable {
		lp.clickbtnLogin();
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("^User Click on Logout link$")
	public void user_Click_on_Logout_link() throws Throwable {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}
}
