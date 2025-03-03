package pages;

import core.Logger;
import core.elements.Button;
import org.openqa.selenium.By;

public class ConfirmOrderPage extends BasePage {
    private final Button CONFIRM_ORDER = new Button(
            By.xpath("//button[@id='button-confirm']"), "Confirm Order");

    public ConfirmOrderPage() {
        super(By.xpath("//h1[.='Confirm Order']"), "Confirm Order");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }

    public void clickConfirmOrder() {
        CONFIRM_ORDER.clickOnElement();
    }
}
