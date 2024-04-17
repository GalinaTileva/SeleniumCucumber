package Practice.PODP.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
   // private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".error-message-container")
    private WebElement errorMessageContainer;

    @Step("Set Username")
    public void setUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    @Step("Set Password")
    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginAs(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return errorMessageContainer.getText();
    }
}
