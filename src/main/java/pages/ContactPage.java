package pages;

import models.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='submitMessage']")
    private WebElement sendBtn;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement alertMsg;


    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement successMsg;

    @FindBy(css = "select[name='id_contact']")
    private WebElement subjectSelect;

    @FindBy(name = "from")
    private WebElement emailInput;

    @FindBy(css="[name='fileUpload']")
    private WebElement filePathInput;

    @FindBy(css="[name='message']")
    private WebElement messageBox;

    public ContactPage clickSend () {
       click(sendBtn);
       return this;
    }

    public String getAlertMessage() {
        wt.waitForElement(getDriver(), alertMsg, 15);
        return alertMsg.getText();
    }
    public String getSuccessMessage() {
        wt.waitForElement(getDriver(), successMsg, 15);
        return successMsg.getText();
    }
    public void fillContactForm(Contact contact) throws InterruptedException {
        selectRandomEl(subjectSelect);
        sendKeys(emailInput, contact.getEmail());
        sendKeys(filePathInput, contact.getFilePath().getAbsolutePath());
        sendKeys(messageBox, contact.getMessage());
        click(sendBtn);
    }
}
