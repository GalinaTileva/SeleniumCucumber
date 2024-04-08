package Practice.Commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables#edit");
    }


    @Test
    public void click() {
        WebElement frank = driver.findElement
                (By.xpath("//table[@id='table1']//td[contains(text(), 'Frank')]/../td/a[contains(text(), 'edit')]"));
        frank.click();
    }


    @AfterMethod
    public void tearDown() {
        //   driver.quit();
    }

}
