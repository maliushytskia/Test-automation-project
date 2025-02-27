package core.elements;

import core.Browser;
import core.Logger;
import core.entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Grid extends BaseElement {
    public Grid(By locator, String name) {
        super(locator, name);
    }

    public List<Product> getTableData() {
        isElementPresent();
        List<WebElement> productElements = Browser.getDriver().findElements(this.getLocator());
        List<Product> products = new ArrayList<>();
        for (WebElement productElement : productElements) {
            String name = productElement.findElement(By.xpath(
                    ".//h4/a")).getText();
            double price = 0.0;
            try {
                price = Double.parseDouble(productElement.findElement(By.xpath(
                                ".//div[@class='price']/span"))
                        .getText().replaceAll("[^\\d.]", ""));
            } catch (NumberFormatException e) {
                Logger.getInstance().warn("Price is not valid " + e.getMessage());
            }
            products.add(new Product.ProductBuilder().withName(name).withPrice(price).build());
        }
        return products;
    }
}
