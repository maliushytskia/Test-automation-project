package steps;

import core.Logger;
import io.cucumber.java.*;

public class HooksAPI {
    private static Logger logger = Logger.getInstance();
    private String scenarioName;

    @Before("@api")
    public void beforeTest(Scenario scenario) {
        scenarioName = scenario.getName();
        logger.logTestName(scenarioName);
    }

    @After("@api")
    public void afterTest(Scenario scenario) {
        boolean testPassed = true;

        if (scenario.getStatus() == Status.FAILED) {
            testPassed = false;
        }
        logger.logTestEnd(scenarioName, testPassed);
    }
}
