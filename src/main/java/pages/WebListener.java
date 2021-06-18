package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger("WebListener.class");

    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info(">>>>>>>>>>>>>>>>>>>Before click: Clicking on element: " + element.getText()+"<<<<<<<<<<<");
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info(">>>>>>>>>>>>>>>>>>>After click: Clicking on element: "+"<<<<<<<<<<<");

    }
    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info(">>>>>>>>>>>>>>>>>>>Before navigate: Navigate to page: " + url +"<<<<<<<<<<<");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info(">>>>>>>>>>>>>>>>>>>After navigate: Navigate to page: " + url +"<<<<<<<<<<<");
    }
}
