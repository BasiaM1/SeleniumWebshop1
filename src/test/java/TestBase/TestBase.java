package TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        // take this from yml/property file
        driver.get("http://146.59.32.4/"); //tu definiujemy strone,
        // bo wszystkie testy beda korzystaly z tej strony
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterEach
    public void cleanUp(){
        driver.quit();
    }
}