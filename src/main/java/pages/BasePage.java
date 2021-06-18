package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.WaitTypes;

import java.util.List;
import java.util.Random;

public class BasePage {
    private WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger("BasePage.class");
    private EventFiringMouse eventFiringMouse;
    protected WebListener weblistener;
    public WaitTypes wt;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wt = new WaitTypes(driver);
        PageFactory.initElements(driver, this);

    }


    public WebDriver getDriver() {
        return driver;
    }

    public void sendKeys(WebElement element, String text) {
        wt.waitForElement(driver, element, 15);
        logger.debug("Sending text: " + text);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        wt.getReadyClickBtn(driver, element, 15);
        logger.debug("CLicking button: " + element.getText());
        element.click();
    }

    public void selectElement(WebElement element, String selectText) {
        logger.debug("Selecting " + selectText);
        new Select(element).selectByVisibleText(selectText);
    }

    public void selectRandomEl(WebElement element) {
        WebElement randomOption = getRandomElement(new Select(element).getOptions());
        selectElement(element, randomOption.getText());
    }

    public void mouseHover(WebElement element) {
        logger.debug("mouseHover perform on the object: " + element.getText());
        eventFiringMouse = new EventFiringMouse(driver, weblistener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }
}