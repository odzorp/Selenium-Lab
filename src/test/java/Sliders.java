import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;


public class Sliders {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
public void setUp()  {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}

@After
    public void tearDown() {
    driver.quit();
}

@Test
    public void sliderTest() throws InterruptedException {
    driver.get("https://practice-automation.com/slider/");
    Thread.sleep(5000);

    WebElement slider = driver.findElement(By.id("slideMe"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].value = '50'", slider);

    // You can also use the following code to set the value of the slider
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 50, 0).perform();


    // Additional code for validating the slider position
    String sliderValue = ((JavascriptExecutor) driver).executeScript("return arguments[0].value", slider).toString();
    System.out.println("Slider value after manipulation: " + sliderValue);

}
}


