package steps;

import core.Browser;
import core.Constants;
import core.Logger;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;
    private static Logger logger = Logger.getInstance();
    private String scenarioName;

    @Before
    public void beforeTest(Scenario scenario) {
        driver = Browser.getDriver();
        driver.get(Constants.BASE_STORE_URL);
        scenarioName = scenario.getName();
        logger.logTestName(scenarioName);
    }

    @After
    public void afterTest() {
        Class<? extends Hooks> currentClass = this.getClass();

        boolean testPassed = true;
        if (currentClass.isAnnotationPresent(Test.class)) {
            Test testAnnotation = (Test) currentClass.getAnnotation(Test.class);
            if (testAnnotation != null && testAnnotation.expected() != Test.None.class) {
                testPassed = false;
            }
        }
        logger.logTestEnd(scenarioName, testPassed);
    }

    @AfterAll
    public static void afterAllScenarios() {
        driver.quit();
    }
}
