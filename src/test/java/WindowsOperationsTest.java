import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;

public class WindowsOperationsTest {
    private WebDriver driver;
    private WindowOperationsPage windowOperationsPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        windowOperationsPage = new WindowOperationsPage(driver);
        windowOperationsPage.goToPage();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void handleNewTab() {
        windowOperationsPage.clickNewTabButton();

        ArrayList<String> tabs = windowOperationsPage.getWindowHandles();
        driver.switchTo().window(tabs.get(1));

        String currentUrl = windowOperationsPage.getCurrentUrl();
        String expectedUrl = "https://automatenow.io/";
        Assert.assertEquals(expectedUrl, currentUrl);

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void replaceCurrentWindow() {
        windowOperationsPage.clickReplaceWindowButton();

        String currentUrl = windowOperationsPage.getCurrentUrl();
        String expectedUrl = "https://automatenow.io/";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Test
    public void handleNewWindow() {
        windowOperationsPage.clickNewWindowButton();

        ArrayList<String> windows = windowOperationsPage.getWindowHandles();
        driver.switchTo().window(windows.get(1));

        String currentUrl = windowOperationsPage.getCurrentUrl();
        String expectedUrl = "https://automatenow.io/";
        Assert.assertEquals(expectedUrl, currentUrl);

        driver.close();
        driver.switchTo().window(windows.get(0));
    }
}
