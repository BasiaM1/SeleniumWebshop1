package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    public class MenuPage extends BasePage {
        public MenuPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(css = ".user-info a.hidden-sm-down")
        private WebElement signOutBtn;

        @FindBy(css = ".user-info span.hidden-sm-down")
        private WebElement signInBtn;

        @FindBy(css = ".account")
        private WebElement userName;

        public LoginPage openLoginPage() {
            click(signInBtn);
            return new LoginPage(getDriver());
        }

        public String getUserName() {
            return userName.getText();
        }
    }