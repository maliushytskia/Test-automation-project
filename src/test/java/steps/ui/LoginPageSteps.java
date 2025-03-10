package steps.ui;

import core.Logger;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

public class LoginPageSteps {
    private LoginPage loginPage;

    @When("Login Page is opened")
    public void loginPageOpened() {
        Logger.getInstance().info("Login page opening");
        loginPage = new LoginPage();
    }

    @When("user specifies email {string} and password {string}")
    public void specifyCredentials(String email, String password) {
        Logger.getInstance().info(
                String.format("User specifies email %s and password %s on Login page", email, password));
        loginPage.specifyCustomerCredentials(email, password);
    }

    @When("user clicks Login button")
    public void clickLogin() {
        loginPage.clickOnLogin();
    }

    @When("user see validation message for invalid credentials")
    public void checkValidationForInvalidCredentials() {
        String expectedValidationMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assertions.assertEquals(expectedValidationMessage, loginPage.getValidationMessage());
    }

    @When("user removes specified email")
    public void removeEnteredEmail() {
        loginPage.eraseLoginField();
    }

    @When("user removes specified password")
    public void removeEnteredPassword() {
        loginPage.erasePasswordField();
    }
}
