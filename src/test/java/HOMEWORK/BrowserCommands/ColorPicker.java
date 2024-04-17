package HOMEWORK.BrowserCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ColorPicker {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void pickColor() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement colorPicker = driver.findElement(By.cssSelector("[name='my-colors']"));

        Actions moveSlider = new Actions(driver);
        moveSlider.clickAndHold(colorPicker).moveByOffset(-40,20).perform();

    }


    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

}
