import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By simpleModalButton = By.id("simpleModal");
    private By closeModalButton = By.xpath("//*[@id=\"popmake-1318\"]/button");
    private By formModalButton = By.id("formModal");
    private By nameField = By.id("g1051-name");
    private By emailField = By.id("g1051-email");
    private By messageField = By.id("contact-form-comment-g1051-message");
    private By submitButton = By.xpath("//*[@id=\"contact-form-1051\"]/form/p[1]/button");

    public ModalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://practice-automation.com/modals/");
    }

    public void openSimpleModal() {
        WebElement button = driver.findElement(simpleModalButton);
        button.click();
    }

    public void closeSimpleModal() {
        WebElement button = driver.findElement(closeModalButton);
        button.click();
    }

    public void openFormModal() {
        WebElement button = driver.findElement(formModalButton);
        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
    }

    public void fillForm(String name, String email, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(messageField).sendKeys(message);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
}
