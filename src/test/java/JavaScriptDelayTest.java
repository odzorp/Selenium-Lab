import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptDelayTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Initialize the ChromeDriver. Make sure to set the correct path to your chromedriver executable.
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        // Close the browser after test
        driver.quit();
    }

    @Test
    public void testLiftoff() {
        // Navigate to the page where the test will be performed
        driver.get("https://your-test-page-url.com");

        // Click the button to start the action. Replace By.id("buttonId") with the actual locator of your button.
        WebElement button = driver.findElement(By.id("buttonId"));
        button.click();

        // Wait for the text "Liftoff!" to appear in the element where the text is expected to be displayed.
        // Replace By.xpath("//div") with the correct locator that points to the element expected to contain "Liftoff!"
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(@class,'message')]"), "Liftoff!"));

        // Additional Assertions can be performed here to verify the success of the operation
    }
}
