package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='id_gender'][value='1']")
    private WebElement maleRbt;

    @FindBy(css = "[name='id_gender'][value='2']")
    private WebElement femaleRbt;

    @FindBy(css = "[name='firstname']")
    private WebElement firstNameInput;

    @FindBy(css = "[name='lastname']")
    private WebElement lastNameInput;

    @FindBy(css = ".form-control[name='email']")
    private WebElement emailNameInput;

    @FindBy(css = "[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "[name='customer_privacy']")
    private WebElement customerPrivacyChbx;

    @FindBy(css = "[name='psgdpr']")
    private WebElement gdprChbx;

    @FindBy(css = ".form-control-submit")
    private WebElement registerBtn;

    public void registerUser(User user) {
        sendKeys(firstNameInput, user.getFistName());
        sendKeys(lastNameInput, user.getLastName());
        sendKeys(passwordInput, user.getPassword());
        sendKeys(emailNameInput, user.getEmail());

        if (user.getGender() == User.Gender.Male) {
            click(maleRbt);
        } else {
            click(femaleRbt);
        }

        click(gdprChbx);
        click(customerPrivacyChbx);
        click(registerBtn);
    }
}