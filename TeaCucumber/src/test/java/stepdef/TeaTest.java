package stepdef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaTest {

	private static WebDriver driver;
	private static String URL = "http://www.practiceselenium.com/welcome.html";
	
	@Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://www.practiceselenium.com/welcome.html");
    }
	
	@After
    public void tearDown() {
        driver.close();
    }
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.get(URL);
		assertEquals("Welcome", driver.getTitle());
		System.out.println("I can access tea website");
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		WebElement menu = driver.findElement(By.linkText("Menu"));
		menu.click();
		assertEquals("Menu", driver.getTitle());
		System.out.println("I can access tea menu");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		WebElement greenTea = driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000453230000 strong"));
		WebElement redTea = driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000453231072 strong"));
		WebElement oolongTea = driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000453231735 strong"));
		assertEquals("Green Tea", greenTea.getText());
		assertEquals("Red Tea", redTea.getText());
		assertEquals("Oolong Tea", oolongTea.getText());
		System.out.println("I can list all items");
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		WebElement menu = driver.findElement(By.linkText("Menu"));
		menu.click();
		WebElement checkOut = driver.findElement(By.cssSelector("#wsb-button-00000000-0000-0000-0000-000451955160 > .button-content"));
		checkOut.click();
		assertEquals("Check Out", driver.getTitle());
		System.out.println("I can access tea check out");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		assertEquals("Check Out", driver.getTitle());
		System.out.println("I can access tea check out");
	}
	
}
