package steps;

import core.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps {
    private HomePage homePage;

    @Given("Home Page is opened")
    public void homePageOpened() {
        Logger.getInstance().info("Home page opening");
        homePage = new HomePage();
    }

    @Given("user opens Shop by Category panel")
    public void openShopByCategoryPanel() {
        Logger.getInstance().info("Shop by Category panel opening");
        homePage.openProductByName("HTC Touch HD");
        homePage.openShopByCategoryMenu();
    }

    @When("user opens {string} category")
    public void openCategoryByName(String category) {
        Logger.getInstance().info("Category opening");
        homePage.openShopCategory(category);
    }

    @When("user opens {string} product from Home page")
    public void openProductByProductName(String productName) {
        homePage.openProductByName(productName);
    }
}
