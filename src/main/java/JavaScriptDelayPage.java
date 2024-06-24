import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptDelayPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By liftoffButton = By.xpath("//*[@id=\"post-36\"]/div/div[2]/div/div[1]/div[1]/div/a");
    private By startButton = By.id("start");
    private By delayMessage = By.id("delay");

    public JavaScriptDelayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    public void open() {
        driver.get("https://practice-automation.com/");
    }

    public void clickLiftoffButton() {
        WebElement button = driver.findElement(liftoffButton);
        button.click();
    }

    public void clickStartButton() {
        WebElement start = driver.findElement(startButton);
        start.click();
    }

    public void waitForLiftoff() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(delayMessage, "Liftoff!"));
    }
}
