package HOMEWORK.BrowserCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void upload() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement fileInput = driver.findElement(By.cssSelector("[name='my-file']"));

        String filePath = "C:\\Users\\HP\\IdeaProjects\\SeleniumDemo\\src\\test\\java\\Homework\\Resource\\message.txt";
        //oт папка Resources

        fileInput.sendKeys(new File(filePath).getAbsolutePath());
    }


    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

}
