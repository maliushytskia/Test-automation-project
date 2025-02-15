package pages;

import core.elements.Button;
import core.elements.Product;
import core.elements.Grid;
import org.openqa.selenium.By;

public class ProductsListPage extends BasePage {
    private final Button FILTERS_BY_CATEGORY =
            new Button(
                    By.xpath("//div[contains(@class,'content-refine-search')]//a"),
                    "Product category filters"
            );
    private final Grid grid = new Grid(By.xpath("//div[contains(@data-grid,'product-layout product-grid')]"), "Products table");

    public ProductsListPage() {
        super(By.xpath("//table[@class='table']"), "Products list page");
    }

    public String getProduct(String productName) {
        return grid.getTableData().stream().map(Product::getName).anyMatch(productName);
    }
}
