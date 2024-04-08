package Practice.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class DynamicControls {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void removeTest(){
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='checkbox']/input"));
        checkBox.click(); // cssSelector "#checkbox-example>button"
        WebElement remove = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        remove.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement itsGone = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='message']")));

        String text = itsGone.getText();
        assertEquals(text, "It's gone!");
    }


    @AfterMethod
    public void tearDown() {
      //  driver.quit();
    }

}
