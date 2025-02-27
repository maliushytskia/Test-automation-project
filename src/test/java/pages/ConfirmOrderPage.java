package pages;

import core.Logger;
import org.openqa.selenium.By;

public class ConfirmOrderPage extends BasePage {
    public ConfirmOrderPage() {
        super(By.xpath("//h1[.='Confirm Order']"), "Confirm Order");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }
}
