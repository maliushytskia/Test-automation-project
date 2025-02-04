package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    public WebDriver driver;
    private static Logger logger = Logger.getInstance();

    @BeforeEach
    public void beforeEach() {
        Class currentClass = this.getClass();
        driver = Browser.getDriver();
        driver.get(Constants.BASE_URL);
        logger.logTestName(currentClass.getName());
    }

    @AfterEach
    public void afterEach(TestInfo testInfo) {
        Class currentClass = this.getClass();
        boolean testPassed = !testInfo.getTags().contains("FAILED");
        Browser.quitDriver();
        logger.logTestEnd(currentClass.getName(), testPassed);
    }
}
