package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".logo.img-responsive")
    private WebElement logo;

    @FindBy(css="#category-3")
    private WebElement clothesLnk;

    @FindBy(css="#category-6")
    private WebElement accessoriesLnk;

    @FindBy(css="#category-9")
    private WebElement artLnk;

    @FindBy(css="input[name='s']")
    private WebElement search;

    @FindBy(css = "#top-menu >.category")
    private List<WebElement> allCategories;

    @FindBy(css = ".dropdown-submenu")
    private List<WebElement> allSubCategories;

    public List getAllCategories() {
        return allCategories;
    }

    public List getAllSubCategories() {
        return allSubCategories;
    }

  public WebElement getClothesLnk(){
        return clothesLnk;
  }
    public ArtPage openArtPage() {
        click(artLnk);
        return new ArtPage(getDriver());
    }
}

