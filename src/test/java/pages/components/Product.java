package pages.components;

import core.elements.Label;
import org.openqa.selenium.By;

public interface Product {
    default void openProductByName(String productName) {
        Label productLabel = new Label(By.xpath("//a[text()='" + productName + "']"), productName);
        productLabel.clickOnElement();
    }
}
