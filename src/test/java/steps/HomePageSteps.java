package steps;

import core.Logger;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps {
    private HomePage homePage;
    WebDriver driver;

    @Step("Home Page is opened")
    @Given("Home Page is opened")
    public void homePageOpened() {
        Logger.getInstance().info("Home page opening");
        homePage = new HomePage();
    }

    @Step("user opens Shop by Category panel")
    @Given("user opens Shop by Category panel")
    public void openShopByCategoryPanel() {
        Logger.getInstance().info("Shop by Category panel opening");
        homePage.openShopByCategoryMenu();
    }
}
