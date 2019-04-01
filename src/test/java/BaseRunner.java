import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class BaseRunner {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/lina/selenium drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/lina/selenium drivers/geckodriver");
        driver = BrowsersFactory.chrome.create();

        baseUrl = "https://www.tinkoff.ru/mobile-operator/tariffs/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After

    public void tearDown() {
        driver.quit();
    }

}
