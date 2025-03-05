package pages;

import core.Logger;
import core.elements.BaseElement;
import core.elements.Button;
import core.elements.CheckBox;
import core.elements.TextField;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import core.TestDataProvider;

import java.util.*;

public class CheckoutPage extends BasePage {
    private final CheckBox PRIVACY_POLICY = new CheckBox(
            By.xpath("//label[@for='input-account-agree']"), "Privacy Policy");
    private final CheckBox TERMS_AND_CONDITIONS = new CheckBox(
            By.xpath("//label[@for='input-agree']"), "Terms & Conditions");
    private final TextField FIRST_NAME = new TextField(
            By.xpath("//input[@id='input-payment-firstname']"), "First Name");
    private final TextField LAST_NAME = new TextField(
            By.xpath("//input[@id='input-payment-lastname']"), "Last Name");
    private final TextField E_MAIL = new TextField(
            By.xpath("//input[@id='input-payment-email']"), "E-Mail");
    private final TextField TELEPHONE = new TextField(
            By.xpath("//input[@id='input-payment-telephone']"), "Telephone");
    private final TextField PASSWORD = new TextField(
            By.xpath("//input[@id='input-payment-password']"), "Password");
    private final TextField PASSWORD_CONFIRM = new TextField(
            By.xpath("//input[@id='input-payment-confirm']"), "Password Confirm");
    private final TextField ADDRESS_1 = new TextField(
            By.xpath("//input[@id='input-payment-address-1']"), "Address 1");
    private final TextField CITY = new TextField(
            By.xpath("//input[@id='input-payment-city']"), "City");
    private final TextField POST_CODE = new TextField(
            By.xpath("//input[@id='input-payment-postcode']"), "Post Code");
    private final Button CONTINUE = new Button(
            By.xpath("//button[@id='button-save']"), "Continue");

    public CheckoutPage() {
        super(By.xpath("//h4[@class='card-title' and text()='Account']"), "Checkout page");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }

    public void checkPrivacyPolicyCheckbox() {
        Logger.getInstance().info(String.format("Clicking on checkbox: %s", PRIVACY_POLICY.getName()));
        if (!PRIVACY_POLICY.isChecked()) {
            PRIVACY_POLICY.clickOnElement();
        }
    }

    public void checkTermsAndConditionsCheckbox() {
        Logger.getInstance().info(String.format("Clicking on checkbox: %s", TERMS_AND_CONDITIONS.getName()));
        if (!TERMS_AND_CONDITIONS.isChecked()) {
            TERMS_AND_CONDITIONS.clickOnElement();
        }
    }

    public void fillInUserAccountData(DataTable table) {
        List<Map<String, String>> fields = table.asMaps(String.class, String.class);
        Set<BaseElement> elements = new HashSet<>(
                Arrays.asList(
                        FIRST_NAME,
                        LAST_NAME,
                        E_MAIL,
                        TELEPHONE,
                        PASSWORD,
                        PASSWORD_CONFIRM,
                        ADDRESS_1,
                        CITY,
                        POST_CODE));

        for (BaseElement element : elements) {
            for (Map<String, String> field : fields) {
                for (Map.Entry<String, String> entry : field.entrySet()) {
                    if (Objects.equals(element.getName(), entry.getKey())) {
                        if (element.getName().equals("E-Mail") && entry.getValue().equals("{generateEmail}")) {
                            element.getElement().sendKeysToElement(TestDataProvider.getTestEmail());
                        } else {
                            Logger.getInstance().info(
                                    String.format("Filling field: %s with value: %s", entry.getKey(), entry.getValue()));
                            element.getElement().sendKeysToElement(entry.getValue());
                        }
                    }
                }
            }
        }
    }

    public void clickContinue() {
        Logger.getInstance().info(String.format("Clicking on button: %s", CONTINUE.getName()));
        CONTINUE.clickOnElementWithScroll();
    }
}
