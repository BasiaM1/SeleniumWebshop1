package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void sendKeys(WebElement element, String text) {
        System.out.println("Sending text: " + text);
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        System.out.println("Clicking on element " + element.getText());
        element.click();
    }
}
