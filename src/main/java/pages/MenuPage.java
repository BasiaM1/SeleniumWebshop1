package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    Logger logger = LoggerFactory.getLogger("MenuPage.class");

    @FindBy(css = ".user-info a.hidden-sm-down")
    private WebElement signOutBtn;

    @FindBy(css = ".user-info span.hidden-sm-down")
    private WebElement signInBtn;

    @FindBy(css = ".account")
    private WebElement userName;

    @FindBy(id = "contact-link")
    private WebElement contactLnk;

    public LoginPage openLoginPage() {
        click(signInBtn);
        return new LoginPage(getDriver());
    }

    public ContactPage openContactPage() {
        click(contactLnk);
        return new ContactPage(getDriver());
    }
    public String getUserName() {
        String name;
        try {
            name = userName.getText();
            logger.debug("Account name: " + name);
            return name;
        } catch (Exception e) {
            logger.error("Account name failed:" + e.getMessage());
            return null;
        }

    }
}