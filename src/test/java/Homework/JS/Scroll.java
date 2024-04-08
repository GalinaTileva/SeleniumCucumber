package Homework.JS;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Scroll {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void scrollDown() {

        WebElement user = driver.findElement(By.cssSelector("#user-name"));
        WebElement pass = driver.findElement(By.cssSelector("#password"));
        WebElement log = driver.findElement(By.cssSelector("#login-button"));

        user.sendKeys("standard_user");
        pass.sendKeys("secret_sauce");
        log.click();

        String page = driver.getCurrentUrl();
        assertEquals(page, "https://www.saucedemo.com/inventory.html");

        WebDriver.Window window = driver.manage().window();
        driver.manage().window().setSize(new Dimension(620, 980));

        WebElement footer = driver.findElement(By.cssSelector(".footer"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", footer);


    }


    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
