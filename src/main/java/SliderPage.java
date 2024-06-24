import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SliderPage {
    private WebDriver driver;
    private By slider = By.id("slideMe");

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://practice-automation.com/slider/");
    }

    public void setSliderValueJavaScript(int value) {
        WebElement sliderElement = driver.findElement(slider);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", sliderElement);
    }

    public void setSliderValueActions(int xOffset) {
        WebElement sliderElement = driver.findElement(slider);
        Actions move = new Actions(driver);
        move.dragAndDropBy(sliderElement, xOffset, 50).perform();
    }

    public String getSliderValue() {
        WebElement sliderElement = driver.findElement(slider);
        return ((JavascriptExecutor) driver).executeScript("return arguments[0].value", sliderElement).toString();
    }
}
