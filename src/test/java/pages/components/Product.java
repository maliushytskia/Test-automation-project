package pages.components;

import core.elements.Label;
import core.elements.TextField;
import org.openqa.selenium.By;

public interface Product {
    default void openProductByName(String productName) {
        Label productLabel = new Label(By.xpath("//a[text()='" + productName + "']"), productName);
        productLabel.clickOnElement();
    }

    default String getProductTitle() {
        Label productTitle =
                new Label(By.xpath("//div[@class='entry-content content-title ']"), "Product title");
        return productTitle.getName();
    }

    default boolean isProductCategoryDescriptionPresent(TextField description) {
        return description.isElementPresent();
    }
}
