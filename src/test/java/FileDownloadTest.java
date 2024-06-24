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

public class FileDownloadTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private FileDownloadPage fileDownloadPage;

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
        driver = new ChromeDriver(options);

        // Maximize the browser window and initialize WebDriverWait
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize the FileDownloadPage object
        fileDownloadPage = new FileDownloadPage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void downloadFile() throws InterruptedException {
        fileDownloadPage.open();
        fileDownloadPage.downloadFile();

        // Wait for download to complete (You might need to adjust the sleep duration)
        Thread.sleep(10000);
    }
}
