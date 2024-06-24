import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class TablesPage {
    private WebDriver driver;

    public TablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTable() {
        return driver.findElement(By.xpath("//table"));
    }

    public void selectEntriesPerPage(String optionText) throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.name("tablepress-1_length"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
        Thread.sleep(5000);
    }

    public boolean searchAndAssertCountry(String countryName, String expectedRank, String expectedPopulation) {
        WebElement searchBox = driver.findElement(By.cssSelector("input[aria-controls='tablepress-1']"));
        searchBox.clear();
        searchBox.sendKeys(countryName);

        WebElement table = driver.findElement(By.id("tablepress-1"));
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//td"));
            String country = cells.get(1).getText();

            if (country.equals(countryName)) {
                String rank = cells.get(0).getText();
                String population = cells.get(2).getText();
                if (rank.equals(expectedRank) && population.equals(expectedPopulation)) {
                    return true;
                }
            }
        }

        return false;
    }
}
