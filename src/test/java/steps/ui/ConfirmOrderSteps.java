package steps.ui;

import core.Logger;
import io.cucumber.java.en.When;
import pages.ConfirmOrderPage;

public class ConfirmOrderSteps {
    private ConfirmOrderPage confirmOrderPage;

    @When("Confirm Order page is opened")
    public void confirmPageOpened() {
        Logger.getInstance().info("Confirm Page opening");
        confirmOrderPage = new ConfirmOrderPage();
    }

    @When("user clicks Confirm Order button")
    public void clickConfirmOrder() {
        Logger.getInstance().info("User clicking on Confirm Order");
        confirmOrderPage.clickConfirmOrder();
    }
}
