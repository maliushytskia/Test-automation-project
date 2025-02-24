package api.endpoints;

import core.Logger;
import core.entities.Product;
import io.cucumber.datatable.DataTable;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import utils.PropertyProvider;

import java.util.List;
import java.util.Map;

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

        if (StringUtils.isEmpty(response)) {
            Logger.getInstance().warn("Given response is empty or null: " + response);
            return null;
        }
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

    public static boolean isProductPresentInHtmlResponse(String productName, Elements elements) {
        Logger.getInstance().info(String.format("Checking %s product is present in HTML response..", productName));
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

    public static Elements getProductById(int productId, int statusCode) {
        Logger.getInstance().info("Getting products from HTML by product id..");
        String response = given()
                .baseUri(PropertyProvider.urlProperties.getProperty("api.products")).log().all()
                .queryParam("route", "product/product")
                .queryParam("product_id", productId)
                .when()
                .get()
                .then()
                .statusCode(statusCode)
                .extract()
                .body()
                .asString();

        if (StringUtils.isEmpty(response)) {
            Logger.getInstance().warn("Given response is empty or null: " + response);
            return null;
        }
        return parseHtmlResponseByCss(response, ".entry-col.col-12.col-md-6.order-1.flex-column");
    }

    public static Product getProductFromHTML(Elements element) {
        Logger.getInstance().info("Getting product from HTML..");
        Product product;
        try {
            product = element.stream().map(p -> {
                String title = p.select(".entry-content.content-title > h1").text();
                double price = Double.parseDouble(
                        p.selectXpath("//div[@class='entry-content content-price ']/descendant::h3").text()
                        .replaceAll("[^\\d.]", ""));
                Elements productCode = p.selectXpath("//span[.='Product Code:']/following::span[1]");
                Elements brand = p.selectXpath("//span[.='Brand:']/following::a[1]");
                Elements availability = p.selectXpath("//span[.='Availability:']/following::span[1]");
                return new Product
                        .ProductBuilder()
                        .withName(title)
                        .withPrice(price)
                        .withProductCode(productCode.text())
                        .withBrand(brand.text())
                        .withAvailability(availability.text())
                        .build();
            }).findFirst().orElse(null);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to get product from the HTML: " + e);
        }
        if (product != null) {
            return product;
        }
        throw new RuntimeException("Product wasn't created");
    }

    public static Product getProductFromDataTable(DataTable dataTable) {
        List<Map<String, String>> fields = dataTable.asMaps(String.class, String.class);
        Product expectedProduct = null;
        for (Map<String, String> field : fields) {
            expectedProduct = new Product.ProductBuilder()
                    .withName(field.get("name"))
                    .withPrice(Double.parseDouble(field.get("price")))
                    .withProductCode(field.get("code"))
                    .withBrand(field.get("brand"))
                    .withAvailability(field.get("availability"))
                    .build();
        }
        return expectedProduct;
    }
}
