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

public class HooksUI {
    public static WebDriver driver;
    private static Logger logger = Logger.getInstance();
    private String scenarioName;

    @Before("@ui")
    public void beforeTest(Scenario scenario) {
        driver = Browser.getDriver();
        driver.get(Constants.BASE_STORE_URL);
        scenarioName = scenario.getName();
        logger.logTestName(scenarioName);
    }

    @After("@ui")
    public void afterTest(Scenario scenario) {
        boolean testPassed = true;

        if (scenario.getStatus() == Status.FAILED) {
            testPassed = false;
            makeScreenshot(scenario);
        }
        logger.logTestEnd(scenarioName, testPassed);
    }

    @AfterAll
    public static void afterAllScenarios() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void makeScreenshot(Scenario scenario) {
        logger.info("Test failed, capturing screenshot...");
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "png", "screenshot");

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = String.format("./src/test/java/artifacts/%s_screenshot_%s.png", scenario.getName(), timestamp);

        try {
            logger.info("Saving screenshot to: " + filePath);
            Files.createDirectories(Paths.get("./src/test/java/artifacts"));
            Files.write(Paths.get(filePath), screenshot);
        } catch (IOException e) {
            logger.error("Error saving screenshot: " + e.getMessage());
        }
    }
}
