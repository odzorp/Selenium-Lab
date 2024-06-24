import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.AssertJUnit.assertEquals;

public class SlidersTest {
    private WebDriver driver;
    private SliderPage sliderPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sliderPage = new SliderPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSlider() throws InterruptedException {
        sliderPage.open();
        Thread.sleep(5000);

        // Set slider value using JavaScript
        sliderPage.setSliderValueJavaScript(50);
        Thread.sleep(1000);

        // Set slider value using Actions
        sliderPage.setSliderValueActions(50);
        Thread.sleep(1000);

        // Validate the slider position
        String sliderValue = sliderPage.getSliderValue();
        System.out.println("Slider value after manipulation: " + sliderValue);
        assertEquals("54", sliderValue);
    }
}
