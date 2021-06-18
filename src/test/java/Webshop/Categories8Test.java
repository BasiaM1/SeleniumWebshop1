package Webshop;

import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.CategoriesPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Categories8Test extends TestBase {

    @Test
    public void shouldCheckCategories() {
        List<WebElement> categories = homePage.getHeader().getAllCategories();
        List<WebElement> subCategories = homePage.getHeader().getAllSubCategories();
        CategoriesPage categoryPage = new CategoriesPage(driver);

        for (int i = 0; i < categories.size(); i++) {
            categories.get(i).click();
            assertThat(categories.get(i).getText(), equalTo(categoryPage.getCategoryHeader()));
            assertTrue(categoryPage.isFilterVisible());
            assertThat(categoryPage.getNumberOfProductsTxt(), equalTo(categoryPage.countNumbersOfProducts()));
        }

//        for (int i = 0; i < categories.size(); i++) {
//            for (int j = 0; j < subCategories.size(); j++) {
//                homePage.getHeader().mouseHover(categories.get(i));
//                String actualText=subCategories.get(j).getText();
//                subCategories.get(j).click();
//
//                assertThat(actualText, equalTo(categoryPage.getCategoryHeader()));
//            }
//        }
    }
}

