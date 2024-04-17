package Practice.PODP.POM.tests;

import Practice.PODP.POM.base.MainTest;
import Practice.PODP.POM.pages.LoginPage;
import Practice.PODP.POM.pages.ProductsPage;
import Practice.PODP.utils.CsvReader;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import com.opencsv.exceptions.CsvException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import java.io.IOException;



    public class LoginTest extends MainTest {
        private LoginPage loginPage;
        private ProductsPage productsPage;

        @DataProvider(name = "login-data")
        public static Object[][] dataProviderHardcodedData() {
            return new Object[][]{
                    {"standard_user", "secret_sauce"},
                    {"performance_glitch_user", "secret_sauce"},
                    {"visual_user", "secret_sauce"}
            };
        }

        @DataProvider(name = "login-data-file")
        public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
            return CsvReader.readCsvFile("src/test/resources/login-data.csv");
        }

        @Epic("Authentification")
        @Feature("Login")
        @Story("Successful Login")
        @Severity(SeverityLevel.CRITICAL)

        @Test(dataProvider = "login-data-file")
        public void testSuccessfulLogin(String username, String password) {
            loginPage = new LoginPage();
            loginPage.setUsername(username);
            loginPage.setPassword(password);
            loginPage.clickLoginButton();
            productsPage = new ProductsPage();

            Assert.assertEquals(productsPage.getPageTitle(), "Products");
        }


        @Test
        public void testNegativeWithEmptyCredentials() {
            SoftAssert soft = new SoftAssert();
            loginPage = new LoginPage();

            loginPage.setUsername("");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

            soft.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");

            soft.assertAll();

        }



    }
