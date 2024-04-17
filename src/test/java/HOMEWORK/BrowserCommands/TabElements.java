package HOMEWORK.BrowserCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TabElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }


    @Test
    public void editDoeJason() {
        WebElement doe = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[3]/td[1]"));
        WebElement edit = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[3]/td[6]/a[1]"));
        edit.click();

    }

    @Test
    public void positionBachFrank() {
        WebElement frank = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[1]"));
        String position = frank.getText();
    }



    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

}
