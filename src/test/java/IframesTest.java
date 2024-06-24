import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframesTest {
    private WebDriver driver;
    private IframesPage iframesPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        iframesPage = new IframesPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testIframeInteraction() {
        iframesPage.open();
        iframesPage.scrollToBottom();
        iframesPage.switchToIframe(1);
        iframesPage.clickIframeLink();
        iframesPage.switchToMainPage();
        iframesPage.clickMainPageLink();
    }
}
