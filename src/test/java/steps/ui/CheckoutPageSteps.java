package steps.ui;

import core.Logger;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CheckoutPage;

public class CheckoutPageSteps {
    private CheckoutPage checkoutPage;

    @When("Checkout page is opened")
    public void checkoutPageOpened() {
        Logger.getInstance().info("Checkout Page opening");
        checkoutPage = new CheckoutPage();
    }

    @When("^user accepts Privacy Policy")
    public void acceptPrivacyPolicy() {
        checkoutPage.checkPrivacyPolicyCheckbox();
    }

    @When("user accepts Terms and Conditions")
    public void acceptTermsAndConditions() {
        checkoutPage.checkTermsAndConditionsCheckbox();
    }

    @And("user specifies user account data for the following fields:")
    public void setUserAccountData(DataTable table) {
        Logger.getInstance().info("Filling user account data");
        checkoutPage.fillInUserAccountData(table);
    }

    @And("user clicks Continue button on Checkout page")
    public void clickContinueButton() throws InterruptedException {
        checkoutPage.clickContinue();
    }
}
