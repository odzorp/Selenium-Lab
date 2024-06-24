import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormFieldTest {
    private WebDriver driver;
    private FormFieldPage formFieldPage;

    @Before
    public void setUp() {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        formFieldPage = new FormFieldPage(driver);
    }

    @After
    public void tearDown() {
        // Close and quit the browser
        driver.quit();
    }

    @Test
    public void formFieldTest() throws InterruptedException {
        formFieldPage.open();
        formFieldPage.navigateToFormFieldPage();
        formFieldPage.fillName("Philip");
        Thread.sleep(5000);

        for (int i = 1; i <= 5; i++) {
            formFieldPage.selectDrink(i);
        }
        Thread.sleep(5000);

        formFieldPage.selectColor();
        Thread.sleep(5000);

        formFieldPage.selectSiblings("Yes");
        Thread.sleep(5000);

        formFieldPage.fillEmail("odzorp3@gmail.com");
        Thread.sleep(5000);

        formFieldPage.fillMessage("Hello World");
        Thread.sleep(5000);

        formFieldPage.submitForm();
        Thread.sleep(5000);

        // Optionally, assert the successful submission of the form
        // String confirmationMessage = formFieldPage.getConfirmationMessage();
        // Assert.assertEquals("Message received!", confirmationMessage);
    }
}
