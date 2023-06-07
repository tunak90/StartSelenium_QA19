import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest {

    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void testCss() {
        WebElement germany = wd.findElement(By.cssSelector("#customers tr:nth-child(7) td:last-child"));
        String text = germany.getText();
        System.out.println(text);
        Assert.assertEquals(text, "Germany");


        List<WebElement> rows = wd.findElements(By.cssSelector("#customers tr"));
        System.out.println(rows.size());

        List<WebElement> columns = wd.findElements(By.cssSelector("#customers th"));
        System.out.println(columns.size());

        wd.findElement(By.cssSelector("#customers tr:nth-child(3)"));
        wd.findElement(By.cssSelector("#customers th:last-child"));
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}
