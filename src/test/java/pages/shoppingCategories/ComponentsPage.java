package pages.shoppingCategories;

import core.Logger;
import core.elements.Label;
import core.elements.TextField;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.components.Product;

public class ComponentsPage extends BasePage implements Product {
    private static final TextField PRODUCT_CATEGORY_DESCRIPTION = new TextField(
            By.xpath("class='entry-content content-description '"),"Product category description");

    public ComponentsPage() {
        super(By.xpath("//h1[text()='Components']"), "Components");
        Logger.getInstance().info(String.format("%s is opened", Class.class.getName()));
    }
}
