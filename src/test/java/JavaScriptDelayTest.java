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

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLiftoff() {
        driver.get("https://practice-automation.com/");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"post-36\"]/div/div[2]/div/div[1]/div[1]/div/a"));
        button.click();
        WebElement start = driver.findElement(By.id("start"));
        start.click();
       // wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("delay"), "Liftoff!"));

    }
}
