package biz.sviatoslav.wt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        driver = Browser.getDriver();
        driver.get(Constants.BASE_URL);
    }

    @AfterEach
    public void afterEach() {
        Browser.quitDriver();
    }
}
