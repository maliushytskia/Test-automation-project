package steps.ui;

import core.Logger;
import io.cucumber.java.en.When;
import pages.SuccessPage;

public class SuccessPageSteps {
    private SuccessPage successPage;

    @When("Success page is opened")
    public void openSuccessPage() {
        Logger.getInstance().info("Confirm Page opening");
        successPage = new SuccessPage();
    }

    @When("user clicks on Continue button at Success page")
    public void clickContinueAtSuccessPage() {
        Logger.getInstance().info("User clicking on Continue button on Success page");
        successPage.clickContinue();
    }

}
