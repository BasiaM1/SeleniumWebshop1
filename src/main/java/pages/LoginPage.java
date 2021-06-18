package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".no-account a")
    private WebElement registerNewUserBtn;

    @FindBy(css = ".form-control[name='email']")
    private WebElement emailNameInput;

    @FindBy(css = "[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "#submit-login")
    private WebElement loginBtn;

    public RegistrationPage openRegisterNewUserPage() {
        click(registerNewUserBtn);
        return new RegistrationPage(getDriver());
    }
    public LoginPage setEmail(String email) {
        sendKeys(emailNameInput, email);
        return this;
    }

    public LoginPage setPassword(String pass) {
        sendKeys(passwordInput, pass);
        return this;
    }

    public HomePage login() {
        click(loginBtn);
        return new HomePage(getDriver());
    }

    public HomePage login(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        login();
        return new HomePage(getDriver());
    }
}
