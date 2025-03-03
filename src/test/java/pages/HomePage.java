package pages;

import core.Logger;
import core.elements.Button;
import core.elements.TextField;
import org.openqa.selenium.By;
import pages.components.Product;

public class HomePage extends BasePage implements Product {
    private final Button MY_ACCOUNT = new Button(
            By.xpath("//a[@role='button']/following::span[normalize-space(text())='My account']"),
            "My Account");
    private final Button SHOP_BY_CATEGORY =
            new Button(By.xpath("//div[@data-id='217832']/child::a[@role='button']"),
                    "Shop by category");
    private final TextField SEARCH_BAR = new TextField(
            By.xpath("//input[contains(@data-autocomplete,'5')]"), "Search Bar");
    private final Button SEARCH = new Button(
            By.xpath("//button[.='Search']"), "Search button");
    private final Button OPEN_LOGIN = new Button(
            By.xpath("//span[normalize-space(text())='Login']"), "Login");

    public HomePage() {
        super(By.xpath("//a[@title='Poco Electro']"), "Home Page");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }

    public void openShopByCategoryMenu() {
        SHOP_BY_CATEGORY.clickOnElement();
    }

    public void openShopCategory(String categoryName) {
        Button element = new Button(By.xpath
                ("//div[@class='info']//span[normalize-space(text()) = '" + categoryName + "']"), categoryName);
        element.clickOnElement();
    }

    public void fillInSearchBar(String searchInput) {
        SEARCH_BAR.getElement().sendKeysToElement(searchInput);
    }

    public void clickSearch() {
        SEARCH.clickOnElement();
    }

    public void openLoginPage() {
        MY_ACCOUNT.hoveringOverWebElement();
        OPEN_LOGIN.clickOnElement();
    }

}
