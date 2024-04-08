package Practice.JobsBg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Login extends BasePage {

    @FindBy(id = "register-menu-surface")
    private WebElement accountReg;

    @FindBy
    private WebElement user;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "agree")
    private WebElement agreeTerms;


    public Login(WebDriver driver) {
        super(driver);
    }



}
