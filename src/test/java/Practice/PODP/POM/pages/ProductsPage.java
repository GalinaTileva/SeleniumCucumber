package Practice.PODP.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    //private WebDriver driver;

    @FindBy(className = "title")
    private WebElement pageTitle;

    public ProductsPage (WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void addProduct() {
        item.click();
    }

    public void openShoppingCart() {
        waitForElementToBeVisible(shoppingCartBadge);
        shoppingCartBadge.click();
    }

    public HeaderComponent header() {
        return new HeaderComponent(driver);
    }

}
