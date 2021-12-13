package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormSteps {
	private WebDriver driver;

	@Given("Browser is opened")
	public void browser_is_opened() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@When("user navigates to the-internet.herokuapp URL and clicks on Form Authentication link")
	public void user_navigates_to_the_internet_herokuapp_url_and_clicks_on_form_authentication_link() {
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Form Authentication")).click();

	}

	@When("user enters the valid username {string} and password  {string} provided on the landing page")
	public void user_enters_the_valid_username_and_password_provided_on_the_landing_page(String username,
			String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

	}

	@Then("user successfully login into the Form Authentication page and validate")
	public void user_successfully_login_into_the_form_authentication_page_and_validate() {
		driver.findElement(By.xpath("//div[@id='flash']")).getText();
		Assert.assertTrue((driver.findElement(By.xpath("//div[@id='flash']")).getText())
				.contains("You logged into a secure area!"));

	}

	@Then("user logout and validate loggged out")
	public void user_logout_and_validate_loggged_out() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\'flash\']")).getText();
		Assert.assertTrue((driver.findElement(By.xpath("//*[@id=\'flash\']")).getText())
				.contains("You logged out of the secure area!"));
		driver.quit();

	}

	@Then("user unsuccessfully login into the Form Authentication page and validate")
	public void user_unsuccessfully_login_into_the_form_authentication_page_and_validate() {
		driver.findElement(By.xpath("//div[@id='flash']")).getText();
		Assert.assertTrue((driver.findElement(By.xpath("//div[@id='flash']")).getText())
				.contains("You logged into a secure area!"));
	}

	@Then("user enters an invalid invalidusername {string} and password  {string} provided on the landing page")
	public void user_enters_an_invalid_invalidusername_and_password_provided_on_the_landing_page(String invalidusername,
			String password) {
		driver.findElement(By.id("username")).sendKeys(invalidusername);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

	}

	@Then("user unsuccessfully login into the Form Authentication page and validate,due to inavid username")
	public void user_unsuccessfully_login_into_the_form_authentication_page_and_validate_due_to_inavid_username() {
		driver.findElement(By.xpath("//div[@id='flash']")).getText();
		Assert.assertTrue(
				(driver.findElement(By.xpath("//div[@id='flash']")).getText()).contains("Your username is invalid!"));
		driver.quit();
	}

	@Then("user enters the username {string} and an invalid invalidpassword  {string} provided on the landing page")
	public void user_enters_the_username_and_an_invalid_invalidpassword_provided_on_the_landing_page(String username,
			String invalidpassword) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(invalidpassword);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		driver.findElement(By.xpath("//div[@id='flash']")).getText();

	}

	@Then("user unsuccessfully login into the Form Authentication page and validate,due to inavid password")
	public void user_unsuccessfully_login_into_the_form_authentication_page_and_validate_due_to_inavid_password() {
		driver.findElement(By.xpath("//div[@id='flash']")).getText();
		Assert.assertTrue(
				(driver.findElement(By.xpath("//div[@id='flash']")).getText()).contains("Your password is invalid!"));
		driver.quit();
	}
}
