package Practice.PODP.POM_Unvalid_Login;

import Practice.PODP.POM.pages.LoginPage;
import org.testng.annotations.Test;

public class Testing extends Driver {

    @Test
    public void errorLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername("error_user");
        loginPage.setPassword("secret_sauce");

    }

}
