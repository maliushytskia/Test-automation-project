package steps.ui;

import core.Logger;
import io.cucumber.java.en.When;
import pages.AccountPage;

public class AccountPageSteps {
    private AccountPage accountPage;

    @When("Account page is opened")
    public void openAccountPage() {
        Logger.getInstance().info("Account page opening");
        accountPage = new AccountPage();
    }
}
