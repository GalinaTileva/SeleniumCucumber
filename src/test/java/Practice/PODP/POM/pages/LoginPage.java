package Practice.PODP.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
   // private WebDriver driver;

    @FindBy(id = "user-name")          //или private By userName = By.id("user-name"); така няма нужда от конструктор.
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    // конструктор: // винаги еднакво с името на класа
    public LoginPage (WebDriver driver) {

        /*this.driver = driver;
        PageFactory.initElements(driver, this);*/

        super(driver);
    }



    public void setUsername (String username) {
        usernameInput.sendKeys(username);
    }

    public void setPassword (String password) {
        passwordInput.sendKeys(password);
    }

    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(driver);
    }


    public void loginAs(String username, String secretSauce) {
        setUsername(username);
        setPassword(secretSauce);
        clickLoginButton();
    }
}
