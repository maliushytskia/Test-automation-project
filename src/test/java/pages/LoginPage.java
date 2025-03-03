package pages;

import core.Logger;
import core.elements.Button;
import core.elements.Label;
import core.elements.TextField;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final TextField EMAIL_ADDRESS = new TextField(
            By.xpath("//input[@id='input-email']"), "E-Mail Address");
    private final TextField PASSWORD = new TextField(
            By.xpath("//input[@id='input-password']"), "Password");
    private final Button LOGIN = new Button(
            By.xpath("//input[@type='submit']"), "Login");
    private final Label WARNING_INVALID_CREDENTIALS = new Label(
            By.xpath("//div[contains(@class,'alert-danger')]"),
            "Warning message for invalid credentials");

    public LoginPage() {
        super(By.xpath("//h2[.='Returning Customer']"), "Login Page");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }

    public void specifyCustomerCredentials(String email, String password) {
        EMAIL_ADDRESS.sendKeysToElement(email);
        PASSWORD.sendKeysToElement(password);
    }

    public void clickOnLogin() {
        LOGIN.clickOnElement();
    }

    public String getValidationMessage() {
        return WARNING_INVALID_CREDENTIALS.getElement().getWebElementText();
    }
}
