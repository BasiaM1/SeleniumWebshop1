package Webshop;

import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProductDetailsPage;
import pages.ProductMiniaturePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class ProductView13Test extends TestBase {


    @Test
    public void shouldAddRandomProduct() throws InterruptedException {
        ProductMiniaturePage miniatureArtProd = homePage.getHeader()
                .openArtPage()
                .getAllArtProducts()
                .get(0);

        String expectedName = miniatureArtProd.getName();
        String expectedPrice = miniatureArtProd.getPrice();

        ProductDetailsPage productQuickView = miniatureArtProd.mouseHoverProduct()
                .openQuickView();


        assertThat(productQuickView.getPrice(), equalTo(expectedPrice));
        assertThat(productQuickView.getName(), equalTo(expectedName));

        String previousPrice = expectedPrice;
        productQuickView.selectDimension();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(c -> !(miniatureArtProd.getPrice()).equals(productQuickView.getPrice()));
        String newPrice = productQuickView.getPrice();
        assertThat(newPrice, greaterThan(previousPrice));

        productQuickView.setQuantityAndAddToCart();
        String expectedText = "Product successfully added to your shopping cart";
        assertThat(productQuickView.getProductLabel(), equalTo(expectedText));
    }
}
