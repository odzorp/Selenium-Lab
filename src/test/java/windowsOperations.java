import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;


public class windowsOperations {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://practice-automation.com/window-operations/");

    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void handleNewTab() throws InterruptedException {
        driver.get("https://practice-automation.com/window-operations/");

        // Locate and click the "New Tab" button
        WebElement newTabButton = driver.findElement(By.xpath("//*[@id=\"post-1147\"]/div/p[3]/button"));
        newTabButton.click();

        // Handle new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(tabs.get(1));

        // Optionally, perform actions or assertions in the new tab
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automatenow.io/";
         Assert.assertEquals(expectedUrl, currentUrl);

        // Close the new tab and switch back to the original tab
        driver.close();
       driver.switchTo().window(tabs.get(0));
    }



    @Test
    public void replaceCurrentWindow() {
        driver.get("https://practice-automation.com/window-operations/");

        // Locate and click the "Replace Window" button
        WebElement replaceWindowButton = driver.findElement(By.xpath("//*[@id=\"post-1147\"]/div/p[5]/button"));
        replaceWindowButton.click();

      //  URL assertion
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automatenow.io/";
        Assert.assertEquals(expectedUrl, currentUrl);

    }


    @Test
    public void handleNewWindow() throws InterruptedException {
        driver.get("https://practice-automation.com/window-operations/");

        // Locate and click the "New Window" button
        WebElement newWindowButton = driver.findElement(By.xpath("//*[@id=\"post-1147\"]/div/p[7]/button"));
        newWindowButton.click();

        // Handle new window
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        // Optionally, perform actions or assertions in the new window
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automatenow.io/";
        Assert.assertEquals(expectedUrl, currentUrl);
        
        // Close the new window and switch back to the original window
        driver.close();
        driver.switchTo().window(windows.get(0));
    }




}
