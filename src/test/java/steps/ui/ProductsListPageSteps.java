package steps.ui;

import core.Logger;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.ProductsListPage;

public class ProductsListPageSteps {
    private ProductsListPage productsListPage;

    @When("Products List Page is opened")
    public void productsListPageOpened() {
        Logger.getInstance().info("Products List Page opening");
        productsListPage = new ProductsListPage();
    }

    @When("{string} product is present on the Products List Page")
    public void isProductPresentOnProductsListPage(String productName) {
        Assertions.assertEquals(productName, productsListPage.getProductName(productName));
    }
}
