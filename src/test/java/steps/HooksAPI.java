package steps;

import core.Browser;
import core.Constants;
import core.Logger;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

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
