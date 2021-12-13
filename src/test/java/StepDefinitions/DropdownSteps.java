package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSteps {
	private WebDriver driver;

	@Given("Browser is lauched")
	public void browser_is_lauched() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@When("user navigates to the-internet.herokuapp URL and clicks on Dropdown link")
	public void user_navigates_to_the_internet_herokuapp_url_and_clicks_on_dropdown_link() {
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();
	}

	@Then("user selects option from the dropdown and validate selected option")
	public void user_selects_option_from_the_dropdown_and_validate_selected_option() {

		WebElement Dropdown = driver.findElement(By.id("dropdown"));
		Select select = new Select(Dropdown);
		select.selectByVisibleText("Option 2");
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		System.out.println("selected element =" + firstSelectedOption.getText());
		Assert.assertEquals("Option 2", firstSelectedOption.getText());
		driver.quit();

	}

}
