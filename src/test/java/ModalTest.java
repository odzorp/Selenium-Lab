import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class ModalTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
      driver.get("https://practice-automation.com/modals/");
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void simpleModal() {
       WebElement simpleModal = driver.findElement( By.id("simpleModal"));
       simpleModal.click();
//        String modalText = driver.findElement(By.id("pum_popup_title_1318")).getText();
//        Assert.assertEquals("Simple Modal", modalText);
       WebElement closeModal = driver.findElement( By.xpath("//*[@id=\"popmake-1318\"]/button"));
       closeModal.click();
    }

    @Test
    public void formModal(){
        WebElement formModal = driver.findElement( By.id("formModal"));
        formModal.click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(formModal));
        WebElement name = driver.findElement( By.id("g1051-name"));
        name.sendKeys("John Doe");
        WebElement email = driver.findElement( By.id("g1051-email"));
        email.sendKeys("john.doe@gmail.com");
       WebElement message = driver.findElement( By.id("contact-form-comment-g1051-message"));
       message.sendKeys("Hello World");
        WebElement submitButton = driver.findElement( By.xpath("//*[@id=\"contact-form-1051\"]/form/p[1]/button"));
       submitButton.click();

        }
}

