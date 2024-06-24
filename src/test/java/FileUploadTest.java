import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class FileUploadTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private FileUploadPage fileUploadPage;

    @Before
    public void setup() {
        // Configure ChromeOptions to set download behavior
        ChromeOptions options = new ChromeOptions();

        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);

        // Maximize the browser window and initialize WebDriverWait
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize the FileUploadPage object
        fileUploadPage = new FileUploadPage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void uploadFile() {
        fileUploadPage.open();
        String filePath = "C:\\Users\\PhilipOdzor\\IdeaProjects\\NextGenerationAutomation\\src\\test\\resources\\test.pdf";
        fileUploadPage.uploadFile(filePath);

        // Optionally, assert the successful upload of the file
        // String confirmationMessage = fileUploadPage.getConfirmationMessage();
        // Assert.assertEquals("Thank you for your message. It has been sent.", confirmationMessage);
    }
}
