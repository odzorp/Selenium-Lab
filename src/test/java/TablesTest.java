import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class TablesTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void tableAssertion() {
        driver.get("https://practice-automation.com/tables/");

        // Locate the table
        WebElement table = driver.findElement(By.xpath("//table"));

        // Get all rows from the table
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Assert the first row contains the headers
        Assert.assertEquals("Item", rows.get(0).findElements(By.xpath(".//td")).get(0).getText());
        Assert.assertEquals("Price", rows.get(0).findElements(By.xpath(".//td")).get(1).getText());

        // Assert the second row contains the item 'Oranges' and price '$3.99'
        Assert.assertEquals("Oranges", rows.get(1).findElements(By.xpath(".//td")).get(0).getText());
        Assert.assertEquals("$3.99", rows.get(1).findElements(By.xpath(".//td")).get(1).getText());

        // Assert the third row contains the item 'Laptop' and price '$1200.00'
        Assert.assertEquals("Laptop", rows.get(2).findElements(By.xpath(".//td")).get(0).getText());
        Assert.assertEquals("$1200.00", rows.get(2).findElements(By.xpath(".//td")).get(1).getText());

        // Assert the fourth row contains the item 'Marbles' and price '$1.25'
        Assert.assertEquals("Marbles", rows.get(3).findElements(By.xpath(".//td")).get(0).getText());
        Assert.assertEquals("$1.25", rows.get(3).findElements(By.xpath(".//td")).get(1).getText());
    }

    @Test
    public void selectDifferentEntries() throws InterruptedException {
        driver.get("https://practice-automation.com/tables/");

        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.name("tablepress-1_length"));

        // Create a Select instance
        Select dropdown = new Select(dropdownElement);

        // Get the list of options
        List<WebElement> options = dropdown.getOptions();

        // Iterate through the options and select each one with a 5-second interval
        for (WebElement option : options) {
            // Select the option
            dropdown.selectByVisibleText(option.getText());

            // Print the currently selected option to the console (optional)
            System.out.println("Selected: " + option.getText());

            // Wait for 5 seconds before selecting the next entry
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        }
    }

    @Test
    public void searchAndAssertCountries() throws InterruptedException {
        driver.get("https://practice-automation.com/tables/");

        String[][] countriesToCheck = {
                {"Brazil", "7", "216.4"},
                {"South Africa", "25", "59.3"},
                {"Thailand", "20", "69.8"}
        };

        for (String[] countryData : countriesToCheck) {
            WebElement searchBox = driver.findElement(By.cssSelector("input[aria-controls='tablepress-1']"));
            searchBox.clear();
            searchBox.sendKeys(countryData[0]);

            WebElement table = driver.findElement(By.id("tablepress-1"));
            List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

            boolean found = false;
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.xpath(".//td"));
                String country = cells.get(1).getText();
                String rank = cells.get(0).getText();
                String population = cells.get(2).getText();

                if (country.equals(countryData[0])) {
                    Assert.assertEquals(countryData[1], rank);
                    Assert.assertEquals(countryData[2], population);
                    found = true;
                    break;
                }
            }

            Assert.assertTrue("Country not found: " + countryData[0], found);

            // Wait for 5 seconds (optional)
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        }
    }
}
