import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModalTest {
    private WebDriver driver;
    private ModalPage modalPage;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        modalPage = new ModalPage(driver);
        modalPage.open();
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void simpleModalTest() {
        modalPage.openSimpleModal();
        modalPage.closeSimpleModal();
    }

    @Test
    public void formModalTest() {
        modalPage.openFormModal();
        modalPage.fillForm("John Doe", "john.doe@gmail.com", "Hello World");
        modalPage.submitForm();
    }
}
