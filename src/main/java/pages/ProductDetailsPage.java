package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".row .h1")
    private WebElement name;

    @FindBy(css = ".current-price")
    private WebElement price;

    @FindBy(css = "#group_3")
    WebElement dimensionSelect;

    @FindBy(css = "#quantity_wanted")
    WebElement quantity;

    @FindBy(css = ".add-to-cart")
    WebElement addToCartBtn;

    @FindBy(css = "#myModalLabel")
    WebElement productAddedLabel;

    public String getName() {
        wt.waitForElement(getDriver(), name, 15);
        return name.getText();
    }

    public String getPrice() {
        wt.waitForElement(getDriver(), price, 10);
        return price.getText();
    }

    public String getProductLabel() {
        wt.waitForElement(getDriver(), productAddedLabel, 10);
        return (productAddedLabel.getText()).substring(1);
    }

    public void selectDimension() {
        selectElement(dimensionSelect, "21");
    }

    public void setQuantityAndAddToCart() {
        sendKeys(quantity, "5");
        click(addToCartBtn);
    }

    public Product toProduct() {
        return new Product(getName(), getPrice());
    }

}