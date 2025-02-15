package pages;

import core.Logger;
import core.elements.Banner;
import core.elements.Button;
import org.openqa.selenium.By;
import pages.components.Product;

public class HomePage extends BasePage implements Product {
    private final static Banner MAIN_UPPER_BANNER =
            new Banner(By.xpath("//div[@id='entry_217960']"), "Main upper banner");
    private static final Button SHOP_BY_CATEGORY =
            new Button(By.xpath("//div[@data-id='217832']/child::a[@role='button']"),
                    "Shop by category");

    public HomePage() {
        super(By.xpath("//a[@title='Poco Electro']"), "Home Page");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }

    public HomePage openShopByCategoryMenu() {
        SHOP_BY_CATEGORY.click();
        return this;
    }

    public HomePage openShopCategory(String categoryName) {
        Button element = new Button(By.xpath
                ("//div[@class='info']//span[normalize-space(text()) = '" + categoryName + "']"), categoryName);
        element.click();
        return this;
    }

}
