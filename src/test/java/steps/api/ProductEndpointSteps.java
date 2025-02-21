package steps.api;

import api.endpoints.ProductEndpoint;
import core.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import utils.ProductCategory;

public class ProductEndpointSteps {
    private Elements elements;

    @Given("user gets products by product category {string} and expects {int} code")
    public void getProductsByProductCategory(String productCategory, int statusCode) {
        Logger.getInstance().info("Getting product from HTML response..");
        elements = ProductEndpoint.getProductsByCategory(ProductCategory
                .fromString(productCategory)
                .getCategoryId(), statusCode);
    }

    @Then("user checks that Products are present in the list")
    public void checkPresenceOfProduct() {
        Logger.getInstance().info("Checking product from HTML response..");
        Assertions.assertFalse(this.elements.isEmpty(), "No products found on the page");
    }

}

