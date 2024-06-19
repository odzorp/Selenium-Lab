import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormFieldTest {

  WebDriver driver;


  @Before
  public void setUp() {
    // Initialize the ChromeDriver
    driver = new ChromeDriver();
    driver.manage().window().maximize();

  }

  @After
  public void tearDown() {
    // Close and quit the browser
    driver.quit();
  }

  @Test
  public void formFieldTest() throws InterruptedException {
    goToPage();
    navigateToFormFieldPage();
    fillTextById("name", "Philip");
    Thread.sleep(5000);


    for (int i = 1; i <= 5; i++) {scrollIntoViewAndClick(By.id("drink" + i));}
    Thread.sleep(5000);

    selectColor();
    Thread.sleep(5000);

    selectSiblings();
    Thread.sleep(5000);

    fillTextById("email", "odzorp3@gmail.com");
    Thread.sleep(5000);

    fillTextById("message", "Hello World");
    Thread.sleep(5000);


    submitForm();
    Thread.sleep(5000);

    //assertConfirmationMessage();
   // scrollToTop();
  }

  private void goToPage(){
    driver.get("https://practice-automation.com/");
  }
  private void navigateToFormFieldPage() {
    driver.findElement(By.linkText("Form Fields")).click();
  }

  private void fillTextById(String id, String text) {
    WebElement element = driver.findElement(By.id(id));
    scrollIntoViewAndClick(element);
    element.sendKeys(text);
  }

  private void selectColor() {
    scrollIntoViewAndClick(By.id("color4"));
  }

  private void selectSiblings() {
    Select dropdown = new Select(driver.findElement(By.id("siblings")));
    dropdown.selectByVisibleText("Yes");
  }

  private void submitForm() throws InterruptedException {
    WebElement submitButton = driver.findElement(By.id("submit-btn"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
//Scroll down till the bottom of the page
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(5000);
    //scrollIntoViewAndClick(submitButton);
    submitButton.click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
  }

  private void assertConfirmationMessage() {
    String actualMessage = driver.switchTo().alert().getText();
    if (!actualMessage.equals("Message received!")) {
      throw new AssertionError(String.format("Expected message: '%s' but got: '%s'", "Message received!", actualMessage));
    }
    driver.switchTo().alert().accept(); // Close the alert
  }

  private void scrollToTop() {
    WebElement topButton = driver.findElement(By.id("to-top"));
    scrollIntoViewAndClick(topButton);
  }

  // Scrolls the specified element into view and clicks it
  private void scrollIntoViewAndClick(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
//Scroll down till the bottom of the page
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    element.click();
  }

  // Overloaded method to scroll into view and click for By locator
  private void scrollIntoViewAndClick(By locator) {
    WebElement element = driver.findElement(locator);
    scrollIntoViewAndClick(element);
  }
}
