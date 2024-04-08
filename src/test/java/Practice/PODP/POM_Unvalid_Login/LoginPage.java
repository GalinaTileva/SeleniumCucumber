package Practice.PODP.POM_Unvalid_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {
    WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage (WebDriver driver) {
        super(driver);
    }


    public void setUsername (String username) {
        usernameInput.sendKeys(username);
    }

    public void setPassword (String password) {
        passwordInput.sendKeys(password);
    }



}
