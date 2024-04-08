package Practice.JobsBg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); -
        // общ метод с wait until visibility, not visibility по локатори - да се преизползва за разл. случаи

    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.jobs.bg/");
    }
    
    @AfterMethod
    public void tearDown() {
      //  driver.quit();
    }

}
