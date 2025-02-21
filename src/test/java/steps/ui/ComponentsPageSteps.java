package steps.ui;

import core.Logger;
import io.cucumber.java.en.When;
import pages.shoppingCategories.ComponentsPage;

public class ComponentsPageSteps {
    private ComponentsPage componentsPage;

    @When("Components page is opened")
    public void componentsPageOpened() {
        Logger.getInstance().info("Components Page opening");
        componentsPage = new ComponentsPage();
    }

    @When("user opens {string} product from Components page")
    public void openProductByProductName(String productName) {
        Logger.getInstance().info("Opening product");
        componentsPage.openProductByName(productName);
    }

}
