package Webshop;

import TestBase.TestBase;
import models.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.ProductDetailsPage;
import pages.ProductMiniaturePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class ProductTest extends TestBase {

    @Test
    public void shouldVerifyRandomProduct() {

        ProductMiniaturePage miniaturePage = homePage.getRandomProduct();

        String expectedName = miniaturePage.getName();
        String expectedPrice = miniaturePage.getPrice();

        ProductDetailsPage productDetailsPage = miniaturePage.open();

        assertThat(productDetailsPage.getName(), equalTo(expectedName));
        assertThat(productDetailsPage.getPrice(), equalTo(expectedPrice));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @Test
    public void shouldRandomProductAlternative() {
        ProductMiniaturePage miniaturePage = homePage.getRandomProduct();

        Product expectedProduct = miniaturePage.toProduct();

        Product actualProduct = miniaturePage.open()
                                             .toProduct();

        assertThat(actualProduct, samePropertyValuesAs(expectedProduct));
    }
}