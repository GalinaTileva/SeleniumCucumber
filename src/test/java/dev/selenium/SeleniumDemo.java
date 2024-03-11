package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SeleniumDemo {

    WebDriver driver;

    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

    }

    @Test
    public void testOpenBrowser() {

        //  driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        //  driver.close();  //затваря текущ таб
        //  driver.quit();   //затваря всички табс, целия браузър



        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text-id"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        driver.navigate().refresh();
        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }



}
