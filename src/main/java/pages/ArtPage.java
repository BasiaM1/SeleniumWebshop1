package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ArtPage extends BasePage {

    public ArtPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-miniature")
    private List<WebElement> allArtProducts;


    public List<ProductMiniaturePage>getAllArtProducts(){
        List<ProductMiniaturePage> artProducts = new ArrayList<>();

        for(WebElement artProduct :allArtProducts){
            artProducts.add(new ProductMiniaturePage(getDriver(), artProduct));

        }
        return artProducts;
    }
    public ProductMiniaturePage getRandomArtProduct() {
        return new ProductMiniaturePage(getDriver(), getRandomElement(allArtProducts));
    }

}

