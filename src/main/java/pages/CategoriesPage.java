package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoriesPage extends BasePage{
    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css= ".category-top-menu .text-uppercase")
    private WebElement categoryHeader;


    @FindBy(css= ".total-products p")
    private WebElement numberOfProductsTxt;

    @FindBy(css= ".reviews-loaded")
    private List<WebElement> itemsInCategory;

    @FindBy(css= "#search_filters")
    private WebElement FilterBlock;

    public String getCategoryHeader() {
        wt.waitForElement(getDriver(), categoryHeader, 10);
        return categoryHeader.getText();
    }

    public String getSubCategoryHeader() {
        wt.waitForElementFluent(getDriver(), categoryHeader,2);
        return categoryHeader.getText();
    }

    public String getNumberOfProductsTxt(){
        wt.waitForElementFluent(getDriver(), numberOfProductsTxt,5);
        String[] text = numberOfProductsTxt.getText().split(" ");
        return text[2];
    }

    public String countNumbersOfProducts(){
        return Integer.toString(itemsInCategory.size());
    }

    public boolean isFilterVisible(){
        return FilterBlock.isDisplayed();
    }
}
