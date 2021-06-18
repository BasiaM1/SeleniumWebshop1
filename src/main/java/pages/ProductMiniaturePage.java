package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductMiniaturePage extends BasePage{
    public ProductMiniaturePage(WebDriver driver, WebElement productMiniature) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
    }
    Logger logger = LoggerFactory.getLogger("ProductMiniaturePage");
    @FindBy(css = "a.quick-view")
    private WebElement productQuickView;


    @FindBy(css = ".product-title")
    private WebElement name;

    @FindBy(css = "span.price")
    private WebElement price;

    public String getName() {
        return name.getText();
    }

    public String getPrice() {
        return price.getText();
    }

//    public BigDecimal getPrice(){
//        return new BigDecimal(price.getText());
//    }

    public ProductDetailsPage open() {
        click(name);
        return new ProductDetailsPage(getDriver());
    }

    public ProductMiniaturePage mouseHoverProduct() {
        logger.info("Mouse hover on product view");
        mouseHover(name);
        return this;
    }
    public ProductDetailsPage openQuickView() {
        click(productQuickView);
        return new ProductDetailsPage(getDriver());
    }

    public Product toProduct() {
        return new Product(getName(), getPrice());
    }
}