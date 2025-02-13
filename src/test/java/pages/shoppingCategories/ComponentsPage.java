package pages.shoppingCategories;

import core.Logger;
import core.elements.Button;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.components.Product;

public class ComponentsPage extends BasePage implements Product {
    private final Button ADD_TO_CARD =
            new Button(By.xpath(
                    "//div[@id='entry_216840']//child::button[@title='Add to Cart']"),
                    "Add to card");

    private final Button BUY_NOW =
            new Button(By.xpath(
                    "//div[@id='entry_216840']//child::button[@title='Buy now']"),
                    "Buy now");

    public ComponentsPage() {
        super(By.xpath("//h1[text()='Components']"), "Components");
        Logger.getInstance().info(String.format("%s is opened", Class.class.getName()));
    }

    public String getButtonState(String buttonName) {
        Button button = new Button(By.xpath(
                "//div[@id='entry_216840']//child::button[@title='" + buttonName + "']"),
                "ButtonName");
        return button.findElement().getText();
    }
}
