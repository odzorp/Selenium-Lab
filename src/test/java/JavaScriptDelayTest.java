import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptDelayTest {
    private WebDriver driver;
    private JavaScriptDelayPage javaScriptDelayPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        javaScriptDelayPage = new JavaScriptDelayPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLiftoff() {
        javaScriptDelayPage.open();
        javaScriptDelayPage.clickLiftoffButton();
        javaScriptDelayPage.clickStartButton();
       // javaScriptDelayPage.waitForLiftoff();
    }
}
