package HOMEWORK.JS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Click {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }


    @Test
    public void clickLogin() {

        WebElement user = driver.findElement(By.cssSelector("#username"));
        WebElement pass = driver.findElement(By.cssSelector("#password"));
        WebElement login = driver.findElement(By.cssSelector(".radius"));

        user.sendKeys("tomsmith");
        pass.sendKeys("SuperSecretPassword!");

      //  var element = document.getElementByClass("radius");
      //  element.click();

    }




    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

}
