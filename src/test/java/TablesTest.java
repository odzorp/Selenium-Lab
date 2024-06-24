import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesTest {
    private WebDriver driver;
    private TablesPage tablesPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        tablesPage = new TablesPage(driver);
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

        // Get the table from TablesPage
        tablesPage.getTable();

        // Assertions for table rows
        Assert.assertEquals("Item", tablesPage.getTable().findElements(By.xpath(".//tr")).get(0).findElements(By.xpath(".//td")).get(0).getText());
        Assert.assertEquals("Price", tablesPage.getTable().findElements(By.xpath(".//tr")).get(0).findElements(By.xpath(".//td")).get(1).getText());

        Assert.assertEquals("Oranges", tablesPage.getTable().findElements(By.xpath(".//tr")).get(1).findElements(By.xpath(".//td")).get(0).getText());
        Assert.assertEquals("$3.99", tablesPage.getTable().findElements(By.xpath(".//tr")).get(1).findElements(By.xpath(".//td")).get(1).getText());

        Assert.assertEquals("Laptop", tablesPage.getTable().findElements(By.xpath(".//tr")).get(2).findElements(By.xpath(".//td")).get(0).getText());
        Assert.assertEquals("$1200.00", tablesPage.getTable().findElements(By.xpath(".//tr")).get(2).findElements(By.xpath(".//td")).get(1).getText());

        Assert.assertEquals("Marbles", tablesPage.getTable().findElements(By.xpath(".//tr")).get(3).findElements(By.xpath(".//td")).get(0).getText());
        Assert.assertEquals("$1.25", tablesPage.getTable().findElements(By.xpath(".//tr")).get(3).findElements(By.xpath(".//td")).get(1).getText());
    }

    @Test
    public void selectDifferentEntries() throws InterruptedException {
        driver.get("https://practice-automation.com/tables/");
        tablesPage.selectEntriesPerPage("50");
        // Add assertions or verification if necessary
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
            boolean found = tablesPage.searchAndAssertCountry(countryData[0], countryData[1], countryData[2]);
            Assert.assertTrue("Country not found: " + countryData[0], found);
            Thread.sleep(5000); // Optional wait
        }
    }
}
