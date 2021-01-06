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

public class FTSESearch {

	private static WebDriver driver;
	private static String URL = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100";
	
	@Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        driver.findElement(By.cssSelector("#acceptCookie")).click();
    }
	
	@After
    public void tearDown() {
        driver.close();
    }
	
	@Given("^I can open FTSE site$")
	public void i_can_open_FTSE_site() {
		driver.get(URL);
		assertEquals("FTSE 100 Market overview | Hargreaves Lansdown", driver.getTitle());
		System.out.println("Accessed FTSE Site");
	}

	@When("^I find the riser$")
	public void i_find_the_riser() {
        WebElement risers = driver.findElement(By.cssSelector(".one-line:nth-child(2) strong"));
        risers.click();
        WebElement highest = driver.findElement(By.cssSelector("#ls-row-STAN-L > td:nth-child(1)"));
        String highText = highest.getText();
        assertEquals(highText, highest.getText());
	}

	@Then("^I find the faller$")
	public void i_find_the_faller() {
        WebElement fallers = driver.findElement(By.cssSelector(".one-line:nth-child(3) > .link-headline"));
        fallers.click();
        WebElement lowest = driver.findElement(By.cssSelector("#ls-row-AVV-L > td:nth-child(1)"));
        String lowText = lowest.getText();
        assertEquals(lowText, lowest.getText());
	}
	
}
