import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By alertButton = By.xpath("//*[@id=\"alert\"]/b");
    private By confirmButton = By.xpath("//*[@id=\"confirm\"]/b");
    private By promptButton = By.xpath("//*[@id=\"prompt\"]");

    public PopUpsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://practice-automation.com/popups/");
    }

    public void triggerAlertPopUp() {
        WebElement alert = driver.findElement(alertButton);
        alert.click();
    }

    public void triggerConfirmPopUp() {
        WebElement confirm = driver.findElement(confirmButton);
        confirm.click();
    }

    public void triggerPromptPopUp() {
        WebElement prompt = driver.findElement(promptButton);
        prompt.click();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void sendKeysToPrompt(String input) {
        driver.switchTo().alert().sendKeys(input);
    }

    public String getPromptInputValue() {
        Alert alert = driver.switchTo().alert();
        String inputText = alert.getText();
        alert.accept();
        return inputText;

    }
}
