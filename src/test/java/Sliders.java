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

import static org.testng.AssertJUnit.assertEquals;


public class Slider {
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
    public void sliderTest() {
    driver.get("https://practice-automation.com/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement sliders = driver.findElement(By.xpath("//*[@id=\"post-36\"]/div/div[2]/div/div[1]/div[2]/div/a"));

    sliders.click();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // WebElement slider = driver.findElement(By.id("slideMe"));
  //  slider.click();

}
}


