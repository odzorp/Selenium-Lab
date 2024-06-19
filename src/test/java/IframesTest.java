import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframesTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testIframeInteraction() {
        driver.get("https://practice-automation.com/iframes/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        // Switch to the iframe by index and interact with it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        WebElement iframeElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main_navbar\"]/ul/li[4]/a")));
        iframeElement.click();

        // Switch back to the main page
        driver.switchTo().defaultContent();

        // Interact with an element on the main page
        WebElement mainPageElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-1129\"]/div/p[1]/a")));
        mainPageElement.click();
    }
}
