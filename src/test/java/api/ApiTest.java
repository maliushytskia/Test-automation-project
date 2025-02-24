package api;

import api.endpoints.Activities;
import api.endpoints.ProductEndpoint;
import core.Logger;
import io.restassured.response.Response;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ProductCategory;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class ApiTest {
    private static final String BASE_URL = "https://fakerestapi.azurewebsites.net/api/v1/";
    private static final String BASE_STORE_URL = "https://ecommerce-playground.lambdatest.io/index.php?route=";
    private static final String ACTIVITIES_ENDPOINT = "Activities";
    private static final String PRODUCTS_BY_COMPONENT_ENDPOINT = "product/category&path=";
    private static final String ADD_PRODUCT_TO_CART_ENDPOINT = "checkout/cart/add";

    @Test
    @DisplayName("Test products by category are present")
    public void getProductsByCategoryTest() {
        Elements products = ProductEndpoint.getProductsByCategory(ProductCategory.COMPONENTS.getCategoryId(), 200);
        Assertions.assertFalse(products.isEmpty(), "No products found on the page");
        Logger.getInstance().info("Checking that product is present in HTML response..");
    }

    @Test
    @DisplayName("Test product by particular category is present")
    public void getProductByCategoryTest() {
        Elements products = ProductEndpoint.getProductsByCategory(ProductCategory.COMPONENTS.getCategoryId(), 200);
        Assertions.assertTrue(ProductEndpoint.isProductPresentInHtmlResponse("HTC Touch HD", products));
    }

    @Test
    @DisplayName("Add product to cart")
    public void addProductToCart() {

    }

    @Test
    public void testGetActivities() {
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .get(ACTIVITIES_ENDPOINT)
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        int id = response.jsonPath().getInt("id");
        Map<String, ?> title = response.jsonPath().getMap("");

        Assertions.assertEquals(1, id);
        // Assertions.assertEquals(, title);
    }

    @Test
    @DisplayName("Delete activity")
    public void deleteActivity() {
        String url = "https://fakerestapi.azurewebsites.net/api/v1/Activities/1";
        Response response = Activities.doDeleteRequest();
        response
                .then()
                .statusCode(200)
                .log();
    }
}
