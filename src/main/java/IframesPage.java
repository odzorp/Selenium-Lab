import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By iframeNavigationLink = By.xpath("//*[@id=\"main_navbar\"]/ul/li[4]/a");
    private By mainPageLink = By.xpath("//*[@id=\"post-1129\"]/div/p[1]/a");

    public IframesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://practice-automation.com/iframes/");
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    public void switchToIframe(int index) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    public void clickIframeLink() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(iframeNavigationLink));
        element.click();
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }

    public void clickMainPageLink() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(mainPageLink));
        element.click();
    }
}
