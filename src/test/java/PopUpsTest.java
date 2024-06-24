import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

public class PopUpsTest {
    private WebDriver driver;
    private PopUpsPage popUpsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        popUpsPage = new PopUpsPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAlertPopUp() {
        popUpsPage.open();
        popUpsPage.triggerAlertPopUp();
        String alertText = popUpsPage.getAlertText();
        AssertJUnit.assertEquals("Hi there, pal!", alertText);
        popUpsPage.acceptAlert();
    }

    @Test
    public void testConfirmPopUp() {
        popUpsPage.open();
        popUpsPage.triggerConfirmPopUp();
        String confirmText = popUpsPage.getAlertText();
        AssertJUnit.assertEquals("OK or Cancel, which will it be?", confirmText);
        popUpsPage.acceptAlert();
    }

    @Test

    public void testPromptPopUp() {
        String expectedName = "Wonders";
        popUpsPage.open();
        popUpsPage.triggerPromptPopUp();
        popUpsPage.sendKeysToPrompt(expectedName);
       // String promptInputValue = popUpsPage.getPromptInputValue();
      //  AssertJUnit.assertEquals(expectedName, promptInputValue);
        popUpsPage.acceptAlert();
    }
}
