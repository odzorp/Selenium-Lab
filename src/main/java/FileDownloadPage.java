import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDownloadPage {
    private WebDriver driver;
    private By downloadLink = By.xpath("//*[@id=\"post-1042\"]/div/div[1]/div/div/div/div[3]/a");

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://practice-automation.com/file-download/");
    }

    public void downloadFile() {
        WebElement link = driver.findElement(downloadLink);
        link.click();
    }
}
