package Practice.Allerts_Frames_Tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frames {
    WebDriver driver;

    //Tук има 2 главни frame - top , bottom. В top frame се съдържат други 3 frames - left, middle, right.

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/frames");
    }

    @Test
    public void nestedFrames() {
        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftElement = driver.findElement(By.tagName("body"));
        leftElement.getText();

        driver.switchTo().parentFrame();
    }

    @Test
    public void iFrame() {
        driver.findElement(By.linkText("iFrame")).click();

        driver.switchTo().frame("mce_0_ifr");

        WebElement input = driver.findElement(By.cssSelector("#tinymce>p"));
        input.clear();
        input.sendKeys("Big party tonight. Everybody is invited !");

        driver.switchTo().defaultContent();
    }


    @AfterMethod
    public void tearDown() {
        //   driver.quit();
    }

}
