package pages;

import core.Logger;
import core.elements.Button;
import core.entities.Product;
import core.elements.Grid;
import org.openqa.selenium.By;

public class ProductsListPage extends BasePage implements pages.components.Product {
    private final Button FILTERS_BY_CATEGORY =
            new Button(
                    By.xpath("//div[contains(@class,'content-refine-search')]//a"),
                    "Product category filters"
            );

    public ProductsListPage() {
        super(By.xpath("//h3[.='Filter']"), "Products list page");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }

    public String getProductName(String productName) {
        Logger.getInstance().info(String.format("Doing search for %s product", productName));
        Grid grid = new Grid(By.xpath("//div[contains(@class,'product-layout product-grid')]"), "Products table");
        return grid.getTableData().stream().map(Product::getName).filter(n -> n.equals(productName))
                .findFirst().orElse("No products are found for specified criteria");
    }

    public void navigateToPage(int pageNumber) {
        Button pagination = new Button(By.xpath(
                String.format("//ul[@class='pagination']//a[contains(@href,'page=%s')]", pageNumber)),
                String.format("Pagination page %s", pageNumber));
        pagination.clickOnElement();
    }
}