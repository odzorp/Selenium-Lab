import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;


public class PopUps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Initialize the ChromeDriver. Make sure to set the correct path to your chromedriver executable.
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void PopUpsTest () throws InterruptedException {
//    openPage();
//   AlertPopUp();
//   Thread.sleep(3000);
//    confirmPopUp();
//        Thread.sleep(3000);
//
//        promptPopUp();

    }

    public void openPage(){
        driver.get("https://practice-automation.com/popups/");
    }
@Test
    public void AlertPopUp(){
    driver.get("https://practice-automation.com/popups/");

    WebElement alert =  driver.findElement(By.xpath("//*[@id=\"alert\"]/b"));
      alert.click();
      String alertText = driver.switchTo().alert().getText();
      assertEquals("Hi there, pal!", alertText);

    }
@Test
    public void confirmPopUp(){
    driver.get("https://practice-automation.com/popups/");

    WebElement confirm =  driver.findElement(By.xpath("//*[@id=\"confirm\"]/b"));
        confirm.click();
        String confirmText = driver.switchTo().alert().getText();
        assertEquals("OK or Cancel, which will it be?", confirmText);
        driver.switchTo().alert().accept();

    }
@Test
    public void promptPopUp(){
    driver.get("https://practice-automation.com/popups/");

    WebElement prompt =  driver.findElement(By.xpath("//*[@id=\"prompt\"]"));
        prompt.click();
        String promptText = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Test Input");
        driver.switchTo().alert().accept();

    }
}

