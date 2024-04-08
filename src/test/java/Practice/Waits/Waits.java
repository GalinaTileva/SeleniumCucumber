package Practice.Waits;

/*
 Явни и неявни изчаквания -implicit, explicit waits. Implicit се ползва само веднъж глобално за всички тестове.
 4-5sec след стартиране на драйвър/браузър да се сложи.
 Explicit работи в определено условие/ тест метод.Ползва се за специфично изчакване на нещо.
 Препоръка - проверка за наличие на елемент, не за отсъствие.
*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Waits {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    // EXPLICIT WAIT
    @Test
    public void pagination() {
        driver.get("https://pagination.js.org/");
        WebElement demo1 = driver.findElement(By.id("demo1"));
        List<WebElement> items = demo1.findElements(By.cssSelector(".data-container ul li"));
        List<WebElement> pagination = demo1.findElements(By.cssSelector(".paginationjs-pages ul li"));

        pagination.get(2).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.stalenessOf(items.get(0)));

        items = demo1.findElements(By.cssSelector(".data-container ul li"));
        assertEquals("11", items.get(0).getText());
        //assertTrue(items.get(0).getText().equals("11"));

    }


    @Test
    public void loading() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("#finish>h4")));

        //By xpath "//div[@id='start']/button))"   за start
        //By xpath "//div[@id='finish']/h4"       за finish

        String text = helloWorldText.getText();
        assertEquals(text, "Hello World!");

    }


    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }

}
