package Practice.PODP.POM.tests;

import Practice.PODP.POM.base.MainTest;
import Practice.PODP.POM.pages.LoginPage;
import Practice.PODP.POM.pages.ProductsPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends MainTest {
   // private WebDriver driver;


    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");

        // loginPage.clickLoginButton();
        ProductsPage productsPage = loginPage.clickLoginButton();
       // Thread.sleep(3000);
         productsPage.getPageTitle();

       // assertEquals(productsPage.getPageTitle(), "Products");

    }

}
