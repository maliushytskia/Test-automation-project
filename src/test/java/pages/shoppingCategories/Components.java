package pages.shoppingCategories;

import core.elements.Label;
import core.elements.TextField;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.components.Product;

public class Components extends BasePage implements Product {
    private static final TextField PRODUCT_CATEGORY_DESCRIPTION = new TextField(
            By.xpath("class='entry-content content-description '"),"Product category description");

    public Components() {
        super(By.xpath("//h1[text()='Components']"), "Components");
    }

    public StringBuilder openProductByProductName(String productName) {
        Label productLabel = new Label(By.xpath("//a[text()='HTC Touch HD']"), productName);
        StringBuilder builder = new StringBuilder("Test");
        return builder;
    }


}
