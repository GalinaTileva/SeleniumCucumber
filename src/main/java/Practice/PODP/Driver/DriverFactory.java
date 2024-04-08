package Practice.PODP.Driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Map;

public class DriverFactory {

    //този клас отговаря само за инициализация и настройки на драйвъра, също и пренасянето му.
    // suite.xml задава настройка за нишково изпълнение на тестовете

    // складиране на инстанции(драйвъри) на опр. място (подобно на списък) в паметта поотделно, като нишки
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        //взима се текущия драйвър (който е необходим) и така драйвърите не си пречат
        return tlDriver.get();
    }

    public static void setChromeDriver(int wait) {
        // za dimension
        Map<String, String> mobileEmulation = Map.of("deviceName", "Nexus 5");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");

        // za alerts - zadavame 1 povedenie za vsichki alerts
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

        tlDriver.set(driver);

    }

    public static void setFirefoxDriver(int wait) {
        FirefoxOptions options = new FirefoxOptions();

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

        tlDriver.set(driver);
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

}
