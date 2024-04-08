package Practice.Allerts_Frames_Tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Windows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void tabs() {
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement header = driver.findElement(By.cssSelector(".example"));
        String headerText = header.getText();

        driver.close();
        driver.switchTo().window(tabs.get(0));

    }

    @AfterMethod
    public void tearDown() {
     //   driver.quit();
    }

}
