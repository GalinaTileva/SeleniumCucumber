package Practice.Allerts_Frames_Tabs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Alerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }


    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]")).click();

        //driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals("You successfully clicked an alert", result.getText());

    }


    @Test
    public void dismissAlert() {
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals("You clicked: Cancel", result.getText());

    }



    @Test
    public void inputText(){
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Green Alien");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals("You entered: Green Alien", result.getText());

    }


    @AfterMethod
    public void tearDown() {
     //   driver.quit();
    }

}
