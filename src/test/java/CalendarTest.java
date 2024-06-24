import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private CalendarPage calendarPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        calendarPage = new CalendarPage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void calenderTest() {
        calendarPage.open();
        calendarPage.setDate("10/10/2020");
    }
}
