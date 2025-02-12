package steps.runners;

import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/features"
//        , glue = {"steps", "core"},
//        plugin = {
//                "pretty",
//                "json:target/cucumber-report/cucumber.json",
//                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"
//        },
//        monochrome = true
//)
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        dryRun = false, monochrome = true
)
public class TestRunner {
}
