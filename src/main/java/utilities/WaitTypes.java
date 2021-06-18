package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitTypes {
    private WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger("WaitTypes.class");

    public WaitTypes(WebDriver driver) {
        this.driver = driver;
    }

    public WaitTypes() {
    }

    public WebElement waitForElement(WebDriver driver, WebElement element, int timeout) {
        try {
            System.out.println("Waiting for max: " + timeout + " seconds for element to be available");

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(
                    ExpectedConditions.visibilityOf(element));
            logger.debug("Element appeared on the web page");
        } catch (Exception e) {
            logger.debug("Element not appeared on the web page");
        }
        return element;
    }

    @SuppressWarnings("deprecation")
    public WebElement waitForElementFluent(WebDriver driver, WebElement element, int timeout, int timePool) {
        try {
            logger.debug("Waiting for max: " + timeout + " seconds for element to be available");

            WebDriverWait wait = (WebDriverWait) new FluentWait(driver)
                    .pollingEvery(timePool, SECONDS)
                    .withTimeout(timeout, SECONDS)
                    .ignoring(NoSuchElementException.class);

            element = wait.until(
                    ExpectedConditions.visibilityOf(element));
            logger.debug("Element appeared on the web page");
        } catch (Exception e) {
            logger.debug("Element not appeared on the web page");
        }
        return element;
    }

    public WebElement getReadyClickBtn(WebDriver driver, WebElement element, int timeout) {

        try {
            logger.debug("Waiting for max: " + timeout + " seconds for element to be available");

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(
                    ExpectedConditions.elementToBeClickable(element));
            logger.debug("Element clicked on the web page");
        } catch (Exception e) {
            logger.debug("Element not clicked on the web page");
        }
        return element;
    }

    public void pageAvailable(WebDriver driver, int timeout, String url) {
        try {
            logger.debug("Waiting for max: " + timeout + " seconds for page to be available");

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.urlToBe(url));
            logger.debug("page is available");
        } catch (Exception e) {
            logger.debug("page is not available");
        }
    }
}