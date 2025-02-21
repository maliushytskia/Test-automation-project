package api.endpoints;

import core.Logger;
import core.entities.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import utils.PropertyProvider;

import java.util.List;

import static io.restassured.RestAssured.given;


public class ProductEndpoint {
    public static Elements getProductsByCategory(String categoryId, int statusCode) {
        Logger.getInstance().info("Getting products from HTML by category..");
        String response = given()
                .baseUri(PropertyProvider.urlProperties.getProperty("api.products")).log().all()
                .queryParam("route", "product/category")
                .queryParam("path", categoryId)
                .when()
                .get()
                .then()
                .statusCode(statusCode)
                .extract()
                .body()
                .asString();

        return parseHtmlResponseByCss(response, ".product-layout .product-thumb");
    }

    public static List<Product> getProductsFromHTML(Elements elements) {
        Logger.getInstance().info("Getting products from HTML..");
        return elements.stream().map(product -> {
            String title = product.select(".title").text();
            double price = Double.parseDouble(product.select(".price").text()
                    .replaceAll("[^\\d.]", ""));
            return new Product
                    .ProductBuilder()
                    .withName(title)
                    .withPrice(price)
                    .build();
        }).toList();
    }

    public static boolean isProductPresentInHtmlResponse(String productName, String categoryId) {
        Logger.getInstance().info("Checking that product is present in HTML response..");
        return getProductsFromHTML(getProductsByCategory(categoryId, 200))
                .stream()
                .map(Product::getName)
                .anyMatch(n -> n.equals(productName));
    }

    public static boolean isProductPresentInHtmlResponse(String productName, Elements elements) {
        Logger.getInstance().info("Checking that product is present in HTML response..");
        return getProductsFromHTML(elements)
                .stream()
                .map(Product::getName)
                .anyMatch(n -> n.equals(productName));
    }

    private static Elements parseHtmlResponseByCss(String documentToParse, String cssLocator) {
        Logger.getInstance().info("Parsing HTML response by CSS selector");
        Document document = Jsoup.parse(documentToParse);
        return document.select(cssLocator);
    }
}
