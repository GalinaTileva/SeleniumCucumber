package Practice.Commands;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsSelectDemo {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
    }

    @Test
    public void sliderTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement slider = driver.findElement(By.cssSelector(".form-range"));
        Actions moveSlider = new Actions(driver);
        moveSlider.clickAndHold(slider).moveByOffset(40, 0).perform();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = driver.findElement(By.cssSelector("#column-a"));
        WebElement target = driver.findElement(By.cssSelector("#column-b"));
        Actions drag = new Actions(driver);

        Thread.sleep(2000);

        drag.clickAndHold(source).moveToElement(target).release().perform();
    }

    @Test
    public void keyPresses() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement input = driver.findElement(By.cssSelector("#target"));
        input.sendKeys(Keys.ESCAPE);

        WebElement message = driver.findElement(By.cssSelector("#result"));
        String result = message.getText();
        Assert.assertEquals(result, "You entered: ESCAPE");


        //Assert.assertEquals(message.txt.getText(),"You entered: ESCAPE");

    }


    @Test
    public void dropDown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement select = driver.findElement(By.cssSelector("#dropdown"));

        Select dropDown = new Select(select);
        dropDown.selectByVisibleText("Option 1");
        //или:
        dropDown.selectByValue("2");
    }

    @Test
    public void webformDropDown() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement select = driver.findElement(By.cssSelector(".form-select"));

        Select dropDown = new Select(select);
        dropDown.selectByValue("1");
        dropDown.selectByValue("2");
        //или
        dropDown.selectByVisibleText("Three");

    }

    @Test
    public void tableExtraction() {
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> emails = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr/td[3]"));
        for (WebElement email : emails) {
            System.out.println(email.getText());
        }

    }


    @AfterMethod
    public void after() {
       // driver.quit();
    }

}
