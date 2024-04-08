package Practice.PODP.POM.tests;

import Practice.PODP.POM.base.MainTest;
import Practice.PODP.POM.pages.LoginPage;
import Practice.PODP.POM.pages.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTest extends MainTest {

    ProductsPage productsPage;

    @BeforeMethod
    public void loginBefore() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

    }

    @Test
    public void canOpenCartPage() {
        productsPage = new ProductsPage(driver);
        productsPage.header().openCartByIcon();

    }


}
