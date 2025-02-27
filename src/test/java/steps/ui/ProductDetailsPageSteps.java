package steps.ui;

import core.Browser;
import core.Logger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.ProductDetailsPage;

import java.time.Duration;

public class ProductDetailsPageSteps {
    private ProductDetailsPage productDetailsPage;

    @When("Product Details page is opened")
    public void productDetailsOpened() {
        Logger.getInstance().info("Product Details Page opening");
        productDetailsPage = new ProductDetailsPage();
    }

    @When("Product can't be added to the basket by {string} button as {string}")
    public void checkAddToCartButtonWithOutOfStockProduct(String buttonName, String buttonState) {
        Logger.getInstance().info(String.format("Checking that %s button is %s", buttonName, buttonState));
        Assertions.assertEquals(buttonState, productDetailsPage.getButtonState(buttonName));
    }

    @When("user navigates to {string} shopping category list page")
    public void navigateToShoppingCategoryViaBreadcrumbs(String category) {
        Logger.getInstance().info(String.format("Navigating to %s category", category));
        productDetailsPage.navigateToShoppingCategoryBreadcrumbs(category);
    }

    @And("user clicks Buy Now button on Product Details page")
    public void clickBuyNowButtonOnProductDetailsPage() {
        productDetailsPage.clickOnBuyNow();
    }
}
