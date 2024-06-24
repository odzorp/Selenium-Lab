import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class FormFieldPage {
  private WebDriver driver;

  private By nameField = By.id("name");
  private By emailField = By.id("email");
  private By messageField = By.id("message");
  private By submitButton = By.id("submit-btn");
  private By colorOption = By.id("color4");
  private By siblingsDropdown = By.id("siblings");

  public FormFieldPage(WebDriver driver) {
    this.driver = driver;
  }

  public void open() {
    driver.get("https://practice-automation.com/");
  }

  public void navigateToFormFieldPage() {
    driver.findElement(By.linkText("Form Fields")).click();
  }

  public void fillName(String name) {
    fillTextById(nameField, name);
  }

  public void fillEmail(String email) {
    fillTextById(emailField, email);
  }

  public void fillMessage(String message) {
    fillTextById(messageField, message);
  }

  public void selectDrink(int drinkNumber) {
    scrollIntoViewAndClick(By.id("drink" + drinkNumber));
  }

  public void selectColor() {
    scrollIntoViewAndClick(colorOption);
  }

  public void selectSiblings(String option) {
    Select dropdown = new Select(driver.findElement(siblingsDropdown));
    dropdown.selectByVisibleText(option);
  }

  public void submitForm() {
    WebElement button = driver.findElement(submitButton);
    scrollIntoViewAndClick(button);
    Alert alert = driver.switchTo().alert();
    alert.accept();
  }

  private void fillTextById(By locator, String text) {
    WebElement element = driver.findElement(locator);
    scrollIntoViewAndClick(element);
    element.sendKeys(text);
  }

  private void scrollIntoViewAndClick(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    element.click();
  }

  private void scrollIntoViewAndClick(By locator) {
    WebElement element = driver.findElement(locator);
    scrollIntoViewAndClick(element);
  }
}
