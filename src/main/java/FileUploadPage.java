import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage {
    private WebDriver driver;
    private By fileInput = By.id("file-upload");
    private By uploadButton = By.id("upload-btn");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://practice-automation.com/file-upload/");
    }

    public void uploadFile(String filePath) {
        WebElement input = driver.findElement(fileInput);
        input.sendKeys(filePath);

        WebElement button = driver.findElement(uploadButton);
        button.click();
    }

    // Optionally, add a method to verify the upload
    public String getConfirmationMessage() {
        WebElement confirmationMessage = driver.findElement(By.id("confirm-message"));
        return confirmationMessage.getText();
    }
}
