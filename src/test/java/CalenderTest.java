import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CalenderTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void calenderTest() throws InterruptedException {
        driver.get("https://practice-automation.com/calendars/");
        WebElement setDate = driver.findElement(By.id("g1065-selectorenteradate"));
                setDate
                        .click();
        setDate
                .sendKeys("10/10/2020");
        setDate
                .sendKeys(Keys.ENTER);

    }
}