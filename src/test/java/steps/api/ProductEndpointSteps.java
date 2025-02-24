package steps.api;

import api.endpoints.ProductEndpoint;
import core.Logger;
import core.entities.Product;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import utils.ProductCategory;

public class ProductEndpointSteps {
    private Elements products;
    private Product product;

    @Given("user gets products by product category {string} and expects {int} code")
    public void getProductsByProductCategoryStep(String productCategory, int statusCode) {
        Logger.getInstance().info("Getting product from HTML response..");
        products = ProductEndpoint.getProductsByCategory(ProductCategory.fromString(productCategory).getCategoryId(), statusCode);
    }

    @Then("user checks that Products are present in the list")
    public void checkPresenceOfProductStep() {
        Logger.getInstance().info("Checking product from HTML response..");
        Assertions.assertFalse(this.products.isEmpty(), "No products found on the page");
    }

    @Then("user checks that {string} product is present in the list")
    public void checkProductByCategoryStep(String productName) {
        Assertions.assertTrue(ProductEndpoint.isProductPresentInHtmlResponse(productName, products));
    }

    @Given("user gets product by product ID {int}")
    public void userGetsProductByProductIdStep(int productId) {
        Logger.getInstance().info(String.format("Getting product by product id %s from HTML response..", productId));
        products = ProductEndpoint.getProductById(productId, 200);
    }

    @Given("user gets product object from HTML")
    public void userGetsProductObjectFromHtml() {
        Logger.getInstance().info("Getting product by from HTML response..");
        product = ProductEndpoint.getProductFromHTML(products);
    }

    @Then("user checks product details for the following fields:")
    public void userChecksProductDetailsForTheFollowingFields(DataTable table) {
        Product expectedProduct = ProductEndpoint.getProductFromDataTable(table);
        System.out.println(expectedProduct);
        System.out.println(product);
        Assertions.assertEquals(expectedProduct, product);
    }
}

