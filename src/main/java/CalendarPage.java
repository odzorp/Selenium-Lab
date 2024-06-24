import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarPage {
    private WebDriver driver;
    private By dateInput = By.id("g1065-selectorenteradate");

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://practice-automation.com/calendars/");
    }

    public void setDate(String date) {
        WebElement setDate = driver.findElement(dateInput);
        setDate.click();
        setDate.sendKeys(date);
        setDate.sendKeys(Keys.ENTER);
    }
}
