import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class WindowOperationsPage {
    private WebDriver driver;

    public WindowOperationsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("https://practice-automation.com/window-operations/");
    }

    public void clickNewTabButton() {
        WebElement newTabButton = driver.findElement(By.xpath("//*[@id=\"post-1147\"]/div/p[3]/button"));
        newTabButton.click();
    }

    public void clickReplaceWindowButton() {
        WebElement replaceWindowButton = driver.findElement(By.xpath("//*[@id=\"post-1147\"]/div/p[5]/button"));
        replaceWindowButton.click();
    }

    public void clickNewWindowButton() {
        WebElement newWindowButton = driver.findElement(By.xpath("//*[@id=\"post-1147\"]/div/p[7]/button"));
        newWindowButton.click();
    }

    public ArrayList<String> getWindowHandles() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public void closeCurrentWindow() {
        driver.close();
    }
}
