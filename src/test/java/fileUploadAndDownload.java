import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class fileUploadAndDownload {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void setup() {
        // Set download directory path
        String downloadFilepath = "C:\\Users\\PhilipOdzor\\IdeaProjects\\NextGenerationAutomation\\src\\test\\resources";

        // Configure ChromeOptions to set download behavior
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath);
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);

        // Initialize WebDriver with ChromeOptions
       // System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");
        driver = new ChromeDriver(options);

        // Maximize the browser window and initialize WebDriverWait
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void downloadFile() throws InterruptedException {
        driver.get("https://practice-automation.com/file-download/");

        // Locate and click the download link
        WebElement downloadLink = driver.findElement(By.xpath("//*[@id=\"post-1042\"]/div/div[1]/div/div/div/div[3]/a"));
        downloadLink.click();

        // Wait for download to complete (You might need to adjust the sleep duration)
        Thread.sleep(10000);
    }

    @Test
    public void uploadFile() {
        driver.get("https://practice-automation.com/file-upload/");

        // Locate the file input element
        WebElement uploadElement = driver.findElement(By.id("file-upload"));

        // Specify the path to the file to be uploaded
        String filePath = "C:\\Users\\PhilipOdzor\\IdeaProjects\\NextGenerationAutomation\\src\\test\\resources\\test.pdf";

        // Upload the file
        uploadElement.sendKeys(filePath);

        // Optionally, locate and click the upload button if required
        WebElement uploadButton = driver.findElement(By.id("upload-btn"));
        uploadButton.click();

        //Optionally, assert the successful upload of the file
      // WebElement confirmationMessage = driver.findElement(By.id("confirm-message"));
      // Assert.assertEquals("Thank you for your message. It has been sent.", confirmationMessage.getText());
    }
}