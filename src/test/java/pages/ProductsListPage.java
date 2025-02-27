package pages;

import core.Logger;
import core.elements.Button;
import core.entities.Product;
import core.elements.Grid;
import org.openqa.selenium.By;

import static io.restassured.RestAssured.given;

public class ProductsListPage extends BasePage {
    private final Button FILTERS_BY_CATEGORY =
            new Button(
                    By.xpath("//div[contains(@class,'content-refine-search')]//a"),
                    "Product category filters"
            );

    public ProductsListPage() {
        super(By.xpath("//table[contains(@class,'table')]"), "Products list page");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }

    public String getProductName(String productName) {
        Grid grid = new Grid(By.xpath("//div[contains(@class,'product-layout product-grid')]"), "Products table");
        return grid.getTableData().stream().map(Product::getName).filter(n -> n.equals(productName))
                .findFirst().orElse(null);
    }

    public void navigateToPage(int pageNumber) {
        Button pagination = new Button(By.xpath(
                String.format("//ul[@class='pagination']//a[contains(@href,'page=%s')]", pageNumber)),
                String.format("Pagination page %s", pageNumber));
        pagination.clickOnElement();
    }
}