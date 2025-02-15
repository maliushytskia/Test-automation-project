package pages.shoppingCategories;

import core.Logger;
import core.elements.Button;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.components.Product;

public class ComponentsPage extends BasePage implements Product {


    public ComponentsPage() {
        super(By.xpath("//h1[text()='Components']"), "Components");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }


}
