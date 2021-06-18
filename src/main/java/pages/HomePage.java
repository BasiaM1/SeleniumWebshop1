package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        menuPage = new MenuPage(driver); //menuPage dorzucone jest tu jako pole tek klasy HomePage
        headerPage = new HeaderPage(driver);
    }

    private final MenuPage menuPage;
    private final HeaderPage headerPage;

    public MenuPage getMenu() {
        return menuPage;
    }

    public HeaderPage getHeader() {
        return headerPage;
    }

    @FindBy(css = ".product-miniature")
    private List<WebElement> allProducts;

    public List<ProductMiniaturePage> getAllProducts() {
        List<ProductMiniaturePage> products = new ArrayList<>();

        for (WebElement product : allProducts) {
            products.add(new ProductMiniaturePage(getDriver(), product));
        }
        return products;
    }

    public ProductMiniaturePage getRandomProduct() {
        return new ProductMiniaturePage(getDriver(), getRandomElement(allProducts));
    }
}